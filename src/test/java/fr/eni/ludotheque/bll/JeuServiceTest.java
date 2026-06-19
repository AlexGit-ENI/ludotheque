package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dal.JeuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

    @SpringBootTest
    class JeuServiceTest {

        @Autowired
        private JeuService jeuService;

        @MockitoBean
        private JeuRepository jeuRepository;

        @Test
        void testAjoutJeu() {

            //GENRE
            Genre g1 = new Genre(1, "Jeu de Plateau");
            Genre g2 = new Genre(2, "Jeu d''Ambiance");
            Genre g3 = new Genre(3, "Jeu Coop");

            //JEU
            Jeu jeu = new Jeu();
            jeu.setTitre("Jumanji");
            jeu.setReference("REF666");
            jeu.setDuree(12000000);
            jeu.setTarifJour(0.0f);

            //JEU + GENRE
            jeu.addGenre(g1);
            jeu.addGenre(g2);
            jeu.addGenre(g3);


            when(jeuRepository.save(any(Jeu.class)))
                    .thenAnswer(invocation -> invocation.getArgument(0));

            //Result
            Jeu resultat = jeuService.ajouterJeu(jeu);


            Assertions.assertEquals(3, resultat.getGenres().size());
            Assertions.assertEquals("Jumanji", resultat.getTitre());
            Assertions.assertEquals("REF666", resultat.getReference());
        }
    }


