package com.kata.addition;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(Theories.class)
public class LecompteEstBonTest {

    @DataPoint
    public static LeCompteEstBon bruteForce = new LeCompteEstBonNaivement();

    @DataPoint
    public static LeCompteEstBon subForce = new LeCompteEstBonSoustraction();

    @DataPoint
    public static LeCompteEstBon mapReduce = new LeCompteEstBonMapReduce();

    @Theory
    public void normalementLeCompteEstBon(LeCompteEstBon impl) {

        List<Integer> elts = Arrays.asList(10, 2, 5, 8, 7, 3, 1);

        List<Pair> pairs = impl.leCompteEstBon(elts, 7);
        assertThat(pairs).contains(new Pair(2, 5));

        pairs = impl.leCompteEstBon(elts, 9);
        assertThat(pairs).contains(new Pair(8, 1));

        pairs = impl.leCompteEstBon(elts, 10);
        assertThat(pairs).contains(new Pair(8, 2), new Pair(7, 3));

        pairs = impl.leCompteEstBon(elts, 2);
        assertThat(pairs).isEmpty();
    }
}
