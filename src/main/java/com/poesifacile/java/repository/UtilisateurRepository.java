package com.poesifacile.java.repository;

import com.poesifacile.java.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
	List<Utilisateur> findByPseudo(String pseudo);
}
