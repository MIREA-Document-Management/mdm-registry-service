package ru.mdm.registry.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMethod;

@Data
@Schema(description = "Модель для описания эндпоинта сервиса")
public class EndpointDto {

    @Schema(description = "Путь к эндпоинту")
    private String path;

    @Schema(description = "Метод эндпоинта")
    private RequestMethod method;
}
