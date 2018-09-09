package me.worric.databindingplayground.repository;

import org.junit.Before;
import org.junit.Test;

import me.worric.domain.model.Coffee;
import me.worric.domain.repository.CoffeeRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isIn;

public class CoffeeRepositoryImplTest {

    private CoffeeRepository mRepository;
    private final String[] mNames = new String[] {
            "Teh Goodness",
            "Teh OTHER goodness",
            "Heartbreaker",
            "Mister McStuffins"
    };

    @Before
    public void setUp() {
        mRepository = new CoffeeRepositoryImpl(new CoffeeGeneratorImpl());
    }

    @Test
    public void generatedCoffee_hasCorrectValues() {
        Coffee coffee = mRepository.getOne();

        assertThat(coffee.getName(), isIn(mNames));
        assertThat("Larger than 0 and lower than 100", coffee.getNumber() > 0 && coffee.getNumber() < 100);
    }

}