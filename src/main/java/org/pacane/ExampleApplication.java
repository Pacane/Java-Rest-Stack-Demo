package org.pacane;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ExampleApplication extends Application {
    private final PersonApp app;

    public ExampleApplication(PersonApp app) {
        this.app = app;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }

    @Override
    public Set<Object> getSingletons() {
        HashSet<Object> objects = new HashSet<>();
        objects.add(app.getHelloWorldResource());
        return objects;
    }
}
