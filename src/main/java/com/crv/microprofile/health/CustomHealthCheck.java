package com.crv.microprofile.health;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

import lombok.extern.slf4j.Slf4j;

@Health
@Slf4j
@ApplicationScoped
public class CustomHealthCheck implements HealthCheck {
    private static final Logger logger = LoggerFactory.getLogger(CustomHealthCheck.class);
    @Override
    public HealthCheckResponse call() {
        logger.info("Starting healthcheck");
        return HealthCheckResponse.named("generic")
                                  .withData("everything", "ok")
                                  .up()
                                  .build();
    }
}
