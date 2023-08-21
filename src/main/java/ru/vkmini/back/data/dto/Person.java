package ru.vkmini.back.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String userName;
}
