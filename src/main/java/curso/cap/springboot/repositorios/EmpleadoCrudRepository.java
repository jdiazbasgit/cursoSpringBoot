package curso.cap.springboot.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.cap.springboot.entidades.Empleado;

public interface EmpleadoCrudRepository extends CrudRepository<Empleado, Integer> {

}
