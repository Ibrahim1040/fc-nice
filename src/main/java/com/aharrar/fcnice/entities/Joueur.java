package com.aharrar.fcnice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Joueur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String position;
	/*
	 * @ManyToOne private Equipe equipe;
	 */
	
	public Joueur() {}
		

	public Joueur(Long id, String name, String position) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		
	}

	/*
	 * public Equipe getEquipe() { return equipe; }
	 * 
	 * public void setEquipe(Equipe equipe) { this.equipe = equipe; }
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		return "Joueur [id=" + id + ", name=" + name + ", position=" + position + "]";
	}

	
	
}
