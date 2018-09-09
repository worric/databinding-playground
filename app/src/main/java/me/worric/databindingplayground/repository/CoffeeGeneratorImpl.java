package me.worric.databindingplayground.repository;

import java.util.Random;

import me.worric.domain.model.Coffee;

public class CoffeeGeneratorImpl implements CoffeeGenerator {

    private static final int MAX_COFFEE_NUMBER = 100;
    private final String[] mNames = new String[] {
            "Teh Goodness",
            "Teh OTHER goodness",
            "Heartbreaker",
            "Mister McStuffins"
    };
    private final Random mRandom;

    public CoffeeGeneratorImpl() {
        mRandom = new Random();
    }

    @Override
    public Coffee generateCoffee() {
        String name = mNames[getRandomNumberBoundedByArrayLength()];
        int number = mRandom.nextInt(MAX_COFFEE_NUMBER);
        return new Coffee(name, number);
    }

    private int getRandomNumberBoundedByArrayLength() {
        return mRandom.nextInt(mNames.length);
    }

}
