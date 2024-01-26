package com.aharrar.fcnice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aharrar.fcnice.entities.Joueur;
import com.aharrar.fcnice.repository.JoueurRepository;

@SpringBootTest
class JoueurTests {
	
	@Autowired
	private JoueurRepository joueurRepository;

	@Test
	public void testFindJoueur()
	{
	Joueur j = joueurRepository.findById(6L).get(); 
	System.out.println(j);
	}

	@Test
	public void testUpdateJoueur()
	{
	Joueur j = joueurRepository.findById(4L).get();
	j.setName("Messi");
	joueurRepository.save(j);
	}
	
	@Test
	public void testDeleteJoueur()
	{
	joueurRepository.deleteById(1L);
	}
	
	@Test
	public void testListerTousJoueurs()
	{
	List<Joueur> joueurs = joueurRepository.findAll();
	for (Joueur j : joueurs)
	{
	System.out.println(j);
	}
	}


}
