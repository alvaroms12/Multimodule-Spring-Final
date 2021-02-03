package es.capgemini.curso.multimodulo.spring.jpa.servicios;

import java.util.List;
import java.util.Optional;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Coche;


/*
 * Servicio para entidad Candidato
 */
public interface CocheService {

	Coche add(Coche coche);
	
	Coche edit(Coche coche);
	
	void remove(Coche coche);
	
	Optional<Coche> getById(int idcoche);
	
	List<Coche> getAll();
}
