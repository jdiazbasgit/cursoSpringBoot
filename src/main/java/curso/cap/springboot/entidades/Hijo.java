package curso.cap.springboot.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "hijos")
public class Hijo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "chicos")
	private int chi;
	
	
	private int chicas;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getChi() {
		return chi;
	}

	public void setChi(int chi) {
		this.chi = chi;
	}

	public int getChicas() {
		return chicas;
	}

	public void setChicas(int chicas) {
		this.chicas = chicas;
	}
}
