package es.capgemini.curso.multimodulo.spring.jpa.servicios;

import java.util.List;
import java.util.Optional;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Post;


/*
 * Servicio para entidad Candidato
 */
public interface PostService {

	Post add(Post post);
	
	Post edit(Post post);
	
	void remove(Post post);
	
	Optional<Post> getById(int id);
	
	List<Post> getAll();
}
