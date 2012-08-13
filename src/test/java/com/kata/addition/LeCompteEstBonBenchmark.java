package com.kata.addition;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

import java.util.Arrays;
import java.util.List;

/**
 * User: Wursteisen David
 * Date: 13/08/12
 * Time: 21:52
 */
public class LeCompteEstBonBenchmark extends SimpleBenchmark {


    private static final int EXPECTED = 10;
    private static final List<Integer> elts = Arrays.asList(10, 2, 5, 8, 7, 3, 1, 10, 2, 5, 8, 7, 3, 1, 10, 2, 5, 8,
            7, 3, 1, 10, 2, 5, 8, 7, 3, 1, 10, 2, 5, 8, 7, 3, 1, 10, 2, 5, 8, 7, 3, 1, 10, 2, 5, 8, 7,
            3, 1, 10, 2, 5, 8, 7, 3, 1, 10, 2, 5, 8, 7, 3, 1, 10, 2, 5, 8, 7, 3, 1, 10,
            2, 5, 8, 7, 3, 1, 10, 2, 5, 8, 7, 3, 1, 10, 2, 5, 8, 7, 3, 1, 10, 2, 5, 8, 7, 3, 1);

    public void timeLeCompteEstBonNaivement(int reps) {
        LeCompteEstBon impl = new LeCompteEstBonNaivement();
        for (int i = 0; i < reps; i++) {
            List<Pair> result = impl.leCompteEstBon(elts, EXPECTED);
        }
    }

    public void timeLeCompteEstBonSoustraction(int reps) {
        LeCompteEstBon impl = new LeCompteEstBonSoustraction();
        for (int i = 0; i < reps; i++) {
            List<Pair> result = impl.leCompteEstBon(elts, EXPECTED);
        }
    }

    public void timeLeCompteEstBonMapReduce(int reps) {
        LeCompteEstBon impl = new LeCompteEstBonMapReduce();
        for (int i = 0; i < reps; i++) {
            List<Pair> result = impl.leCompteEstBon(elts, EXPECTED);
        }
    }

    public static void main(String[] args) {
        Runner.main(LeCompteEstBonBenchmark.class, args);
    }
}
