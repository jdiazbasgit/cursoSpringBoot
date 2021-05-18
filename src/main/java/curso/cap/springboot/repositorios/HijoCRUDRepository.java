package curso.cap.springboot.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.cap.springboot.entidades.Hijo;

public interface HijoCRUDRepository extends CrudRepository<Hijo, Integer> {
	
	//@Query(value = "select * from hijos  h where h.chicos=:chico",nativeQuery = true)
	@Query(value = "from Hijo h where h.chi=:chico")
	public List<Hijo> getHijoByChicos(int chico);

}
