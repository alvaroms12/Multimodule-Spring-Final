package es.capgemini.curso.multimodulo.spring.jpa.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.CocheRepository;
import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Coche;



/*
 * Clase de implementación del servicio
 * 
 * Todos los métodos del servicio se ejecutan dentro de una transaccion
 */
@Service
@Transactional
public class CocheServiceImpl implements CocheService {

	@Autowired
	private CocheRepository repository;

	@Override
	public Coche add(Coche coche) {
		return repository.save(coche);
	}

	@Override
	public Coche edit(Coche coche) {
		return repository.saveAndFlush(coche);
	}

	@Override
	public void remove(Coche coche) {
		repository.delete(coche);
	}

	@Override
	public Optional<Coche> getById(int idcoche) {
		return repository.findById(idcoche);
	}

	@Override
	public List<Coche> getAll() {
		return repository.findAll();
	}
	
}
