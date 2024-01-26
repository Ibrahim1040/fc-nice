package com.aharrar.fcnice.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.aharrar.fcnice.entities.Equipe;
import com.aharrar.fcnice.service.EquipeService;



@Controller
public class EquipeController {
		
	
	@Autowired
	private EquipeService equipeService;
	
	// Afficher la liste des équipes
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1,"name","asc",model);
	}
	
	@GetMapping("/showNewEquipeForm")
	public String showNewEquipeForm(Model model) {
		// créer un attribut de modèle pour lier les données du formulaire
		Equipe equipe = new Equipe();
		model.addAttribute("equipe",equipe);
		return "new_equipe";
	}
	
	@PostMapping("/sauverEquipe")
	public String saveEquipe(@ModelAttribute("equipe") Equipe equipe) {
		// Sauver l'équipe dans la base de données
		equipeService.saveEquipe(equipe);
		return "redirect:/";
		
	}
	
	 @GetMapping("/showFormForUpdate/{id}") 
	  public String showFormForUpdate(@PathVariable(value = "id")Long id,Model model) {
		 // obtenir une équipe du service
		 Equipe equipe = equipeService.getEquipeById(id);
		 // définir l'équipe du model attribute pour pré-remplir le formulaire
		 model.addAttribute("equipe",equipe);
		  return "update_equipe"; 
	  }
	  
	
	/*
	 * @GetMapping 
	 * public List<Equipe> getAllEquipes() { 
	 * return equipeService.getAllEquipe(); 
	 * }
	 */
	
	
	/*
	 * @GetMapping("/{id}") public Equipe getEquipeById(@PathVariable("id") Long id)
	 * { return equipeService.getEquipe(id); }
	 */
	  
	  @PostMapping 
	  public Equipe createEquipe(@RequestBody Equipe equipe) { 
		  return equipeService.saveEquipe(equipe); }
	  
	 
	  
	  @GetMapping("/deleteEquipe/{id}") 
	  public String deleteEquipe(@PathVariable(value = "id") Long id){
		  this.equipeService.deleteEquipeById(id);
		  return "redirect:/";
	 
	  }
	  
	  @GetMapping("/page/{pageNo}")
	  public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
		  @RequestParam("sortField") String sortField,
		  @RequestParam("sortDir") String sortDir,
		  Model model) {
		  int pageSize = 5;
		  
		  Page<Equipe> page = equipeService.findPaginated(pageNo, pageSize,sortField,sortDir);
		  List<Equipe> listEquipes = page.getContent();
		  
		  model.addAttribute("currentPage", pageNo);
		  model.addAttribute("totalPages",page.getTotalPages());
		  model.addAttribute("totalItems",page.getTotalElements());
		  
		  model.addAttribute("sortField",sortField);
		  model.addAttribute("sortDir", sortDir);
		  model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		  
		  model.addAttribute("listEquipes",listEquipes);
		  return "index";
		  
	  }

}
