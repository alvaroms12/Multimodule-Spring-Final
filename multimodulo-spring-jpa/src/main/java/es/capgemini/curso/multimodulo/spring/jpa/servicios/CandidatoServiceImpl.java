package es.capgemini.curso.multimodulo.spring.jpa.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.CandidatoRepository;
import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Candidato;



/*
 * Clase de implementación del servicio
 * 
 * Todos los métodos del servicio se ejecutan dentro de una transaccion
 */
@Service
@Transactional
public class CandidatoServiceImpl implements CandidatoService {

	@Autowired
	private CandidatoRepository repository;

	@Override
	public Candidato add(Candidato candidato) {
		return repository.save(candidato);
	}

	@Override
	public Candidato edit(Candidato candidato) {
		return repository.saveAndFlush(candidato);
	}

	@Override
	public void remove(Candidato candidato) {
		repository.delete(candidato);
	}

	@Override
	public Optional<Candidato> getById(int idCandidato) {
		return repository.findById(idCandidato);
	}

	@Override
	public List<Candidato> getAll() {
		return repository.findAll();
	}
	
}
