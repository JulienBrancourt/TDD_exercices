package org.example.exo4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RechercheVille {
    private List<String> villes = Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam",
            "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

    private List<String> reponse = new ArrayList<String>();

    public List<String> rechercher(String mot) {
        //throw new NotImplementedException();
        if (mot.length() < 2) {
            if (mot.equals("*"))
                reponse = villes;
            else
                throw new NotFoundException("Le mot de passe est incorrect");
        }

        for (String ville : villes) {
            if (ville.toUpperCase().contains(mot.toUpperCase())) {
                reponse.add(ville);
            }
        }

        return reponse;
    }
}
