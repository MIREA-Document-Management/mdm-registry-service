package ru.mdm.registry.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Репозиторий для работы с Redis.
 */
@Repository
@RequiredArgsConstructor
public class RedisServiceRepository implements ServiceRepository {

    public static final String INSTANCE_KEY_TEMPLATE = "mdm:registry:applications:%s:instances:%s";

    private final ReactiveRedisTemplate<String, Object> objectRedisTemplate;

    @Override
    public Mono<Void> save(String key, Object value, Duration ttl) {
        return objectRedisTemplate.opsForValue()
                .set(key, value, ttl)
                .then();
    }
}
