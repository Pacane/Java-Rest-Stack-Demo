package org.pacane;

public interface PersonConverter {
    String toJson(Person person);
    Person fromJson(String json);
}
