package me.worric.domain.interactor.fetch;

import me.worric.domain.model.Coffee;
import me.worric.domain.repository.CoffeeRepository;

public class FetchUseCase {

    private CoffeeRepository mRepository;

    public FetchUseCase(CoffeeRepository repository) {
        mRepository = repository;
    }

    public Coffee fetchCoffee() {
        return mRepository.getOne();
    }

}
