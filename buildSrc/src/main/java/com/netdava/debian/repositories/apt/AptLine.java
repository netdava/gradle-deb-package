package com.netdava.debian.repositories.apt;


import lombok.Data;
import lombok.NonNull;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parse a Debian Apt source line to extract components.
 * <p>
 * https://wiki.debian.org/SourcesList
 */
@Data
public class AptLine {

    private RepositoryType type;
    private URI repoUrl;
    private String distribution;

    private List<String> components;

    public AptLine(@NonNull String aptLine) {
        String[] parts = aptLine.split("\\s");

        if (parts.length < 4) {
            throw new IllegalArgumentException("A proper sources.list line contains minimum 4 parts." + aptLine);
        }

        this.type = RepositoryType.parse(parts[0]);
        this.repoUrl = URI.create(parts[1]);
        this.distribution = parts[2];

        this.components = new ArrayList<>();
        this.components.addAll(Arrays.asList(Arrays.copyOfRange(parts, 3, parts.length)));
    }

    @Override
    public String toString() {
        String componentList = components.stream().collect(Collectors.joining(" "));

        return new StringBuilder(type.toString()).append(" ")
                .append(repoUrl.toString()).append(" ")
                .append(distribution).append(" ")
                .append(componentList)
                .toString();
    }

}
