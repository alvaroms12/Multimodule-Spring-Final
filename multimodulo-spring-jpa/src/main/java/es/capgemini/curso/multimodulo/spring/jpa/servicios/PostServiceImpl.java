package es.capgemini.curso.multimodulo.spring.jpa.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.PostRepository;
import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Post;



/*
 * Clase de implementación del servicio
 * 
 * Todos los métodos del servicio se ejecutan dentro de una transaccion
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository repository;

	@Override
	public Post add(Post post) {
		return repository.save(post);
	}

	@Override
	public Post edit(Post post) {
		return repository.saveAndFlush(post);
	}

	@Override
	public void remove(Post post) {
		repository.delete(post);
	}

	@Override
	public Optional<Post> getById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Post> getAll() {
		return repository.findAll();
	}
	
}
