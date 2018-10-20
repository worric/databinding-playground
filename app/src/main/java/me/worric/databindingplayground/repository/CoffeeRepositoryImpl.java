package me.worric.databindingplayground.repository;

import me.worric.domain.model.Coffee;
import me.worric.domain.repository.CoffeeRepository;

public class CoffeeRepositoryImpl implements CoffeeRepository {

    private static CoffeeRepositoryImpl sInstance;
    private final CoffeeGenerator mGenerator;

    public CoffeeRepositoryImpl(CoffeeGenerator generator) {
        mGenerator = generator;
    }

    public static CoffeeRepositoryImpl getInstance() {
        if (sInstance == null) {
            synchronized (CoffeeRepositoryImpl.class) {
                if (sInstance == null) {
                    sInstance = new CoffeeRepositoryImpl(new CoffeeGeneratorImpl());
                }
            }
        }
        return sInstance;
    }

    @Override
    public Coffee getOne() {
        return mGenerator.generateCoffee();
    }

    @Override
    public void sendOne(Coffee coffee) {
        System.out.println("Coffee with name: " + coffee.getName() + " and number: "
                + coffee.getNumber() + " successfully sent!");
    }

    private void doStuffToStuff() {
        int hey = 2 + 2;
        String theStringRepresentation = Integer.toBinaryString(hey);
        System.out.println(theStringRepresentation);
    }

}
