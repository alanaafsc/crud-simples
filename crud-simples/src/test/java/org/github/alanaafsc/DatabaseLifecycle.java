package org.github.alanaafsc;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.hibernate.resource.beans.container.internal.ContainerManagedLifecycleStrategy;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseLifecycle implements QuarkusTestResourceLifecycleManager {
    private static PostgreSQLContainer<?> POSTGRESQL = new PostgreSQLContainer<>("postgres:latest");

    @Override
    public Map<String, String> start() {
        POSTGRESQL.start();
        Map<String, String> propriedades = new HashMap<>();
        propriedades.put("quarkus.datasource.url", POSTGRESQL.getJdbcUrl());
        propriedades.put("quarkus.datasource.username", POSTGRESQL.getUsername());
        propriedades.put("quarkus.datasource.password", POSTGRESQL.getPassword());

        return propriedades;
    }

    @Override
    public void stop() {

    }
}
