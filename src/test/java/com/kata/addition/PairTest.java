package com.kata.addition;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PairTest {
    @Test
    public void testEquals() throws Exception {
        assertThat(new Pair(5, 2)).isEqualTo(new Pair(2, 5));
    }

    @Test
    public void testHashCode() throws Exception {
        assertThat(new Pair(2, 5).hashCode()).isEqualTo(new Pair(5, 2).hashCode());
        assertThat(new Pair(2, 5).hashCode()).isEqualTo(new Pair(2, 5).hashCode());
        assertThat(new Pair(2, 5).hashCode()).isNotEqualTo(new Pair(4, 3).hashCode());
    }
}
