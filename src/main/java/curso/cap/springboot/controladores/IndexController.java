package curso.cap.springboot.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import curso.cap.springboot.beans.Persona;

@Controller
public class IndexController {
	
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/personas")
	public ModelAndView getPersonas() {
		ModelAndView modelAndView= new  ModelAndView("personas");
		
		List<Persona> personas= new ArrayList<Persona>();
		personas.add(new Persona("pepe", "mi casa", "9987654", 25));
		personas.add(new Persona("luis", "calle pez", "9987654", 35));
		personas.add(new Persona("fernando", "calle Alcalá", "9987654", 15));
		personas.add(new Persona("andres", "mi calle", "9987654", 40));
		
		modelAndView.addObject("personas", personas);
		return modelAndView;
		
	}

}
