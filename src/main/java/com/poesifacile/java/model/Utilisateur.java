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
	@OneToMany
	@JoinColumn(name = "id_sauvegarde")
	private List<Historique> Historique;

	public Utilisateur() {
	}

	public Utilisateur(String pseudo, String password) {
		this.pseudo = pseudo;
		this.password = password;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Utilisateur that = (Utilisateur) o;
		return id.equals(that.id) &&
				pseudo.equals(that.pseudo) &&
				password.equals(that.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pseudo, password);
	}

	@Override
	public String toString() {
		return "Utilisateur{" +
				"id=" + id +
				", pseudo='" + pseudo + '\'' +
				", password='" + password + '\'' +
				'}';
	}
	
}