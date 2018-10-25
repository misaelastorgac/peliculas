package repositorio;

import entidades.pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface peliculaRepositorio extends JpaRepository<pelicula, Long> {
	
	

}