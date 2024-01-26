package com.aharrar.fcnice.controllers;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.aharrar.fcnice.entities.Joueur;
import com.aharrar.fcnice.service.JoueurService;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/joueur")
public class JoueurController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	JoueurService joueurService;
	
	@GetMapping
	public String getAllProduits(Model model) {
		model.addAttribute("listJoueur",joueurService.getAllJoueur());
	return "index";
	}
	
	/*
	 * @PostMapping("/AffecterEquipeAJoueur/{idJoueur}/{idEquipe}")
	 * 
	 * @ResponseBody public void AffecterEquipeAJoueur(@PathVariable("idJoueur")
	 * Long idJoueur,
	 * 
	 * @PathVariable("idEquipe") Long idEquipe) {
	 * joueurService.AffecterJoueurAEquipe(idJoueur, idEquipe); }
	 */
	
	@GetMapping("/{id}")
	public Joueur getJoueurById(@PathVariable("id") Long id) {
	return joueurService.getJoueur(id);
	}
	
	@PostMapping
	public Joueur createJoueur(@RequestBody Joueur joueur) {
	return joueurService.saveJoueur(joueur);
	}
	
	
	@PutMapping public Joueur updatJoueur(@RequestBody Joueur joueur) { return
	  joueurService.updateJoueur(joueur); }
	 
	
	@DeleteMapping("/{id}")
	public void deleteJoueur(@PathVariable("id") Long id) {
		joueurService.deleteJoueurById(id);
	}



}
