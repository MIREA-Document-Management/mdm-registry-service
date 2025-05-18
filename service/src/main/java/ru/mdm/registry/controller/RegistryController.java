package ru.mdm.registry.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.mdm.registry.model.InstanceDto;
import ru.mdm.registry.model.RegisterServiceDto;
import ru.mdm.registry.rest.RegistryRestApi;
import ru.mdm.registry.service.RegistryService;

/**
 * Контроллер для взаимодействия с экземплярами сервисов.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(RegistryRestApi.BASE_URI)
public class RegistryController implements RegistryRestApi {

    private final RegistryService registryServiceImpl;

    @Override
    public Mono<InstanceDto> registerService(RegisterServiceDto serviceDto) {
        return registryServiceImpl.registerService(serviceDto);
    }

    @Override
    public Flux<InstanceDto> getServices() {
        return registryServiceImpl.getServices();
    }
}
