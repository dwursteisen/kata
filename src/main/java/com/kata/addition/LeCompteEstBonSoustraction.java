package com.kata.addition;

import java.util.ArrayList;
import java.util.List;

public class LeCompteEstBonSoustraction implements LeCompteEstBon {
    public List<Pair> leCompteEstBon(List<Integer> elts, int expected) {
        final List<Pair> result = new ArrayList<Pair>(elts.size());
        for (Integer elt : elts) {
            final int sub = expected - elt;
            if (elt.equals(sub)) {
                continue;
            }
            if (elts.contains(sub)) {
                result.add(new Pair(sub, elt));
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "LeCompteEstBonSoustraction";
    }
}
