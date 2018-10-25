package entidades;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="pelicula")
@EntityListeners(AuditingEntityListener.class)


public class pelicula {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    @NotBlank
	private String titulo;
    @NotBlank
	private String anio;
    @NotBlank
	private String director;
    @NotBlank
	private double calificacion;
    @NotBlank
	private Long adultos;
    @NotBlank
	private String overview;
    @NotBlank
	private String lenguajeOriginal;
    @NotBlank
	private String poster;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	public Long getAdultos() {
		return adultos;
	}
	public void setAdultos(Long adultos) {
		this.adultos = adultos;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getLenguajeOriginal() {
		return lenguajeOriginal;
	}
	public void setLenguajeOriginal(String lenguajeOriginal) {
		this.lenguajeOriginal = lenguajeOriginal;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}

	
	
	
	

}
