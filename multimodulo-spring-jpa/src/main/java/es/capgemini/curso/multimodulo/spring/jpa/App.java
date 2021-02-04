package es.capgemini.curso.multimodulo.spring.jpa;

import java.util.List;

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

		List<Coche> coche1 = repository.findAll();

		for (int i = 0; i < coche1.size(); i++) {
			System.out.println("Id: " + coche1.get(i).getIdcoche() + " Modelo: " + coche1.get(i).getModelo() + " Marca: " + coche1.get(i).getMarca());
			
		}


		// Cerrar y liberar contexto
		context.close();
	}
}
