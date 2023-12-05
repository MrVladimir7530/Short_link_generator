--liquibase formatted sql

--changeset volkov:create_table_user
CREATE TABLE IF NOT EXISTS users(
    user_id serial PRIMARY KEY NOT NULL,
    user_name character varying(255)
);


--changeset volkov:create_table_link
CREATE TABLE IF NOT EXISTS links(
    link_id serial PRIMARY KEY NOT NULL,
    long_link character varying(255),
    short_link character varying(255),
    registered_at timestamp without time zone,
    user_id int,
    foreign key(user_id) REFERENCES users(user_id)
);