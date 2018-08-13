package org.pacane;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class PersonRepository {
    private static int idSeed = 0;
    private Map<Integer, Person> persons = new HashMap<>();

    @Inject
    PersonRepository() {
    }

    void add(Person p) {
        persons.put(++idSeed, p);
    }

    Person getLastInsertedPerson() {
        return persons.get(idSeed);
    }
}
