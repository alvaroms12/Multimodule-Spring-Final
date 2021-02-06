package es.capgemini.curso.multimodulo.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ComponentesNoWeb.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { ComponentesWeb.class };
	}

	// El mapeo empezará en esta dirección que es donde tenemos nuestros servicios rest
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/spring-rest/rest/publicaciones" };
	}

}
