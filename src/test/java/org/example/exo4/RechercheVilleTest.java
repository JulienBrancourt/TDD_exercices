package org.example.exo4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RechercheVilleTest {
    RechercheVille rechercheVille;
    @BeforeEach
    public void setup (){
        rechercheVille = new RechercheVille();
    }

    @Test
    public void testRechercheVilleWhenStringTailleMoins_2_ThenException() {
        String mot = "a";

      Assertions.assertThrows(NotFoundException.class, () -> rechercheVille.rechercher(mot));
    }

    @Test
    public void testRechercheVilleWhenStringThenReturnDebut() {
        String mot = "Va";
        List<String> resultAwait = Arrays.asList("Valence", "Vancouver");

        List<String> result = rechercheVille.rechercher(mot);

        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void testRechercheVilleWhenMajusculesThenReturnSansMajuscules() {
        String mot = "va";
        List<String> resultAwait = Arrays.asList("Valence", "Vancouver");

        List<String> result = rechercheVille.rechercher(mot);

        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void testRechercheVilleWhenPartieThenReturn () {
        String mot = "nd";
        List<String> resultAwait = Arrays.asList("Londres");

        List<String> result = rechercheVille.rechercher(mot);

        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void testRechercheVilleWhenAsterisqueThenReturnAll () {
        String mot = "*";
        List<String> resultAwait = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam",
                "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

        List<String> result = rechercheVille.rechercher(mot);

        Assertions.assertEquals(resultAwait, result);
    }
}
