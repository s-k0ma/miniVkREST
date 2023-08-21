package ru.vkmini.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vkmini.back.data.dto.Person;
import ru.vkmini.back.data.jdbc.PersonJdbc;
import ru.vkmini.back.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailService implements UserDetailsService {

    private final PersonJdbc personJdbc;

    @Autowired
    public PersonDetailService(PersonJdbc personJdbc) {
        this.personJdbc = personJdbc;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional< Person > person = personJdbc.findByUsername(username);
        if(person.isEmpty())
            throw new UsernameNotFoundException("User does not exist!");

        return new PersonDetails(person.get());
    }
}
