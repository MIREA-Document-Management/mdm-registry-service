package ru.mdm.registry.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.mdm.registry.client.feign.RegistryServiceFeignClient;
import ru.mdm.registry.model.InstanceDto;
import ru.mdm.registry.model.RegisterServiceDto;
import ru.mdm.registry.service.RegistryService;

/**
 * Реализация клиента для работы с экземплярами сервисов.
 */
@Service
@RequiredArgsConstructor
public class RegistryClient implements RegistryService {

    private final RegistryServiceFeignClient registryServiceFeignClient;

    @Override
    public Mono<InstanceDto> registerService(RegisterServiceDto serviceDto) {
        return registryServiceFeignClient.registerService(serviceDto);
    }
}
