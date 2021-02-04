package com.capgemini.curso.multimodulo.spring.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Coche;
import es.capgemini.curso.multimodulo.spring.jpa.servicios.CocheService;

@RestController
@RequestMapping("/api")
@ComponentScan(basePackages = { "es.capgemini.curso.multimodulo.spring.jpa"})
public class CocheRest {

	@Autowired
	CocheService services;

	@GetMapping("/coches")
	public List<Coche> list() {
		return services.getAll();
	}

	@GetMapping("/coches/{idcoche}")
	public ResponseEntity<Optional<Coche>> getById(@PathVariable(value = "idcoche") int idcoche) {
		Optional<Coche> coche = services.getById(idcoche);
		
		return ResponseEntity.ok().body(coche);
	}
}
