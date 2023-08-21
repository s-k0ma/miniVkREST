package ru.vkmini.back.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.vkmini.back.data.dto.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setEmail(rs.getString("email"));
        person.setPassword(rs.getString("password"));
        person.setFirstName(rs.getString("firstname"));
        person.setUserName(rs.getString("username"));

        return person;
    }
}
