package com.kata.addition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeCompteEstBonMapReduce implements LeCompteEstBon {
    public List<Pair> leCompteEstBon(List<Integer> elts, int expected) {
        final Map<Integer, Integer> map = new HashMap<Integer, Integer>(elts.size());
        for (Integer elt : elts) {
            map.put(elt, expected - elt);
        }

        final List<Pair> result = new ArrayList<Pair>(elts.size());
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if(mapEntry.getKey().equals(mapEntry.getValue())) {
                continue;
            }

            if(elts.contains(mapEntry.getValue())) {
                result.add(new Pair(mapEntry.getValue(), mapEntry.getKey()));
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "LeCompteEstBonMapReduce";
    }
}
