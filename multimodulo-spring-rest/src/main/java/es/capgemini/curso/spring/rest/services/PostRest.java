package es.capgemini.curso.spring.rest.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;


import es.capgemini.curso.multimodulo.spring.jpa.modelo.PostRepository;
import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Post;
import es.capgemini.curso.multimodulo.spring.jpa.servicios.PostService;

// http://localhost:8585/spring-rest/rest/publicaciones
@Path("/publicaciones")
@ComponentScan(basePackages = { "es.capgemini.curso.multimodulo.spring.jpa" })
public class PostRest {

	@Autowired
	private PostService services;


	/*
	 * Petición GET para http://localhost:8585/spring-rest/rest/publicaciones
	 * 
	 * Creamos lista de posts con formato JSON @Produces
	 * 
	 * Código HTTP respuesta 200
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> lista() {
		return services.getAll();
	}

	/*
	 * Peticion POST para http://localhost:8585/spring-rest/rest/publicaciones
	 * 
	 * Recibimos post en formato JSON @Consumes
	 * 
	 * Devolvemos respuesta con Codigo HTTP respuesta 201 y la URI donde se
	 * encuentra el nuevo elemento para consulta
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Post post) throws URISyntaxException {

		services.add(post);
		int idCount = services.count(post);

		URI uri = new URI("/post/" + idCount);

		return Response.created(uri).build();
	}

	/*
	 * Peticion PUT para http://localhost:8585/spring-rest/rest/publicaciones/codigo
	 * 
	 * Recibimos post en formato JSON @Consumes
	 * 
	 * Enlazamos de la URL codigo con el primer parametro (code)
	 * 
	 * Devolvemos respuesta con Codigo HTTP respuesta 200 y la URI donde se
	 * encuentra el nuevo elemento para consulta
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response edit(@PathParam("id") int code, Post post) {

		Post postFound = services.getById(code).get();

		postFound.setContenido(post.getContenido());
		postFound.setTitulo(post.getTitulo());

		Post postUpdate = services.add(postFound);

		return Response.ok(postUpdate).build();
	}

	/*
	 * Peticion DELETE para http://localhost:8585/spring-rest/rest/publicaciones/codigo
	 * 
	 * Enlazamos de la URL codigo con el primer parametro (code)
	 * 
	 * Devolvemos respuesta con Codigo HTTP respuesta 200 y la URI donde se
	 * encuentra el nuevo elemento para consulta
	 */
	@DELETE
	@Path("{id}")
	public Response remove(@PathParam("id") int code) {

		services.remove(services.getById(code).get());
		return Response.ok().build();

	}

	/*
	 * Peticion GET para http://localhost:8585/spring-rest/rest/publicaciones/codigo
	 * 
	 * Enlazamos de la URL codigo con el primer parametro (code)
	 * 
	 * Devolvemos objeto Producto dentro del cuerpo de la respuesta con Codigo HTTP
	 * respuesta 200
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response item(@PathParam("id") int code) {

		Post post= services.getById(code).get();

		if (post != null) {
			return Response.ok(post, MediaType.APPLICATION_JSON).build();
		}

		return Response.status(Response.Status.NOT_FOUND).build();
	}
}
