package com.kata.addition;

import java.util.*;

public class LeCompteEstBonSoustraction implements LeCompteEstBon {
    public List<Pair> leCompteEstBon(List<Integer> elements, int expected) {
        final List<Integer> elts = new SortedList<Integer>(elements);

        final Set<Pair> result = new LinkedHashSet<Pair>(elts.size());
        for (int i = 0, eltsSize = elts.size(); i < eltsSize; i++) {
            Integer elt = elts.get(i);
            final int sub = expected - elt;

            Pair pair = new Pair(sub, elt);
            if (result.contains(pair)) {
                continue;
            }

            int indexOf = elts.indexOf(sub);
            if (indexOf > 0 && indexOf != i) {
                result.add(pair);
            }
        }
        return new LinkedList<Pair>(result);
    }

    @Override
    public String toString() {
        return "LeCompteEstBonSoustraction";
    }


    private class SortedList<T extends Comparable<? super T>> extends AbstractList<T> {

        private final List<T> elts;

        public SortedList(List<T> elts) {
            Collections.sort(elts);
            this.elts = elts;
        }

        @Override
        public T get(int index) {
            return elts.get(index);
        }

        @Override
        public int size() {
            return elts.size();
        }

        @Override
        public int indexOf(Object o) {
            return Collections.binarySearch(elts, (T) o);
        }
    }
}
