package com.poesifacile.java.service;

import com.poesifacile.java.model.Utilisateur;
import com.poesifacile.java.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;


	//Simplification de la fonction trieScore
	public Page<Utilisateur> wallOfFame() {
		Pageable pageable = new PageRequest(0, 10, Sort.Direction.DESC, "moyenne");
		return utilisateurRepository.findAll(pageable);
	}


	/*//Trie les utilisateur en fonction de leur moyenne
	//La fonction renvoie un tableau contenant les utilisateurs trié de la meilleure note à la moins bonne
	public ArrayList<Utilisateur> trieScore() {
		//On recupere la liste des utilisateurs
		List<Utilisateur> listUtilisateurATrier = (List<Utilisateur>) utilisateurRepository.findAll();
		//On créé un tableau d'utilisateur qui réprésentera la wallOfFame
		ArrayList<Utilisateur> tableauScore = new ArrayList<>();

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
			tableauScore.add(utilisateurRepository.findOne(idMax));
			indexMax = -1;
			index = 0;
			max = 0;
			//Une fois que la liste des utilisateur à trié est vide
			//On arrete
			if (listUtilisateurATrier.isEmpty())
				trier = true;
		}
		//On renvoie le tableau wallOfFame
		return tableauScore;
	}*/
}

