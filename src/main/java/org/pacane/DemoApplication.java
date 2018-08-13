package org.pacane;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class DemoApplication extends Application {
    private final PersonComponent app;

    public DemoApplication(PersonComponent app) {
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
