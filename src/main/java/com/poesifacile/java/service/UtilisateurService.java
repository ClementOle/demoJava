package com.poesifacile.java.service;

import com.poesifacile.java.model.Historique;
import com.poesifacile.java.model.Utilisateur;
import com.poesifacile.java.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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


	public ArrayList<Utilisateur> getWallOfFame() {
		return wallOfFame;
	}

	public void setWallOfFame(ArrayList<Utilisateur> wallOfFame) {
		this.wallOfFame = wallOfFame;
	}


	//Trie les utilisateur en fonction de leur moyenne
	//La fonction renvoie un tableau contenant les utilisateurs trié de la meilleure note à la moins bonne
	public ArrayList<Utilisateur> trieScore() {
		//On recupere la liste des utilisateurs
		List<Utilisateur> listUtilisateurATrier = (List<Utilisateur>) utilisateurRepository.findAll();
		//On créé un tableau d'utilisateur qui réprésentera la wallOfFame
		ArrayList<Utilisateur> wOF = new ArrayList<>();

		float max = 0;
		int idMax = -1;
		int indexMax = -1;
		boolean trier = false;
		int index = 0;

		//On trie les utilisateur
		while (!trier) {
			//On parcourt la liste des utilisateur pour trouver qui à la moyenne la plus grande
			for (Utilisateur utilisateur :
					listUtilisateurATrier) {
				if (utilisateur.getMoyenne() >= max) {
					max = utilisateur.getMoyenne();
					idMax = utilisateur.getId();
					indexMax = index;
				}
				index++;
			}
			//On enleve l'utilisateur qui possede le plus grand score de la list des utilisateur à trié
			//Pour pouvoir reefectuer un tri avec les utilisateurs restant
			listUtilisateurATrier.remove(indexMax);
			//On ajoute l'utilisateur avec le score maximum dans le wallOfFame
			wOF.add(utilisateurRepository.findOne(idMax));
			indexMax = -1;
			index = 0;
			max = 0;
			//Une fois que la liste des utilisateur à trié est vide
			//On arrete
			if (listUtilisateurATrier.isEmpty())
				trier = true;
		}
		//On renvoie le tableau wallOfFame
		return wOF;
	}

	//Fonction qui calcul la moyenne de chaque utilisateur et l'enregistre dans la base de donnée dans la case moyenne

	public boolean recupMoyenne() {
		//On recupere la liste des utilisateurs
		List<Utilisateur> listUtilisateur = (List<Utilisateur>) utilisateurRepository.findAll();

		Float somme = 0F;
		Float moyenne;
		//On parcours la liste
		for (Utilisateur utilisateur :
				listUtilisateur) {
			//On recupere la list des score pour l'utilisateur actuel
			List<Historique> listHistorique = utilisateur.getHistorique();

			for (Historique historique :
					listHistorique) {
				somme += historique.getScore();
			}
			moyenne = somme / 5;
			//On fait la moyenne des scores
			utilisateur.setMoyenne(moyenne);
			//Et on enregistre cette valeur dans la base de donnée dans le champs moyenne
			utilisateurRepository.save(utilisateur);
			somme = 0F;
		}
		return true;
	}

}

