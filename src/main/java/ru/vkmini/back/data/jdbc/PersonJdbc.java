package ru.vkmini.back.data.jdbc;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.vkmini.back.data.dto.Person;
import ru.vkmini.back.data.mapper.PersonMapper;
import ru.vkmini.back.data.repos.EntityRepo;
import ru.vkmini.back.data.repos.PeopleRepo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class PersonJdbc implements EntityRepo<Person>, PeopleRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    public PersonJdbc(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> findAll() {
        String sql = "SELECT * FROM person ORDER BY id DESC";
        return jdbcTemplate.query(sql, new PersonMapper());
    }

    @Override
    public Optional<Person> findById(Integer id) {
        String sql = "SELECT * FROM person WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return jdbcTemplate.query(sql, params, new PersonMapper()).stream().findFirst();
    }

    @Override
    public Optional<Person> findByUsername(String username) {
        String sql = "SELECT * FROM person WHERE username = :username";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("username", username);
        return jdbcTemplate.query(sql, params, new PersonMapper()).stream().findFirst();
    }

    @Override
    public Person save(Person Person) {
        String sql = "INSERT INTO person (email, password, firstname, username) " +
                "VALUES (:email, :password, :firstname, :username)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("email", Person.getEmail())
                .addValue("password", Person.getPassword())
                .addValue("firstname", Person.getFirstName())
                .addValue("username", Person.getUserName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, params, keyHolder, new String[]{"id"});
        Integer id = Objects.requireNonNull(keyHolder.getKey()).intValue();
        Person.setId(id);
        return Person;
    }

    @Override
    public Person update(Person Person) {
        String sql = "UPDATE person SET firstname = :firstname WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", Person.getId())
                .addValue("firstname", Person.getFirstName());
        jdbcTemplate.update(sql, params);
        return Person;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM person WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        jdbcTemplate.update(sql, param);
    }
}