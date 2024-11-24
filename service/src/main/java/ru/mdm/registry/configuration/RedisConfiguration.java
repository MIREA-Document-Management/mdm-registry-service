package ru.mdm.registry.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Конфигурация Redis.
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public ReactiveRedisTemplate<String, Object> objectRedisTemplate(ReactiveRedisConnectionFactory factory,
                                                                     ObjectMapper objectMapper) {
        var jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);

        RedisSerializationContext<String, Object> serializationContext = RedisSerializationContext
                .<String, Object>newSerializationContext(new StringRedisSerializer())
                .value(jsonRedisSerializer)
                .hashValue(jsonRedisSerializer)
                .build();
        return new ReactiveRedisTemplate<>(factory, serializationContext);
    }
}
