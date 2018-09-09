package me.worric.domain.interactor.send;

import me.worric.domain.model.Coffee;
import me.worric.domain.repository.CoffeeRepository;

public class SendUseCase {

    private final CoffeeRepository mRepository;

    public SendUseCase(CoffeeRepository repository) {
        mRepository = repository;
    }

    public void sendCOffee(Coffee coffee) {
        mRepository.sendOne(coffee);
    }

}
