package com.aharrar.fcnice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aharrar.fcnice.entities.Equipe;
import com.aharrar.fcnice.repository.EquipeRepository;

@Service
public class EquipeServiceImpl implements EquipeService{
	
	@Autowired
	EquipeRepository equipeRepository;

	@Override
	public Equipe saveEquipe(Equipe e) {
		
		return equipeRepository.save(e);
	}

	@Override
	public Equipe updateEquipe(Equipe e) {
		return equipeRepository.save(e);
	}

	@Override
	public void deleteEquipe(Equipe e) {
		equipeRepository.delete(e);
		
	}

	@Override
	public void deleteEquipeById(Long id) {
		equipeRepository.deleteById(id);
		
	}

	@Override
	public Equipe getEquipe(Long id) {
		return equipeRepository.findById(id).get();
	}

	@Override
	public List<Equipe> getAllEquipe() {
		return equipeRepository.findAll();
	}

}
