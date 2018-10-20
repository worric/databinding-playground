package me.worric.domain.interactor.fetch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import me.worric.domain.model.Coffee;
import me.worric.domain.repository.CoffeeRepository;

public class FetchAllUseCase {

    private final CoffeeRepository mRepository;

    public FetchAllUseCase(CoffeeRepository repository) {
        mRepository = repository;
    }

    public List<Coffee> fetchAll() {
        return Collections.unmodifiableList(Arrays.asList(mRepository.getOne(), mRepository.getOne()));
    }

}
