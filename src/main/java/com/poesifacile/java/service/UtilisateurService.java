package com.poesifacile.java.service;

import com.poesifacile.java.model.Historique;
import com.poesifacile.java.model.Utilisateur;
import com.poesifacile.java.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	private ArrayList<Utilisateur> wallOfFame = new ArrayList<>();

	public UtilisateurService() {
	}

	public UtilisateurService(UtilisateurRepository utilisateurRepository, ArrayList<Utilisateur> wallOfFame) {
		this.utilisateurRepository = utilisateurRepository;
		this.wallOfFame = wallOfFame;
	}

	public UtilisateurRepository getUtilisateurRepository() {
		return utilisateurRepository;
	}

	public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public ArrayList<Utilisateur> getWallOfFame() {
		return wallOfFame;
	}

	public void setWallOfFame(ArrayList<Utilisateur> wallOfFame) {
		this.wallOfFame = wallOfFame;
	}


	//Trie les utilisateur en fonction de leur moyenne
	//La fonction renvoie un tableau contenant les utilisateurs trié de la meilleure note à la moins bonne
	public ArrayList<Utilisateur> trieScore() {
		List<Utilisateur> listUtilisateur = (List<Utilisateur>) utilisateurRepository.findAll();
		ArrayList<Utilisateur> wOF = new ArrayList<>();

		float max = 0;
		int idMax = -1;
		int indexMax = -1;
		boolean trier = false;
		int index = 0;
		while (!trier) {
			for (Utilisateur utilisateur :
					listUtilisateur) {
				if (utilisateur.getMoyenne() >= max) {
					max = utilisateur.getMoyenne();
					idMax = utilisateur.getId();
					indexMax = index;
				}
				index++;
			}
			listUtilisateur.remove(indexMax);
			wOF.add(utilisateurRepository.findOne(idMax));
			indexMax = -1;
			index = 0;
			max = 0;
			if (listUtilisateur.isEmpty())
				trier = true;
		}
		return wOF;
	}

	//Fonction qui calcul la moyenne de chaque utilisateur et l'enregistre dans la base de donnée dans la case moyenne

	public boolean recupMoyenne() {

		List<Utilisateur> listUtilisateur = (List<Utilisateur>) utilisateurRepository.findAll();

		Float somme = 0F;
		Float moyenne;

		for (Utilisateur utilisateur :
				listUtilisateur) {
			List<Historique> listHistorique = utilisateur.getHistorique();

			for (Historique historique :
					listHistorique) {
				somme += historique.getScore();
			}
			moyenne = somme / 5;

			utilisateur.setMoyenne(moyenne);
			utilisateurRepository.save(utilisateur);
			somme = 0F;
		}
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UtilisateurService)) return false;
		UtilisateurService that = (UtilisateurService) o;
		return Objects.equals(utilisateurRepository, that.utilisateurRepository) &&
				Objects.equals(wallOfFame, that.wallOfFame);
	}

	@Override
	public int hashCode() {
		return Objects.hash(utilisateurRepository, wallOfFame);
	}

	@Override
	public String toString() {
		return "UtilisateurService{" +
				"utilisateurRepository=" + utilisateurRepository +
				", wallOfFame=" + wallOfFame +
				'}';
	}
}

