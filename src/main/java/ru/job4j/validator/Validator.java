package ru.job4j.validator;

import ru.job4j.model.Hall;
import ru.job4j.storage.JdbcStorage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Validator {
    private static Validator SINGLETON = new Validator();
    private static List<Hall> halls = new ArrayList<>();
    JdbcStorage jdbcStorage = new JdbcStorage();

    private ConcurrentHashMap<Integer, Hall> storage = new ConcurrentHashMap<>();

    public Collection<Hall> values() {
        return storage.values();
    }

    public static Validator getInstance() {
        return SINGLETON;
    }

    public void save(Hall hall) {
        jdbcStorage.save(hall);
    }

    public void findAll() {
        jdbcStorage.getAll();
    }

}
