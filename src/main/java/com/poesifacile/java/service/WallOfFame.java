package com.poesifacile.java.service;

import com.poesifacile.java.model.Utilisateur;

import java.util.ArrayList;

public class WallOfFame {

	private ArrayList<Utilisateur> wallOfFame = new ArrayList<>();

	public WallOfFame() {
	}

	public WallOfFame(ArrayList<Utilisateur> wallOfFame) {
		this.wallOfFame = wallOfFame;
	}

	public ArrayList<Utilisateur> getWallOfFame() {
		return wallOfFame;
	}

	public void setWallOfFame(ArrayList<Utilisateur> wallOfFame) {
		this.wallOfFame = wallOfFame;
	}
}
