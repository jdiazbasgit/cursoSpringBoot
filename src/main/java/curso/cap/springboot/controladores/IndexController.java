package curso.cap.springboot.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.cap.springboot.beans.Persona;
import curso.cap.springboot.entidades.DatoPersonal;
import curso.cap.springboot.entidades.Hijo;
import curso.cap.springboot.repositorios.DatoPersonalCrudRepository;
import curso.cap.springboot.repositorios.EmpleadoCrudRepository;
import curso.cap.springboot.repositorios.HijoCRUDRepository;

@Controller
public class IndexController {

	@Autowired
	private HijoCRUDRepository repository;

	@Autowired
	private EmpleadoCrudRepository empleadoRepository;

	@Autowired
	private DatoPersonalCrudRepository datoPersonalRepository;

	public DatoPersonalCrudRepository getDatoPersonalRepository() {
		return datoPersonalRepository;
	}

	public void setDatoPersonalRepository(DatoPersonalCrudRepository datoPersonalRepository) {
		this.datoPersonalRepository = datoPersonalRepository;
	}

	@GetMapping("/")
	public String index() {

		return "index";
	}

	@GetMapping("/personas")
	public ModelAndView getPersonas() {
		ModelAndView modelAndView = new ModelAndView("personas");

		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("pepe", "mi casa", "9987654", 25));
		personas.add(new Persona("luis", "calle pez", "9987654", 35));
		personas.add(new Persona("fernando", "calle Alcalá", "9987654", 15));
		personas.add(new Persona("andres", "mi calle", "9987654", 40));

		modelAndView.addObject("personas", personas);
		return modelAndView;

	}

	@GetMapping("/hijosController")
	public ModelAndView getHijos() {

		// Iterable<Hijo> hijos=getRepository().findAll();

		/*
		 * for (Hijo hijo : hijos) {
		 * System.out.println(hijo.getChicos()+" - "+hijo.getChicas()); }
		 */
		System.out.println(
				getRepository().findById(5).get().getChicas() + " - " + getRepository().findById(5).get().getChi());
		Hijo hijo = getRepository().findById(5).get();

		DatoPersonal datoPersonal = new DatoPersonal();
		datoPersonal.setId(51);
		datoPersonal.setEstadoCivil("soltero");
		datoPersonal.setHijo(hijo);

		getDatoPersonalRepository().save(datoPersonal);

		getDatoPersonalRepository().findById(1);

		List<Hijo> hijosPorChicos = getRepository().getHijoByChicos(1);
		System.out.println("------------ consultas mias ---------");
		for (Hijo hijo1 : hijosPorChicos) {
			System.out.println("id: "+hijo1.getId());
		}
		System.out.println("------ ver consulta no existe ---------");
		System.out.println(getRepository().existsById(1));

		return new ModelAndView("index");
	}

	public HijoCRUDRepository getRepository() {
		return repository;
	}

	public void setRepository(HijoCRUDRepository repository) {
		this.repository = repository;
	}

	public EmpleadoCrudRepository getEmpleadoRepository() {
		return empleadoRepository;
	}

	public void setEmpleadoRepository(EmpleadoCrudRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
}
