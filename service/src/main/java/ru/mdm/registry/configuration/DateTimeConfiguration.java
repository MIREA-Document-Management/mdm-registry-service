package ru.mdm.registry.configuration;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Конфигурация json DateTime.
 */
@Configuration
public class DateTimeConfiguration {
    public static final String FIXED_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final DateTimeFormatter FIXED_DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern(FIXED_DATETIME_FORMAT);
    private static final LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER =
            new LocalDateTimeSerializer(FIXED_DATETIME_FORMATTER);
    private static final LocalDateTimeDeserializer LOCAL_DATE_TIME_DESERIALIZER =
            new LocalDateTimeDeserializer(FIXED_DATETIME_FORMATTER);

    /**
     * Кастомный JavaTimeModule, задающий фиксированный формат конвертации в/из json полей типа LocalDateTime.
     *
     * @return JavaTimeModule
     */
    @Bean
    public com.fasterxml.jackson.databind.Module javaTimeModule() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LOCAL_DATETIME_SERIALIZER);
        module.addDeserializer(LocalDateTime.class, LOCAL_DATE_TIME_DESERIALIZER);
        return module;
    }
}
