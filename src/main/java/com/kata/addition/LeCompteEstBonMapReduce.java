package com.kata.addition;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class LeCompteEstBonMapReduce implements LeCompteEstBon {

    public static final int SPLIT_FACTOR = 4;
    private final ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(SPLIT_FACTOR);

    public List<Pair> leCompteEstBon(List<Integer> elts, int expected) {
        List<List<Integer>> partition = Lists.partition(elts, SPLIT_FACTOR);
        List<Future<Map<Integer, Integer>>> futures = new ArrayList<Future<Map<Integer, Integer>>>(SPLIT_FACTOR);

        for (List<Integer> integers : partition) {
            Future<Map<Integer, Integer>> submit = executor.submit(new InternalThread(integers, expected));
            futures.add(submit);
        }

        final Map<Integer, Integer> map = new HashMap<Integer, Integer>(elts.size());
        try {
            for (Future<Map<Integer, Integer>> future : futures) {
                map.putAll(future.get());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        final List<Pair> result = new ArrayList<Pair>(elts.size());
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if (mapEntry.getKey().equals(mapEntry.getValue())) {
                continue;
            }

            if (elts.contains(mapEntry.getValue())) {
                result.add(new Pair(mapEntry.getValue(), mapEntry.getKey()));
            }
        }
        return result;
    }

    private class InternalThread implements Callable<Map<Integer, Integer>> {

        private final int expected;
        private final List<Integer> elts;

        public InternalThread(List<Integer> elts, int expected) {
            this.elts = elts;
            this.expected = expected;
        }

        public Map<Integer, Integer> call() throws Exception {
            final Map<Integer, Integer> map = new HashMap<Integer, Integer>(elts.size());
            for (Integer elt : elts) {
                map.put(elt, expected - elt);
            }
            return map;
        }
    }

    @Override
    public String toString() {
        return "LeCompteEstBonMapReduce";
    }
}
