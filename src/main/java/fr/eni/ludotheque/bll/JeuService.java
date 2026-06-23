package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dto.JeuDisponibleDTO;

import java.util.List;

public interface JeuService {

    Jeu ajouterJeu (Jeu jeu);

    List<Jeu> FindAll ();

    List<JeuDisponibleDTO> getDisponibilite();
}
