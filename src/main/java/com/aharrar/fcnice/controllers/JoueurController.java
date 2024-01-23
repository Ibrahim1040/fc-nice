package com.aharrar.fcnice.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aharrar.fcnice.entities.Joueur;
import com.aharrar.fcnice.service.JoueurService;

@RestController
@RequestMapping("/joueur")
public class JoueurController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	JoueurService joueurService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Joueur> getAllProduits() {
	return joueurService.getAllJoueur();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Joueur getJoueurById(@PathVariable("id") Long id) {
	return joueurService.getJoueur(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Joueur createJoueur(@RequestBody Joueur joueur) {
	return joueurService.saveJoueur(joueur);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Joueur updatJoueur(@RequestBody Joueur joueur) {
	return joueurService.updateJoueur(joueur);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void deleteJoueur(@PathVariable("id") Long id) {
		joueurService.deleteJoueurById(id);
	}



}
