package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dal.GenreRepository;
import fr.eni.ludotheque.dal.JeuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class JeuServiceTest {

    @Autowired
    private JeuService jeuService;

    @MockitoBean
    private JeuRepository jeuRepository;

    @MockitoBean
    private GenreRepository genreRepository;

    @Test
    void testAjoutJeu() {

        Genre g1 = new Genre();
        g1.setNoGenre(1);
        g1.setLibelle("Jeu de Plateau");

        Genre g2 = new Genre();
        g2.setNoGenre(2);
        g2.setLibelle("Jeu d''Ambiance");

        Genre g3 = new Genre();
        g3.setNoGenre(3);
        g3.setLibelle("Jeu Coopération");

        Jeu jeu = new Jeu();
        jeu.setTitre("Jumanji");
        //13 chiffres en référence
        jeu.setReference("REF666");
        jeu.setDuree(120000000);
        jeu.setTarifJour(0.0f);

        jeu.setGenres(List.of(g1, g2, g3));

        Mockito.when(genreRepository.findById(1)).thenReturn(Optional.of(g1));
        Mockito.when(genreRepository.findById(2)).thenReturn(Optional.of(g2));
        Mockito.when(genreRepository.findById(3)).thenReturn(Optional.of(g3));

        Mockito.when(jeuRepository.save(Mockito.any(Jeu.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Jeu result = jeuService.ajouterJeu(jeu);

        Assertions.assertEquals(3, result.getGenres().size());
        Assertions.assertEquals("Jumanji", result.getTitre());
    }
}
