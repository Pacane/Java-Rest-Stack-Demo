package org.pacane;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class PersonModule {
    @Provides
    @Singleton
    static PersonPrinter providePrinter(SystemOutPersonPrinter printer) {
        return printer;
    }
}
