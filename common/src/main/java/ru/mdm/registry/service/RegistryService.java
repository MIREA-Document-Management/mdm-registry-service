package ru.mdm.registry.service;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;
import ru.mdm.registry.model.InstanceDto;
import ru.mdm.registry.model.RegisterServiceDto;

/**
 * Сервис для взаимодействия с экземплярами сервисов.
 */
public interface RegistryService {

    /**
     * Зарегистрировать экземпляр сервиса.
     *
     * @param serviceDto модель для регистрации эезмепляра
     * @return информация о зарегистрированном экземпляре
     */
    Mono<InstanceDto> registerService(@Valid RegisterServiceDto serviceDto);
}
