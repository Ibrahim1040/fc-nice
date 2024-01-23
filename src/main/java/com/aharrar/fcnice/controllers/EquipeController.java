package com.aharrar.fcnice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aharrar.fcnice.entities.Equipe;
import com.aharrar.fcnice.service.EquipeService;


@RestController
@RequestMapping("/equipe")
public class EquipeController {
	
	@Autowired
	EquipeService equipeService;
	
	@GetMapping
	public List<Equipe> getAllEquipes() {
	return equipeService.getAllEquipe();
	}
	
	@GetMapping("/{id}")
	public Equipe getEquipeById(@PathVariable("id") Long id) {
	return equipeService.getEquipe(id);
	}
	
	@PostMapping
	public Equipe createEquipe(@RequestBody Equipe equipe) {
	return equipeService.saveEquipe(equipe);
	}
	
	@PutMapping
	public Equipe updateEquipe(@RequestBody Equipe equipe) {
	return equipeService.updateEquipe(equipe);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEquipe(@PathVariable("id") Long id) {
		equipeService.deleteEquipeById(id);
	}

}
