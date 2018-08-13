package org.pacane;

import javax.inject.Inject;

public class SystemOutPersonPrinter implements PersonPrinter {
    @Inject
    SystemOutPersonPrinter() {
    }

    @Override
    public void print(Person p) {
        System.out.println(p.age + " " + p.name);
    }
}
