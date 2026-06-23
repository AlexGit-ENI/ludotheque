package fr.eni.ludotheque.rest;

import fr.eni.ludotheque.bll.JeuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jeux")
public class JeuxRestController {

    private final JeuService jeuService;

    public JeuxRestController(JeuService jeuService) {
        this.jeuService = jeuService;
    }
}