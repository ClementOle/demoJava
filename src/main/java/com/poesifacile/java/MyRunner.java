package com.poesifacile.java;

import com.poesifacile.java.model.Historique;
import com.poesifacile.java.model.Utilisateur;
import com.poesifacile.java.repository.HistoriqueRepository;
import com.poesifacile.java.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MyRunner implements CommandLineRunner {


	@Autowired
	HistoriqueRepository historiqueRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public void run(String... strings) {

		Historique h = historiqueRepository.findOne(13);
		Utilisateur u = utilisateurRepository.findOne(h.getId_joueur());
		System.out.println(h.toString());
		System.out.println(u.toString());

		Utilisateur u2 = utilisateurRepository.findOne(1);
		List<Historique> h2 = u2.getHistorique();

		System.out.println();
		System.out.println(u2.toString());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");

		for (Historique histo : h2) {
			System.out.println(histo.toString());
		}
	}

}
