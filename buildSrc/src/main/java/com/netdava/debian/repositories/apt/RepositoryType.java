package com.netdava.debian.repositories.apt;

import lombok.NonNull;

public enum RepositoryType {
    DEB("deb"),
    DEB_SRC("deb-src");

    private String type;

    RepositoryType(String type) {
        this.type = type;
    }

    public static RepositoryType parse(@NonNull String repositoryType) {
        switch (repositoryType.toLowerCase()) {
            case "deb":
                return DEB;
            case "deb-src":
                return DEB_SRC;
            default:
                throw new IllegalStateException("Unknown repository type " + repositoryType);
        }
    }

    @Override
    public String toString() {
        return type;
    }
}
