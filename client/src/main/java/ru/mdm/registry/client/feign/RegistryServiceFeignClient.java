package ru.mdm.registry.client.feign;

import reactivefeign.spring.config.ReactiveFeignClient;
import ru.mdm.registry.client.configuration.feign.FeignClientConfiguration;
import ru.mdm.registry.rest.RegistryRestApi;

/**
 * Клиент для работы с экземплярами сервисов.
 */
@ReactiveFeignClient(name = "mdm-registry-client", configuration = FeignClientConfiguration.class,
        url = "${mdm.registry.service.url}", path = RegistryRestApi.BASE_URI)
public interface RegistryServiceFeignClient extends RegistryRestApi {
}
