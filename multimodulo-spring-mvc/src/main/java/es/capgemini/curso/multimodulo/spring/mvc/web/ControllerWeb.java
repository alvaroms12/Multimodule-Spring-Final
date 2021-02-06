package es.capgemini.curso.multimodulo.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.capgemini.curso.multimodulo.spring.jpa.modelo.entidades.Post;
import es.capgemini.curso.spring.servicios.PostService;

@Controller
public class ControllerWeb {

	@Autowired
	private PostService services;
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index", "post", services.getAll());
	}
	
	@GetMapping("/addPost")
	public ModelAndView newPost() {
		return new ModelAndView("newPost", "post", new Post());
	}
	
	@PostMapping("/addPost")
	public String saveNewPost(@ModelAttribute("post") Post post) {
		services.add(post);
		return "redirect:/";
	}
	
	@GetMapping("/updatePost")
	public ModelAndView updatePost(@RequestParam("id") int id) {
		return new ModelAndView("updatePost", "post", services.getById(id).get());
	}
	
	@PostMapping("/updatePost")
	public String saveUpdatePost (@ModelAttribute("post") Post post) {
		services.edit(post);
		return "redirect:/";
	}
	
	@GetMapping("/deletePost")
	public String deletePost (@RequestParam("id") int id) {
		services.remove(services.getById(id).get());
		return "redirect:/";
	}
}
