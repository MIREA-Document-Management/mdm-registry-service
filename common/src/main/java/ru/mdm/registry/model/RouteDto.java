package ru.mdm.registry.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Модель маршрута к определенному сервису")
public class RouteDto {

    private String uri;
    private List<String> predicates;
    private List<String> filters;
}
