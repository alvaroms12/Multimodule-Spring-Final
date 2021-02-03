package es.capgemini.curso.multimodulo.spring.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.capgemini.curso.multimodulo.spring.jpa.config.RootConfig;
import es.capgemini.curso.multimodulo.spring.jpa.modelo.CocheRepository;
import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Coche;

public class App {
	public static void main(String[] args) {
		// Cargar configuración de Spring para el contexto de ejecución
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);

		// Recuperar instancia del repositorio
		CocheRepository repository = context.getBean(CocheRepository.class);

		Coche coche1 = repository.getOne(1);

		System.out.println(coche1);


		// Cerrar y liberar contexto
		context.close();
	}
}
