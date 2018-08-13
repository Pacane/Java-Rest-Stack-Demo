package org.pacane;

import com.google.gson.Gson;

import javax.inject.Singleton;

@Singleton
public class JSONPersonConverter implements PersonConverter {
    private final Gson gson;

    JSONPersonConverter() {
        gson = new Gson();
    }

    @Override
    public String toJson(Person person) {
        return gson.toJson(person);
    }

    @Override
    public Person fromJson(String json) {
        return gson.fromJson(json, Person.class);
    }
}
