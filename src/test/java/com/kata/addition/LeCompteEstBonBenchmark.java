package com.kata.addition;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * User: Wursteisen David
 * Date: 13/08/12
 * Time: 21:52
 */
public class LeCompteEstBonBenchmark extends SimpleBenchmark {


    private static final int EXPECTED = 10;
    private static final List<Integer> elts = new ArrayList<Integer>();

    @Param(value = {"2000"})
    private int size;

    private final Random random = new Random(new Date().getTime());

    @Override
    protected void setUp() throws Exception {
        elts.clear();
        for (int i = 0; i < size; i++) {
            elts.add(random.nextInt(100));
        }
    }

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

    public static void main(String[] args) {
        Runner.main(LeCompteEstBonBenchmark.class, args);
    }
}
