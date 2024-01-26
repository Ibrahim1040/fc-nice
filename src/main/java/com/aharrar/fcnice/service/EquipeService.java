package com.aharrar.fcnice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aharrar.fcnice.entities.Equipe;


public interface EquipeService {

	Equipe saveEquipe(Equipe e);
	Equipe updateEquipe(Equipe e);
	void deleteEquipe(Equipe e);
	void deleteEquipeById(Long id);
	Equipe getEquipeById(Long id);
	List<Equipe> getAllEquipe();
	Page<Equipe> findPaginated(int pageNo, int pageSize,String sortField,String sortDirection);
	
}
