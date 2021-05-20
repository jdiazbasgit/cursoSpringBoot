package curso.cap.springboot.controladores;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.cap.springboot.DTOs.User;
import curso.cap.springboot.entidades.Usuario;
import curso.cap.springboot.repositorios.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class SecurityController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/login")
	public Optional<User> getToken(@RequestParam String usuario, @RequestParam String clave) {

		User userdto= null;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Usuario user = getUsuarioRepository().findUserByUser(usuario);
		if (user.getUser().equals(usuario) && encoder.matches(clave, user.getPassword())) {

			String token=getJWTToken(usuario, user.getRol().getRol());
			userdto= new User();
			userdto.setUsuario(usuario);
			userdto.setRol(user.getRol().getRol());
			userdto.setToken(token);
		}

		return Optional.ofNullable(userdto);
	}
	
	
	private String getJWTToken(String username, String rol) {
		String secretKey = "cursocap";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(rol);
		
		String token = Jwts
				.builder()
				.setId("cursoJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

}
