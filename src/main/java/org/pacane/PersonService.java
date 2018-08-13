package org.pacane;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PersonService {
    private final PersonRepository repository;

    @Inject
    PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    void add(Person p) {
        repository.add(p);
    }

    public Person getLastPersonAdded() {
        return repository.getLastInsertedPerson();
    }
}
