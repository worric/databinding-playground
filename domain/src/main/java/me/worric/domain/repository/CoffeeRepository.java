package me.worric.domain.repository;

import me.worric.domain.model.Coffee;

public interface CoffeeRepository {

    Coffee getOne();

    void sendOne(Coffee coffee);

}
