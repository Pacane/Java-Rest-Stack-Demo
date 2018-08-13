package org.pacane;

public class Main {
    public static void main(String[] args) {
        org.pacane.PersonApp app = org.pacane.DaggerPersonApp.builder().build();
        PersonService service = app.getService();

        Person p = new Person();
        p.name = "Kenneth";
        p.age = 42;

        service.add(p);

        service.printLastAddedPerson();
    }
}
