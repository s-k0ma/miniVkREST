package ru.vkmini.back.data.repos;

import org.springframework.stereotype.Repository;
import ru.vkmini.back.data.dto.Person;

import java.util.Optional;

@Repository
public interface PeopleRepo {
    Optional<Person> findByUsername(String username);
}
