package ru.mdm.registry.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Модель для регистрации сервиса")
public class RegisterServiceDto {

    @NotBlank(message = "Отсутствует наименование регистрируемого сервиса")
    @Schema(description = "Наименование регистрируемого сервиса")
    private String name;

    @NotBlank(message = "Отсутствует описание регистрируемого сервиса")
    @Schema(description = "Описание регистрируемого сервиса")
    private String description;

    @NotBlank(message = "Отсутствует версия регистрируемого сервиса")
    @Schema(description = "Версия регистрируемого сервиса")
    private String version;

    @NotNull(message = "Отсутствует маршрут к регистрируемуму сервиса")
    @Schema(description = "Маршрут к регистрируемуму сервиса")
    private RouteDto route;

    @NotBlank(message = "Отсутствует хост регистрируемого сервиса")
    @Schema(description = "Хост регистрируемого сервиса")
    private String host;

    @Schema(description = "Эндпоинты регистрируемого сервиса")
    private List<EndpointDto> endpoints;
}
