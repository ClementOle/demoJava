package com.poesifacile.java.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Historique {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_sauvegarde;
	private Integer salle;
	@ManyToOne
	@JoinColumn(name = "id")
	private Utilisateur utilisateur;
	private Float score;

	public Historique() {
	}

	public Historique(Integer salle, Utilisateur utilisateur, Float score) {
		this.salle = salle;
		this.utilisateur = utilisateur;
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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
		if (o == null || getClass() != o.getClass()) return false;
		Historique that = (Historique) o;
		return Objects.equals(id_sauvegarde, that.id_sauvegarde) &&
				Objects.equals(salle, that.salle) &&
				Objects.equals(utilisateur, that.utilisateur) &&
				Objects.equals(score, that.score);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_sauvegarde, salle, utilisateur, score);
	}

	@Override
	public String toString() {
		return "Historique{" +
				"id_sauvegarde=" + id_sauvegarde +
				", salle=" + salle +
				", utilisateur=" + utilisateur +
				", score=" + score +
				'}';
	}
}
