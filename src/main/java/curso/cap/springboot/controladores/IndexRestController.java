package curso.cap.springboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.cap.springboot.entidades.DatoPersonal;
import curso.cap.springboot.entidades.Empleado;
import curso.cap.springboot.entidades.Hijo;
import curso.cap.springboot.repositorios.DatoPersonalCrudRepository;
import curso.cap.springboot.repositorios.EmpleadoCrudRepository;
import curso.cap.springboot.repositorios.HijoCRUDRepository;

@RestController
public class IndexRestController {
	
	@Autowired
	private EmpleadoCrudRepository empleadoCrudRepository;
	
	@Autowired
	private HijoCRUDRepository hijoCrudRepository;
	
	
	@Autowired
	private DatoPersonalCrudRepository datoPersonaRepository;
	
	
	public DatoPersonalCrudRepository getDatoPersonaRepository() {
		return datoPersonaRepository;
	}


	public void setDatoPersonaRepository(DatoPersonalCrudRepository datoPersonaRepository) {
		this.datoPersonaRepository = datoPersonaRepository;
	}


	@GetMapping("/hijos")
	public Iterable<Hijo> getHijos(){
		return getHijoCrudRepository().findAll();
	}
	
	
	@GetMapping("/empleados")
	public Iterable<Empleado> getEmpleados() {
		
		Iterable<Empleado> empleados= getEmpleadoCrudRepository().findAll();
		
		return empleados;
		
	}
	
	@GetMapping("/datosPersonales")
	public  CollectionModel<DatoPersonal> getDatosPErsonales(){
		
		Iterable<DatoPersonal> datoPersonales=getDatoPersonaRepository().findAll();
		for (DatoPersonal datoPersonal : datoPersonales) {
			datoPersonal.add(Link.of("hijos").withRel("hijo").withHref("/hijo/"+datoPersonal.getHijo().getId()));
			datoPersonal.add(Link.of("/datoPersonal/"+datoPersonal.getId()).withSelfRel());
			
		}
		
		return CollectionModel.of(datoPersonales);
	}
	
	@GetMapping("hijo/{id}")
	public Hijo getHijoById(@PathVariable int id) {
		
		return getHijoCrudRepository().findById(id).get();
	}
	
	@GetMapping("datoPersonal/{id}")
	public EntityModel<DatoPersonal> getDatoPersonalById(@PathVariable int id) {
		
		DatoPersonal datoPersonal= getDatoPersonaRepository().findById(id).get();
		datoPersonal.add(Link.of("hijo").withRel("hijo").withHref("/hijo/"+datoPersonal.getHijo().getId()));
		datoPersonal.add(Link.of("/datoPersonal/"+datoPersonal.getId()).withRel("datoPersonal").withSelfRel());
		
		return  EntityModel.of(datoPersonal);
	}
	 
	@PostMapping("/empleados")
	public Empleado grabaEmpleado(@RequestBody Empleado empleado) {
		
		getEmpleadoCrudRepository().save(empleado);
		
		return empleado;
		
	}
	
	@DeleteMapping("/empleados/{id}")
	public String borraEmpleado(@PathVariable int id) {
		
		try {
			getEmpleadoCrudRepository().deleteById(id);
			return "OK";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "KO";
		}
		
		
		
	}
	
	@PostMapping("/hijo")
	public Hijo grabaHijo(@RequestBody Hijo hijo) {
		
		getHijoCrudRepository().save(hijo);
		
		return hijo;
		
	}
	
	@PatchMapping("/hijo")
	public Hijo modificaHijo(@RequestBody Hijo hijo) {
		
		getHijoCrudRepository().save(hijo);
		
		return hijo;
		
	}
	
	@PostMapping("/hijos/param")
	public Hijo grabaHijoParam(@RequestParam int chi, @RequestParam int chicas) {
		
		Hijo hijo= new Hijo();
		hijo.setChi(chi);
		hijo.setChicas(chicas);
		getHijoCrudRepository().save(hijo);
		return hijo;
	}
	

	public EmpleadoCrudRepository getEmpleadoCrudRepository() {
		return empleadoCrudRepository;
	}

	public void setEmpleadoCrudRepository(EmpleadoCrudRepository empleadoCrudRepository) {
		this.empleadoCrudRepository = empleadoCrudRepository;
	}

	public HijoCRUDRepository getHijoCrudRepository() {
		return hijoCrudRepository;
	}

	public void setHijoCrudRepository(HijoCRUDRepository hijoCrudRepository) {
		this.hijoCrudRepository = hijoCrudRepository;
	}

}
