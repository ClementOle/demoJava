package com.poesifacile.java.controller;

import com.poesifacile.java.repository.UtilisateurRepository;
import com.poesifacile.java.service.GestionScore;
import com.poesifacile.java.service.WallOfFame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WallOfFameController {
	@Autowired
	private
	UtilisateurRepository utilisateurRepository;

	@RequestMapping("/wallOfFame")
	public WallOfFame wOF() {
		GestionScore g = new GestionScore(utilisateurRepository);
		return new WallOfFame(g.trieScore());
	}

	@RequestMapping("/updateDB")
	public boolean updateDB() {
		GestionScore g = new GestionScore(utilisateurRepository);
		return g.recupMoyenne();
	}
}