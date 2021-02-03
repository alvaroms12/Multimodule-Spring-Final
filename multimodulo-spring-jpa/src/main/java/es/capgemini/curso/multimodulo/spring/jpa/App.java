package es.capgemini.curso.multimodulo.spring.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import es.capgemini.curso.multimodulo.spring.jpa.config.RootConfig;
import es.capgemini.curso.multimodulo.spring.jpa.modelo.CandidatoRepository;
import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Candidato;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// Cargar configuración de Spring para el contexto de ejecución
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);

		// Recuperar instancia del repositorio
		CandidatoRepository repository = context.getBean(CandidatoRepository.class);

		Candidato candidato1 = repository.findById(1).get();

		Long candidato2 = repository.count();
		System.out.println("Total de categorias: " + candidato2);
		System.out.println(candidato1);


		// Cerrar y liberar contexto
		context.close();
	}
}
