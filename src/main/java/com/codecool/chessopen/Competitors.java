package com.codecool.chessopen;

import java.util.List;

public class Competitors implements Comparable<Competitors> {
    private final String name;
    private final List<Integer> numbers;

    public Competitors(String name, List<Integer> numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }
    public double getAverage(){
        return ((double) numbers.stream().mapToInt(Integer::intValue).sum()) / numbers.size();
    }

    @Override
    public int compareTo(Competitors competitors){
        return Double.compare(this.getAverage(), competitors.getAverage());
    }
}

