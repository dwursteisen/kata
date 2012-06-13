package com.kata.addition;

import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(Theories.class)
public class LecompteEstBonTest {


    @DataPoint
    public static LeCompteEstBon bruteForce = new LeCompteEstBonNaivement();

    @DataPoint
    public static LeCompteEstBon subForce = new LeCompteEstBonSoustraction();

    @DataPoint
    public static LeCompteEstBon mapReduce = new LeCompteEstBonMapReduce();

    public static Map<LeCompteEstBon, Long> perf = new HashMap<LeCompteEstBon, Long>();

    @AfterClass
    public static void printResult() {
        Map.Entry<LeCompteEstBon, Long> theBest = null;
        for (Map.Entry<LeCompteEstBon, Long> e : perf.entrySet()) {
            System.out.println(e.getKey() + " ==> "+e.getValue());
            if(theBest == null) {
                theBest = e;
            } else {
                if(e.getValue() < theBest.getValue()) {
                    theBest = e;
                }
            }
        }
        if(theBest == null) {
            System.out.println("Oups ! Please runing test before !");
        } else {
            System.out.println("\n===> And the winner is..."+theBest.getKey() + " ==> "+theBest.getValue());
        }
    }

    @Theory
    public void normalementLeCompteEstBon(LeCompteEstBon impl) {

        System.out.println("=== STARTING TEST WITH " + impl + " ===");
        final DateTime start = DateTime.now();
        final int numberOfIteration = 526266;
        for (int i = 0; i < numberOfIteration; i++) {
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
        final DateTime end = DateTime.now();
        final long millis = end.minus(start.getMillis()).getMillis();
        perf.put(impl, millis);

        System.out.println("=== ENDED TEST WITH " + impl + "("+millis + " millisec) ===");
    }
}
