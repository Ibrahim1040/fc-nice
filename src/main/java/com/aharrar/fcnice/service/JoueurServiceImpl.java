package com.aharrar.fcnice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aharrar.fcnice.entities.Equipe;
import com.aharrar.fcnice.entities.Joueur;
import com.aharrar.fcnice.repository.EquipeRepository;
import com.aharrar.fcnice.repository.JoueurRepository;

@Service
public class JoueurServiceImpl implements JoueurService{
	
	@Autowired
	JoueurRepository joueurRepository;
	
	@Autowired
	EquipeRepository equipeRepository;
	
	

	@Override
	public Joueur saveJoueur(Joueur j) {
		return joueurRepository.save(j);
	}

	@Override
	public Joueur updateJoueur(Joueur j) {
		return joueurRepository.save(j);
	}

	@Override
	public void deleteJoueur(Joueur j) {
		joueurRepository.delete(j);
	}

	@Override
	public void deleteJoueurById(Long id) {
		joueurRepository.deleteById(id);
		
	}

	@Override
	public Joueur getJoueur(Long id) {
		return joueurRepository.findById(id).get();
	}

	@Override
	
	public List<Joueur> getAllJoueur() {
		return joueurRepository.findAll();
	}

	/*
	 * @Override public void AffecterJoueurAEquipe(Long idJoueur, Long idEquipe) {
	 * Equipe equipe = equipeRepository.findById(idEquipe).get(); Joueur joueur =
	 * joueurRepository.findById(idJoueur).get(); joueur.setEquipe(equipe);
	 * joueurRepository.save(joueur); }
	 */
}
