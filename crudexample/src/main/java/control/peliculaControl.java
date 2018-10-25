package control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.peliculaDAO;
import entidades.pelicula;

@RestController
@RequestMapping("/directorio")
public class peliculaControl {
    @Autowired
	peliculaDAO peliculadao;
    
    //guardar una pelicula
    @PostMapping ("/peliculas")
    public pelicula crearPelicula(@Valid @RequestBody pelicula pel) {
    	return peliculadao.save(pel);
    }
    
    
    @GetMapping("/peliculas")
    public List<pelicula> getAllPeliculas(){
    	return peliculadao.findAll();
    }
   
    @GetMapping("/notes/{id}")
    public ResponseEntity<pelicula> getPeliculaById(@PathVariable(value="id")Long pelid){
    	pelicula pel = peliculadao.findOne(pelid);
    	
    	if(pel==null) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok().body(pel);
    	
    }
    
    @PutMapping("/peliculas/{id}")
	public ResponseEntity<pelicula> updatePelicula(@PathVariable(value="id") Long pelid,@Valid @RequestBody pelicula pelDetails){
		
		pelicula pel=peliculadao.findOne(pelid);
		if(pel==null) {
			return ResponseEntity.notFound().build();
		}
		
		pel.setId(pelDetails.getId());
		pel.setTitulo(pelDetails.getTitulo());
		pel.setAdultos(pelDetails.getAdultos());
		pel.setAnio(pelDetails.getAnio());
		pel.setCalificacion(pelDetails.getCalificacion());
		pel.setDirector(pelDetails.getDirector());
		pel.setPoster(pelDetails.getPoster());
		pel.setLenguajeOriginal(pelDetails.getLenguajeOriginal());
		pel.setOverview(pelDetails.getOverview());
		
		
		
		pelicula updatePelicula=peliculadao.save(pel);
		return ResponseEntity.ok().body(updatePelicula);
		
		
		
	}
	
	
	//borrar pelicula
	@DeleteMapping("/peliculas/{id}")
	public ResponseEntity<pelicula> deletePelicula(@PathVariable(value="id") Long pelid){
		
		pelicula pel=peliculadao.findOne(pelid);
		if(pel==null) {
			return ResponseEntity.notFound().build();
		}
		peliculadao.delete(pel);
		
		return ResponseEntity.ok().build();
		
		
	}
    
    
    
	
    
}
	