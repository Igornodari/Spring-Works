package br.senac.tads.dsw.usuariocrud.controller;


import br.senac.tads.dsw.usuariocrud.model.Usuario;
import br.senac.tads.dsw.usuariocrud.repository.UserRepository;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	

	 @RequestMapping("/lista")
	    public ModelAndView listar() {
	        List<Usuario> user = userRepository.findAll();
	        return new ModelAndView("user/home").addObject("usuarios", user);
	    }
	 
	 @GetMapping("/{id}/editar")
		public ModelAndView editar(@PathVariable("id") @Valid int id) {
			Usuario user = userRepository.findById(id);
			return new ModelAndView("user/form").addObject("usuarios", user);
		}
	 
	 
	 @RequestMapping(value = "/novo" , method = RequestMethod.GET)
	    public ModelAndView adicionarNovo() {
		 Usuario user = new Usuario();
	        return new ModelAndView("user/form")
	                  .addObject("usuarios",user);
	    }
	
	 @PostMapping("/salvar")
	    public ModelAndView salvar(@ModelAttribute @Valid Usuario user,
	    		BindingResult bindingResult,
	            RedirectAttributes redirAttr) {
		 
		 user.setDataHoraCadastro(LocalDateTime.now());
	      
	    	if (bindingResult.hasErrors()) {
	    		return new ModelAndView("user/form");
	    	}
	        userRepository.save(user);
	        redirAttr.addFlashAttribute("msgSucesso", 
	                "Usuario " + user.getNomeCompleto() + " salva com sucesso");
	        return new ModelAndView("redirect:/user/lista");
	    }
	 @PostMapping("/{id}/remover")
	    public ModelAndView remover(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		
	        userRepository.deleteById(id);
	        redirectAttributes.addFlashAttribute("msgSucesso", 
	                "Produto ID " + id + " removido com sucesso");
	        return new ModelAndView("redirect:/user/lista");
	    }
}
