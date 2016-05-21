package com.netdava.debian.base;

import org.gradle.platform.base.DependencySpecContainer;
import org.gradle.platform.base.GeneralComponentSpec;
import org.gradle.platform.base.PlatformAwareComponentSpec;

public interface DebPackageSpec extends GeneralComponentSpec, PlatformAwareComponentSpec {

    DebApiSpec getApi();

    /**
     * The component-level dependencies of this library.
     */
    DependencySpecContainer getDependencies();
}
