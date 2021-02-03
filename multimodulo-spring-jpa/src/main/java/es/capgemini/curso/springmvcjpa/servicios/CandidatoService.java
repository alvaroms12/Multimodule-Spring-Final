package es.capgemini.curso.springmvcjpa.servicios;

import java.util.List;
import java.util.Optional;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Candidato;


/*
 * Servicio para entidad Candidato
 */
public interface CandidatoService {

	Candidato add(Candidato candidato);
	
	Candidato edit(Candidato candidato);
	
	void remove(Candidato candidato);
	
	Optional<Candidato> getById(int idCandidato);
	
	List<Candidato> getAll();
}
