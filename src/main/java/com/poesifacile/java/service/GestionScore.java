package com.poesifacile.java.service;

import com.poesifacile.java.model.Historique;
import com.poesifacile.java.model.Utilisateur;
import com.poesifacile.java.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GestionScore {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public void trieScore() {
        ArrayList<Integer> idWoF = new ArrayList<>();
        List<Utilisateur> listUtilisateur = (List<Utilisateur>) utilisateurRepository.findAll();

        float max = 0;
        int idMax = -1;
        int indexMax = -1;
        boolean trier = false;
        int index = 0;
        while (!trier) {
            for (Utilisateur utilisateur :
                    listUtilisateur) {
                if (utilisateur.getMoyenne() >= max) {
                    max = utilisateur.getMoyenne();
                    idMax = utilisateur.getId();
                    indexMax = index;
                }
                index++;
            }
            listUtilisateur.remove(indexMax);
            idWoF.add(idMax);
            indexMax = -1;
            index = 0;
            max = 0;
            if (listUtilisateur.isEmpty()) {
                trier = true;
            }
        }

        for (Integer id :
                idWoF) {
            System.out.println("Nom : " + utilisateurRepository.findOne(id).getPseudo());
            System.out.println("Note : " + utilisateurRepository.findOne(id).getMoyenne());
        }
    }

    public void recupMoyenne() {

        List<Utilisateur> listUtilisateur = (List<Utilisateur>) utilisateurRepository.findAll();

        Float somme = 0F;
        Float moyenne;

        for (Utilisateur utilisateur :
                listUtilisateur) {
            List<Historique> listHistorique = utilisateur.getHistorique();

            for (Historique historique :
                    listHistorique) {
                somme += historique.getScore();
            }
            moyenne = somme / 5;

            utilisateur.setMoyenne(moyenne);
            utilisateurRepository.save(utilisateur);
            somme = 0F;
        }
    }
}

