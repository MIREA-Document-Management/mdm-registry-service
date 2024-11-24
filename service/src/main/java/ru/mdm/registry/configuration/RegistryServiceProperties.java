package ru.mdm.registry.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Data
@Configuration
@ConfigurationProperties("mdm.registry.service")
public class RegistryServiceProperties {

    private Duration instanceStorageTtl = Duration.ofMinutes(10);
}
