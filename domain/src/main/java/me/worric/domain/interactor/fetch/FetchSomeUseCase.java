package me.worric.domain.interactor.fetch;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import me.worric.domain.model.Coffee;
import me.worric.domain.repository.CoffeeRepository;

public class FetchSomeUseCase {

    private final CoffeeRepository mRepository;

    public FetchSomeUseCase(CoffeeRepository repository) {
        mRepository = repository;
    }

    public List<Coffee> fetchSome(String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);

        List<Coffee> results = new ArrayList<>();
        Coffee current;

        while ((current = mRepository.getOne()).getName().matches(pattern.pattern())) {
            results.add(current);
        }

        return results;
    }

}
