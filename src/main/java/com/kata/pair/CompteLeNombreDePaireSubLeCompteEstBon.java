package com.kata.pair;

import com.kata.addition.LeCompteEstBon;
import com.kata.addition.LeCompteEstBonSoustraction;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Wursteisen David
 * Date: 01/09/12
 * Time: 22:54
 */
public class CompteLeNombreDePaireSubLeCompteEstBon implements CompteLeNombreDePaire {
    private final LeCompteEstBon compteur = new LeCompteEstBonSoustraction();

    @Override
    public int comptePaireAyantCommeSomme(final int[] ensemble, int distance) {
        final List<Integer> ensembleInteger = new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return ensemble[index];
            }

            @Override
            public int size() {
                return ensemble.length;
            }
        };

        return compteur.leCompteEstBon(new ArrayList<Integer>(ensembleInteger), distance).size();
    }
}
