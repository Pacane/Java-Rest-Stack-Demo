package org.pacane;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {PersonModule.class})
public interface PersonApp {
    HelloWorldEndPoint getHelloWorldResource();
    PersonService getPersonService();
}
