package ru.mdm.registry.client.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactivefeign.spring.config.EnableReactiveFeignClients;
import ru.mdm.registry.client.feign.RegistryServiceFeignClient;

/**
 * Автоконфигурация клиента сервиса.
 */
@Configuration
@ComponentScan(basePackages = "ru.mdm.registry.client")
@EnableReactiveFeignClients(clients = {RegistryServiceFeignClient.class})
public class RegistryClientAutoConfiguration {

    @Value("${mdm.registry.service.url}")
    private String serviceUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.create(serviceUrl);
    }
}
