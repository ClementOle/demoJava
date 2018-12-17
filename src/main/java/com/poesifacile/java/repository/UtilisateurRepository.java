package com.poesifacile.java.repository;

import com.poesifacile.java.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;


public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
}
