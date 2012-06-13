package com.kata.addition;

public class Pair {

    private final int number1;
    private final int number2;

    public Pair(int nb1, int nb2) {
        this.number1 = nb1;
        this.number2 = nb2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (number1 == pair.number1 && number2 == pair.number2) return true;
        if (number1 == pair.number2 && number2 == pair.number1) return true;

        return false;
    }

    @Override
    public int hashCode() {
        int result = number1;
        result = 31 * result + number2;
        return result;
    }

    @Override
    public String toString() {
        return "[ "+number1+" - "+number2+" ]";
    }
}
