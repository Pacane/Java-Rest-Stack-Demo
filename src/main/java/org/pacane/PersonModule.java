package org.pacane;

import dagger.Module;
import dagger.Provides;

@Module
public class PersonModule {
    @Provides PersonConverter providesPersonConverter() { return new JSONPersonConverter();}
}
