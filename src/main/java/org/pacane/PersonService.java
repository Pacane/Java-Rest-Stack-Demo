package org.pacane;

import javax.inject.Inject;

public class PersonService {
    private final PersonRepository repository;
    private final PersonPrinter printer;

    @Inject
    PersonService(PersonRepository repository, PersonPrinter printer) {
        this.repository = repository;
        this.printer = printer;
    }

    void add(Person p) {
        repository.add(p);
    }

    void printLastAddedPerson() {
        Person person = repository.getLastInsertedPerson();

        printer.print(person);
    }
}
