package fr.eni.ludotheque.bll.impl;

import fr.eni.ludotheque.bll.JeuService;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dal.JeuRepository;
import org.springframework.stereotype.Service;


@Service
public class JeuServiceImpl implements JeuService {

    public JeuServiceImpl(JeuRepository jeuRepository) {
        this.jeuRepository = jeuRepository;
    }

    @Override
    public Jeu ajouterJeu(Jeu jeu) {
        return jeuRepository.save(jeu);
    }

    private final JeuRepository jeuRepository;
}
