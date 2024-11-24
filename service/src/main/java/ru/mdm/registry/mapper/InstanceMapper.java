package ru.mdm.registry.mapper;

import org.apache.commons.codec.digest.DigestUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.mdm.registry.model.InstanceDto;
import ru.mdm.registry.model.RegisterServiceDto;

import java.time.LocalDateTime;

@Mapper
public interface InstanceMapper {

    @Mapping(target = "id", expression = "java(getId(dto))")
    @Mapping(target = "heartbeatTime", expression = "java(getHeartbeatTime())")
    InstanceDto toInstanceDto(RegisterServiceDto dto);

    default LocalDateTime getHeartbeatTime() {
        return LocalDateTime.now();
    }

    default String getId(RegisterServiceDto dto) {
        return DigestUtils.sha1Hex(dto.getHost() + dto.getRoute().getUri());
    }
}
