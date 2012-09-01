package com.kata.pair;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Wursteisen David
 * Date: 01/09/12
 * Time: 21:46
 */
@RunWith(Theories.class)
public class CompteLeNombreDePaireTest {

    @DataPoint
    public static CompteLeNombreDePaire reutilisation = new CompteLeNombreDePaireSubLeCompteEstBon();

    @DataPoint
    public static CompteLeNombreDePaire naif = new CompteLeNombreDePaireNaif();

    @Theory
    public void compteLeNombreDePaire(CompteLeNombreDePaire implementation) {
        final int[] ensemble = {0, 1, 2, 3, 4};
        int nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 1);
        assertThat(nbPaire).isEqualTo(1);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 2);
        assertThat(nbPaire).isEqualTo(1);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 3);
        assertThat(nbPaire).isEqualTo(2);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 4);
        assertThat(nbPaire).isEqualTo(2);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 5);
        assertThat(nbPaire).isEqualTo(2);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 6);
        assertThat(nbPaire).isEqualTo(1);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 10);
        assertThat(nbPaire).isEqualTo(0);
    }


    @Theory
    public void compteLeNombreDePaireAvecGrandEnsemble(CompteLeNombreDePaire implementation) {
        final int[] ensemble = {0, 1, 2, 3, 4, 0, 1, 2, 3, 4};
        int nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 1);
        assertThat(nbPaire).isEqualTo(1);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 2);
        assertThat(nbPaire).isEqualTo(2);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 3);
        assertThat(nbPaire).isEqualTo(2);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 4);
        assertThat(nbPaire).isEqualTo(3);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 5);
        assertThat(nbPaire).isEqualTo(2);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 6);
        assertThat(nbPaire).isEqualTo(2);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 10);
        assertThat(nbPaire).isEqualTo(0);

    }

    @Theory
    public void compteLeNombreDePaireAvecEnsembleVarie(CompteLeNombreDePaire implementation) {
        final int[] ensemble = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 1);
        assertThat(nbPaire).isEqualTo(1);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 2);
        assertThat(nbPaire).isEqualTo(1);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 3);
        assertThat(nbPaire).isEqualTo(2);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 4);
        assertThat(nbPaire).isEqualTo(2);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 5);
        assertThat(nbPaire).isEqualTo(3);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 6);
        assertThat(nbPaire).isEqualTo(3);

        nbPaire = implementation.comptePaireAyantCommeSomme(ensemble, 10);
        assertThat(nbPaire).isEqualTo(4);
    }
}
