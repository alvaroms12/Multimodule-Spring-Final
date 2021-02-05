package es.capgemini.curso.multimodulo.spring.jpa.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Post;


/*
 * Repositorio del modelo
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	
}
