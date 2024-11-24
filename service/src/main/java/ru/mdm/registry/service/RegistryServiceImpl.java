package ru.mdm.registry.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;
import ru.mdm.kafka.service.KafkaService;
import ru.mdm.registry.configuration.RegistryServiceProperties;
import ru.mdm.registry.event.RegisterServiceEventSuccess;
import ru.mdm.registry.exception.ErrorCode;
import ru.mdm.registry.mapper.InstanceMapper;
import ru.mdm.registry.model.InstanceDto;
import ru.mdm.registry.model.RegisterServiceDto;
import ru.mdm.registry.repository.ServiceRepository;
import ru.mdm.registry.util.ExceptionUtils;

import static ru.mdm.registry.repository.RedisServiceRepository.INSTANCE_KEY_TEMPLATE;

/**
 * Реализация сервиса для взаимодействия с экземплярами сервисов.
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class RegistryServiceImpl implements RegistryService {

    private final ServiceRepository serviceRepository;
    private final InstanceMapper mapper;
    private final RegistryServiceProperties registryServiceProperties;
    private final KafkaService kafkaService;

    @Override
    public Mono<InstanceDto> registerService(RegisterServiceDto serviceDto) {
        return Mono.just(serviceDto)
                .map(mapper::toInstanceDto)
                .flatMap(instance -> serviceRepository.save(
                                INSTANCE_KEY_TEMPLATE.formatted(instance.getName(), instance.getId()).toLowerCase(),
                                instance,
                                registryServiceProperties.getInstanceStorageTtl())
                        .thenReturn(instance))
                .flatMap(instance -> kafkaService.sendEvent(RegisterServiceEventSuccess.of(instance)).thenReturn(instance))
                .onErrorMap(ExceptionUtils.extExceptionMapper(ErrorCode.CANNOT_REGISTER_SERVICE.getText()));
    }
}
