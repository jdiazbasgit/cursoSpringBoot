package curso.cap.springboot.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.cap.springboot.entidades.DatoPersonal;
import curso.cap.springboot.entidades.Empleado;

public interface DatoPersonalCrudRepository extends CrudRepository<DatoPersonal,  Integer> {

}
