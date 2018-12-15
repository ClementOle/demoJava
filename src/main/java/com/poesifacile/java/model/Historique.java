package com.poesifacile.java.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Historique {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_sauvegarde;
	private Integer salle;
	private Integer id_joueur;
	private Float score;

	public Historique() {
	}

	public Historique(Integer salle, Integer id_joueur, Float score) {
		this.salle = salle;
		this.id_joueur = id_joueur;
		this.score = score;
	}

	public Integer getId_sauvegarde() {
		return id_sauvegarde;
	}

	public void setId_sauvegarde(Integer id_sauvegarde) {
		this.id_sauvegarde = id_sauvegarde;
	}

	public Integer getSalle() {
		return salle;
	}

	public void setSalle(Integer salle) {
		this.salle = salle;
	}

	public Integer getId_joueur() {
		return id_joueur;
	}

	public void setId_joueur(Integer id_joueur) {
		this.id_joueur = id_joueur;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Historique)) return false;
		Historique that = (Historique) o;
		return Objects.equals(id_sauvegarde, that.id_sauvegarde) &&
				Objects.equals(salle, that.salle) &&
				Objects.equals(id_joueur, that.id_joueur) &&
				Objects.equals(score, that.score);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_sauvegarde, salle, id_joueur, score);
	}

	@Override
	public String toString() {
		return "Historique{" +
				"id_sauvegarde=" + id_sauvegarde +
				", salle=" + salle +
				", id_joueur=" + id_joueur +
				", score=" + score +
				'}';
	}
}
