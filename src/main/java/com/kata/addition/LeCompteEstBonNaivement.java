package com.kata.addition;

import java.util.ArrayList;
import java.util.List;

public class LeCompteEstBonNaivement implements LeCompteEstBon {
    public List<Pair> leCompteEstBon(List<Integer> elts, int expected) {
        List<Pair> result = new ArrayList<Pair>(elts.size());
        for (Integer i : elts) {
            for (Integer j : elts) {
                if (i.equals(j)) {
                    continue;
                }
                if (i + j == expected) {
                    result.add(new Pair(i, j));
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "LeCompteEstBonNaivement";
    }
}
