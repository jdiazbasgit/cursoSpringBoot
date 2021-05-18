package curso.cap.springboot.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "datos_personales")
public class DatoPersonal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	private String estadoCivil;
	
	@ManyToOne
	@JoinColumn(name = "hijos_id")
	private Hijo hijo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hijo getHijo() {
		return hijo;
	}

	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}
