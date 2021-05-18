package curso.cap.springboot.entidades;

import java.sql.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dtos_laborales")
public class DatoLaboral {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int salario;
	
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(GregorianCalendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	private GregorianCalendar fechaAlta;
		
	@ManyToOne
	@JoinColumn(name = "cargos_id")
	private Cargo cargo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}