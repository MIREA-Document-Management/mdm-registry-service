package ru.mdm.registry.repository;

import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Репозитрорий для взаимодействия с экземплярами сервисов.
 */
public interface ServiceRepository {

    /**
     * Сохранить объект по ключу.
     *
     * @param key   ключ
     * @param value объект
     * @param ttl   время жизни записи
     */
    Mono<Void> save(String key, Object value, Duration ttl);


}
