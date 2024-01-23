package com.aharrar.fcnice.service;

import java.util.List;

import com.aharrar.fcnice.entities.Joueur;

public interface JoueurService {
	
	Joueur saveJoueur(Joueur j);
	Joueur updateJoueur(Joueur j);
	void deleteJoueur(Joueur j);
	void deleteJoueurById(Long id);
	Joueur getJoueur(Long id);
	List<Joueur> getAllJoueur();


}
