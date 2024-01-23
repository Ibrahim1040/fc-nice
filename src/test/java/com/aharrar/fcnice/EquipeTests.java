package com.aharrar.fcnice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.aharrar.fcnice.entities.Equipe;
import com.aharrar.fcnice.repository.EquipeRepository;

@SpringBootTest
public class EquipeTests {
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	@Test
	public void testFindEquipe()
	{
	Equipe e = equipeRepository.findById(6L).get(); 
	System.out.println(e);
	}
	
	@Test
	public void testListerTousEquipes(){
	List<Equipe> equipes = equipeRepository.findAll();
	for (Equipe e : equipes){
	System.out.println(e);
	}
  }
	
	@Test
	public void testUpdateEquipe()
	{
	Equipe e = equipeRepository.findById(3L).get();
	e.setName("Real Madrid");
	equipeRepository.save(e);
	}
	
	@Test
	public void deleteEquipe() {
		equipeRepository.deleteById(7L);
	}
}
