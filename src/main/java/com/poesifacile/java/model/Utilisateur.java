package com.poesifacile.java.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String pseudo;
	private String password;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_joueur")
	private List<Historique> Historique;

	private Float moyenne;

	public Utilisateur() {
	}

	public Utilisateur(Integer id, String pseudo, String password, List<com.poesifacile.java.model.Historique> historique, Float moyenne) {
		this.id = id;
		this.pseudo = pseudo;
		this.password = password;
		Historique = historique;
		this.moyenne = moyenne;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<com.poesifacile.java.model.Historique> getHistorique() {
		return Historique;
	}

	public void setHistorique(List<com.poesifacile.java.model.Historique> historique) {
		Historique = historique;
	}

	public Float getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(Float moyenne) {
		this.moyenne = moyenne;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Utilisateur)) return false;
		Utilisateur that = (Utilisateur) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(pseudo, that.pseudo) &&
				Objects.equals(password, that.password) &&
				Objects.equals(Historique, that.Historique) &&
				Objects.equals(moyenne, that.moyenne);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pseudo, password, Historique, moyenne);
	}

	@Override
	public String toString() {
		return "Utilisateur{" +
				"id=" + id +
				", pseudo='" + pseudo + '\'' +
				", password='" + password + '\'' +
				", Historique=" + Historique +
				", moyenne=" + moyenne +
				'}';
	}


}