package com.aharrar.fcnice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Equipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String acronyme;
	private Double budget;
	
	/*
	 * @OneToMany (mappedBy = "equipe") private List<Joueur> joueurs;
	 */
	/*
	 * 
	 * public List<Joueur> getJoueurs() { return joueurs; } public void
	 * setJoueurs(List<Joueur> joueurs) { this.joueurs = joueurs; }
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcronyme() {
		return acronyme;
	}
	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public Equipe() {
		
	}
	
	public Equipe(Long id, String name, String acronyme, Double budget) {
		super();
		this.id = id;
		this.name = name;
		this.acronyme = acronyme;
		this.budget = budget;
		
	}
	@Override
	public String toString() {
		return "Equipe [id=" + id + ", name=" + name + ", acronyme=" + acronyme + ", budget=" + budget + "]";
	}
	
	
	
	

}
