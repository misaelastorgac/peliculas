package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.pelicula;
import repositorio.peliculaRepositorio;

@Service
public class peliculaDAO {
	
	@Autowired
	peliculaRepositorio peliculaRepositorio;
	
	
	// Gurdando una pelicula
	
	public pelicula save(pelicula pel) {
		return peliculaRepositorio.save(pel);
		
	}
	
	//Traer todas las peliculas
	public List<pelicula> findAll(){
		return peliculaRepositorio.findAll();
		
	}
	
	//Buscar una pelicula
	public pelicula findOne(Long pelid) {
		return peliculaRepositorio.findOne(pelid);
	}
	
	public void delete(pelicula pel) {
		peliculaRepositorio.delete(pel);
	}
	

}
