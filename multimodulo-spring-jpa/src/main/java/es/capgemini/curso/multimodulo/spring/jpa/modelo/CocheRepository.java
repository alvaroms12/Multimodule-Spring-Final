package es.capgemini.curso.multimodulo.spring.jpa.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Coche;


/*
 * Repositorio del modelo
 */
@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {

	
}
