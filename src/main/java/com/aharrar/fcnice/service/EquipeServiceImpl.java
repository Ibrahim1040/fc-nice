package com.aharrar.fcnice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		this.equipeRepository.deleteById(id);
		
	}

	/*
	 * @Override public Equipe getEquipe(Long id) { return
	 * equipeRepository.findById(id).get(); }
	 */

	@Override
	public List<Equipe> getAllEquipe() {
		return equipeRepository.findAll();
	}

	@Override
	public Equipe getEquipeById(Long id) {
		Optional<Equipe> optional = equipeRepository.findById(id);
		Equipe equipe = null;
		if(optional.isPresent()) {
			equipe = optional.get();
		}else {
			throw new RuntimeException("Pas d'équipe pour cette id n° : " + id);
		}
		return equipe;
	}

	@Override
	public Page<Equipe> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) 
				? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);
		return this.equipeRepository.findAll(pageable);
	}

}
