package fr.eni.ludotheque.bll.impl;

import fr.eni.ludotheque.bll.JeuService;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dal.JeuRepository;
import fr.eni.ludotheque.dto.JeuDisponibleDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JeuServiceImpl implements JeuService {

    public JeuServiceImpl(JeuRepository jeuRepository) {
        this.jeuRepository = jeuRepository;
    }

    @Override
    public Jeu ajouterJeu(Jeu jeu) {
        return jeuRepository.save(jeu);
    }

    @Override
    public List<Jeu> FindAll() {
        return List.of();
    }

    @Override
    public List<JeuDisponibleDTO> getDisponibilite() {
        return List.of();
    }

    private final JeuRepository jeuRepository;
}
