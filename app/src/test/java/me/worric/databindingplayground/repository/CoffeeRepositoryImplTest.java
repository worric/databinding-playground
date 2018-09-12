package me.worric.databindingplayground.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import me.worric.domain.model.Coffee;
import me.worric.domain.repository.CoffeeRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeRepositoryImplTest {

    @Mock
    private CoffeeGenerator mGenerator;
    private CoffeeRepository mRepository;

    @Before
    public void setUp() {
        mRepository = new CoffeeRepositoryImpl(mGenerator);
    }

    @Test
    public void onGetOne_correctlyReturnsGeneratedCoffee() {
        final String coffeeName = "test";
        final int coffeeNumber = 10;
        when(mGenerator.generateCoffee())
                .thenReturn(new Coffee(coffeeName, coffeeNumber));

        Coffee fetchedCoffee = mRepository.getOne();

        assertThat(fetchedCoffee.getName(), is(coffeeName));
        assertThat(fetchedCoffee.getNumber(), is(coffeeNumber));
    }

}