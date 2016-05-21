package com.netdava.debian

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.model.RuleSource

public class GradleComponentPlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {
    }

    @SuppressWarnings("UnusedDeclaration")
    static class Rules extends RuleSource {


    }


}
