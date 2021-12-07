package com.example.jpapoc.configs;

import com.zaxxer.hikari.HikariDataSource;
import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class FlywayConfig {
    @Autowired
    @Qualifier("msDataSource")
    HikariDataSource msDataSource;

    //To run flyway migration before the bpm engine gets created (also trying to read database)
    @Bean
    AbstractProcessEnginePlugin flywayInitializingProcessEnginePlugin() {
        return new AbstractProcessEnginePlugin() {
            @Override
            public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
                migrateFlyway();
            }
        };
    }

    public void migrateFlyway() {
        ClassicConfiguration paymentConfiguration = new ClassicConfiguration();
        paymentConfiguration.setDataSource(msDataSource);
        paymentConfiguration.setLocations(new Location("db/migration"));
        Flyway flyway = new Flyway(paymentConfiguration);
        flyway.migrate();
    }

}
