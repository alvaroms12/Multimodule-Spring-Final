package es.capgemini.curso.multimodulo.spring.jpa;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.capgemini.curso.multimodulo.spring.jpa.config.RootConfig;
import es.capgemini.curso.multimodulo.spring.jpa.modelo.PostRepository;
import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Post;

public class App {
	public static void main(String[] args) {
		// Cargar configuración de Spring para el contexto de ejecución
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);

		// Recuperar instancia del repositorio
		PostRepository repository = context.getBean(PostRepository.class);

		List<Post> post = repository.findAll();

		for (int i = 0; i < post.size(); i++) {
			System.out.println("Id: " + post.get(i).getId() + " Titulo: " + post.get(i).getTitulo() + " Contenido: " + post.get(i).getContenido());
			
		}


		// Cerrar y liberar contexto
		context.close();
	}
}
