package com.aharrar.fcnice.service;

import java.util.List;
import com.aharrar.fcnice.entities.Equipe;


public interface EquipeService {

	Equipe saveEquipe(Equipe e);
	Equipe updateEquipe(Equipe e);
	void deleteEquipe(Equipe e);
	void deleteEquipeById(Long id);
	Equipe getEquipe(Long id);
	List<Equipe> getAllEquipe();
	
}
