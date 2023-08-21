CREATE TABLE person (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) UNIQUE NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO person(email, password, firstname, username)
VALUES ('s_koma@test.ru', '12345', 'Sergei', 's-k0ma'),
       ('k_kostya@test.ru', '54321', 'Kostya', 'wanderer');