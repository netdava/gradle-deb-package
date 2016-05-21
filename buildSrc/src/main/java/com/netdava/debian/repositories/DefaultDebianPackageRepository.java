package com.netdava.debian.repositories;

import com.netdava.debian.repositories.apt.AptLine;
import org.gradle.api.Action;
import org.gradle.api.artifacts.repositories.AuthenticationContainer;
import org.gradle.api.artifacts.repositories.PasswordCredentials;
import org.gradle.api.credentials.Credentials;

public class DefaultDebianPackageRepository implements DebianPackageRepository {

    private AptLine aptLine;

    public DefaultDebianPackageRepository(String aptLine) {
        this.aptLine = new AptLine(aptLine);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public PasswordCredentials getCredentials() {
        return null;
    }

    @Override
    public <T extends Credentials> T getCredentials(Class<T> credentialsType) {
        return null;
    }

    @Override
    public void credentials(Action<? super PasswordCredentials> action) {

    }

    @Override
    public <T extends Credentials> void credentials(Class<T> credentialsType, Action<? super T> action) {

    }

    @Override
    public void authentication(Action<? super AuthenticationContainer> action) {

    }

    @Override
    public AuthenticationContainer getAuthentication() {
        return null;
    }

    @Override
    public AptLine getAptLine() {
        return aptLine;
    }
}
