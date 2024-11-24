package ru.mdm.registry.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "Модель экземпляра сервиса")
public class InstanceDto {

    @Schema(description = "Идентификатор экземпляра приложения")
    private String id;

    @Schema(description = "Наименование регистрируемого сервиса")
    private String name;

    @Schema(description = "Описание регистрируемого сервиса")
    private String description;

    @Schema(description = "Версия регистрируемого сервиса")
    private String version;

    @Schema(description = "Маршрут к регистрируемуму сервиса")
    private RouteDto route;

    @Schema(description = "Хост регистрируемого сервиса")
    private String host;

    @Schema(description = "Время актуализации информации по экземпляру приложения")
    private LocalDateTime heartbeatTime;

    @Schema(description = "Эндпоинты регистрируемого сервиса")
    private List<EndpointDto> endpoints;
}
