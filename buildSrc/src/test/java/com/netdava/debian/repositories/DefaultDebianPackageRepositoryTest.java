package com.netdava.debian.repositories;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultDebianPackageRepositoryTest {

    String binRepositoryLine = "deb http://site.example.com/debian distribution component1 component2 component3";
    String srcRepositoryLine = "deb-src http://site.example.com/debian distribution component1 component2 component3";

    @Test
    public void testPackageRepositoryIsCreatedWithProperSource() throws Exception {
        DebianPackageRepository binRepository = new DefaultDebianPackageRepository(binRepositoryLine);

        assertThat(binRepository.getAptLine().toString()).isEqualToIgnoringCase(binRepositoryLine);

    }
}