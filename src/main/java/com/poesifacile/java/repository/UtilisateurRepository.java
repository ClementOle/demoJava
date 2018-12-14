package com.poesifacile.java.repository;

import com.poesifacile.java.model.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Integer> {
}
