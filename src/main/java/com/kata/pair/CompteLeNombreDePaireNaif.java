package com.kata.pair;

import java.util.Arrays;

/**
 * User: Wursteisen David
 * Date: 01/09/12
 * Time: 21:35
 * <p/>
 * Origine du code source :
 * <a href='http://blog.arkey.fr/2012/08/29/caliper-ou-pourquoi-les-microbenchmarks-aident/'>
 * The Coffee Workshop
 * </a>
 */
public class CompteLeNombreDePaireNaif implements CompteLeNombreDePaire {

    @Override
    public int comptePaireAyantCommeSomme(int[] ensemble, int sommeAttendu) {
        if (ensemble == null || ensemble.length < 2) return 0;

        Arrays.sort(ensemble);

        int paircounter = 0;

        int endCursos = ensemble.length - 1;
        int precedentValue = Integer.MIN_VALUE;
        for (int cursor = 0; cursor <= endCursos; cursor++) {
            int val_i = ensemble[cursor];
            if (val_i == precedentValue) {
                continue;
            }

            for (; cursor < endCursos && sommeAttendu - ensemble[endCursos] != val_i; endCursos--) ;
            int val_j = ensemble[endCursos];

            if ((val_i + val_j) == sommeAttendu) {
                paircounter = incrementDuCompteurDePaire(paircounter, cursor, endCursos);

            }
            endCursos = ensemble.length - 1;
            precedentValue = val_i;
        }

        return paircounter;
    }

    private int incrementDuCompteurDePaire(int paircounter, int i, int j) {
        if (i != j) paircounter++;
        return paircounter;
    }
}
