package es.capgemini.curso.multimodulo.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"es.capgemini.curso.multimodulo.spring.jpa", "es.capgemini.curso.multimodulo.spring.servicios"})
public class ComponentesNoWeb {

}
