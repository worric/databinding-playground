package me.worric.domain.interactor.send;

import java.util.List;
import java.util.Objects;

import me.worric.domain.model.Coffee;
import me.worric.domain.repository.CoffeeRepository;

public class SendAllUseCase {

    private final CoffeeRepository mRepository;

    public SendAllUseCase(CoffeeRepository repository) {
        mRepository = repository;
    }

    public void sendAll(List<Coffee> coffees) {
        Objects.requireNonNull(coffees);

        for (Coffee coffee : coffees) {
            mRepository.sendOne(coffee);
        }

    }

}
