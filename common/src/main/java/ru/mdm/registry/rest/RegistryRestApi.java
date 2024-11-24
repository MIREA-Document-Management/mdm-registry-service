package ru.mdm.registry.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;
import ru.mdm.registry.model.InstanceDto;
import ru.mdm.registry.model.RegisterServiceDto;

/**
 * REST-API для управления микросервисами.
 */
public interface RegistryRestApi {

    String BASE_URI = "/api/v1/applications";

    @Operation(summary = "Зарегистрировать экземпляр сервиса",
            description = "Зарегистрировать экземпляр сервиса в реестре",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Экземпляр сервиса зарегистрирован",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = RegisterServiceDto.class))),
                    @ApiResponse(responseCode = "400", description = "Неверный формат переданных значений",
                            content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера",
                            content = @Content(schema = @Schema(hidden = true)))
            })
    @PutMapping
    Mono<InstanceDto> registerService(@RequestBody RegisterServiceDto serviceDto);
}
