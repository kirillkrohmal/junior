package ru.job4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Validator {
    private static Validator SINGLETON = new Validator();
    private static List<Hall> halls = new ArrayList<>();

    private ConcurrentHashMap<Integer, Hall> storage = new ConcurrentHashMap<>();

    public Collection<Hall> values() {
        return storage.values();
    }

    public static Validator getInstance() {
        return SINGLETON;
    }

    public void add(Hall hall) {
        halls.add(hall);
    }

}
