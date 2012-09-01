package com.kata.addition;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeCompteEstBonNaivement implements LeCompteEstBon {
    public List<Pair> leCompteEstBon(List<Integer> elts, int expected) {
        Set<Pair> result = new LinkedHashSet<Pair>(elts.size());
        for (int cursor = 0, eltsSize = elts.size(); cursor < eltsSize; cursor++) {
            Integer i = elts.get(cursor);
            for (int secondCursor = cursor + 1, eltsSize1 = elts.size(); secondCursor < eltsSize1; secondCursor++) {
                Integer j = elts.get(secondCursor);
                if (i + j == expected) {
                    result.add(new Pair(i, j));
                }
            }
        }
        return new LinkedList<Pair>(result);
    }

    @Override
    public String toString() {
        return "LeCompteEstBonNaivement";
    }
}
