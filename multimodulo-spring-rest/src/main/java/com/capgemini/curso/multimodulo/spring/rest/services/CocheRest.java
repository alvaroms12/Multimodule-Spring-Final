package com.capgemini.curso.multimodulo.spring.rest.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.PostRepository;
import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Post;
import es.capgemini.curso.multimodulo.spring.jpa.servicios.PostService;

@RestController
@RequestMapping("/api")
@ComponentScan(basePackages = { "es.capgemini.curso.multimodulo.spring.jpa" })
public class CocheRest {

	@Autowired
	PostService services;

	@Autowired
	PostRepository repository;

	@GetMapping("/coches")
	public List<Post> list() {
		return services.getAll();
	}

	@GetMapping("/coches/{idcoche}")
	public ResponseEntity<Optional<Post>> getById(@PathVariable(value = "idcoche") int idcoche) {
		Optional<Post> coche = services.getById(idcoche);

		return ResponseEntity.ok().body(coche);
	}

	@PostMapping("/coches")
	public Post create(@RequestBody Post coche) {
		return services.add(coche);
	}

	@PutMapping("/coches/{idcoche}")
	public ResponseEntity<Post> update(@PathVariable("idcoche") int idcoche, @RequestBody Post coche) {
		Optional<Post> cocheFound = services.getById(idcoche);

		cocheFound.get().setModelo(coche.getModelo());
		cocheFound.get().setMarca(coche.getMarca());
		cocheFound.get().setPrecio(coche.getPrecio());

		Post cocheUpdate = services.add(cocheFound.get());

		return ResponseEntity.ok(cocheUpdate);
	}

	@DeleteMapping("/coches/{idcoche}")
	public Map<String, Object> delete(@PathVariable("idcoche") int idcoche) {
		Optional<Post> cocheFound = services.getById(idcoche);

		services.remove(cocheFound.get());

		Map<String, Object> response = new HashMap<String, Object>();

		response.put("delete", true);

		return response;
	}
}
