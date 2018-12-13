package com.poesifacile.java;

import com.poesifacile.java.model.Utilisateur;
import com.poesifacile.java.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public void run(String... strings) {

		List<Utilisateur> listUser = (List<Utilisateur>) utilisateurRepository.findAll();
		for (Utilisateur user : listUser) {
			System.out.println(user.toString());
		}


	}

}
