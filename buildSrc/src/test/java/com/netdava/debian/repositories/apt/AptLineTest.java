package com.netdava.debian.repositories.apt;

import org.junit.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

public class AptLineTest {

    String binRepositoryLine = "deb http://site.example.com/debian distribution component1 component2 component3";
    String srcRepositoryLine = "DEB-SRC http://site.example.com/debian distribution component1 component2 component3";

    @Test
    public void testAptLineParseWorksForBinaryRepository() throws Exception {
        AptLine binRepo = new AptLine(binRepositoryLine);

        assertThat(binRepo.getType()).isEqualTo(RepositoryType.DEB);
        assertThat(binRepo.getDistribution()).isEqualTo("distribution");
        assertThat(binRepo.getRepoUrl()).isEqualTo(URI.create("http://site.example.com/debian"));
        assertThat(binRepo.getComponents().size()).isEqualTo(3);

        assertThat(binRepo.toString()).isEqualTo(binRepositoryLine);

    }

    @Test
    public void testAptLineParseWorksForSrcRepository() throws Exception {
        AptLine binRepo = new AptLine(srcRepositoryLine);

        assertThat(binRepo.getType()).isEqualTo(RepositoryType.DEB_SRC);
        assertThat(binRepo.getDistribution()).isEqualTo("distribution");
        assertThat(binRepo.getRepoUrl()).isEqualTo(URI.create("http://site.example.com/debian"));
        assertThat(binRepo.getComponents().size()).isEqualTo(3);

        assertThat(binRepo.toString()).isEqualToIgnoringCase(srcRepositoryLine);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseFailesForLessComponents() throws Exception {
        AptLine invalidRepo = new AptLine("deb-src https://aaaa.local test");
    }

    @Test(expected = IllegalStateException.class)
    public void testParseFailesForINvalidRepoType() throws Exception {
        AptLine invalidRepo = new AptLine("debsrc http://site.example.com/debian distribution component1 ");
    }
}