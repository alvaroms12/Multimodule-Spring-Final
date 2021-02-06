package es.capgemini.curso.multimodulo.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"es.capgemini.curso.multimodulo.spring.jpa"})
public class ComponentesNoWeb {

}
