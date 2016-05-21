package com.netdava.debian.repositories;

import com.netdava.debian.repositories.apt.AptLine;
import org.gradle.api.artifacts.repositories.ArtifactRepository;
import org.gradle.api.artifacts.repositories.AuthenticationSupported;
import org.gradle.model.Unmanaged;

public interface DebianPackageRepository extends AuthenticationSupported, ArtifactRepository {

    @Unmanaged
    AptLine getAptLine();
}
