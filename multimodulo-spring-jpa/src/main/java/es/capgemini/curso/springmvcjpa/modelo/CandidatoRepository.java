package es.capgemini.curso.springmvcjpa.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Candidato;


/*
 * Repositorio del modelo
 */
@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

	
}
