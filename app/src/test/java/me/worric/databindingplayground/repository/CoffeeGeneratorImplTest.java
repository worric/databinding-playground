package me.worric.databindingplayground.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

import me.worric.domain.model.Coffee;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeGeneratorImplTest {

    @Mock
    private Random mRandom;
    private CoffeeGenerator mGenerator;

    @Before
    public void setUp() {
        mGenerator = new CoffeeGeneratorImpl(mRandom);
    }

    @Test
    public void onGenerateCoffee_returnsCorrectCoffee() {
        String expectedName = "Heartbreaker";
        int randomIntValue = 2;
        when(mRandom.nextInt(anyInt())).thenReturn(randomIntValue);

        Coffee generatedCoffee = mGenerator.generateCoffee();

        assertThat(generatedCoffee.getName(), is(equalTo(expectedName)));
        assertThat(generatedCoffee.getNumber(), is(equalTo(randomIntValue)));
    }

}