package com.poesifacile.java.controller;

import com.poesifacile.java.model.Utilisateur;
import com.poesifacile.java.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController {
	@Autowired
	private
	UtilisateurService utilisateurService;

	//Récupération du wall of Fame

	@RequestMapping("/wallOfFame")
	public Page<Utilisateur> wOF() {
		return utilisateurService.wallOfFame();
	}
}