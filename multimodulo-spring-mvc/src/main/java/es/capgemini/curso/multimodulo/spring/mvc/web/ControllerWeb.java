package es.capgemini.curso.multimodulo.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import es.capgemini.curso.spring.servicios.PostService;

@Controller
public class ControllerWeb {

	@Autowired
	private PostService services;
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index", "post", services.getAll());
	}
}
