package com.netdava.debian.base;

import groovy.lang.Closure;
import org.gradle.api.Incubating;
import org.gradle.model.internal.core.UnmanagedStruct;
import org.gradle.platform.base.DependencySpecContainer;

import java.util.Set;

@Incubating
@UnmanagedStruct
public interface DebApiSpec {

    void exports(String packageName);

    Set<String> getExports();

    void dependencies(Closure<?> configureAction);

    DependencySpecContainer getDependencies();
}
