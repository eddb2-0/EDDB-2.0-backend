package io.edpn.backend.modulith.commodityfinder.application.mappers;

import io.edpn.backend.modulith.commodityfinder.application.dto.persistence.SystemEntity;
import io.edpn.backend.modulith.commodityfinder.domain.entity.System;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemMapper {

    public System map(SystemEntity systemEntity) {
        return System.builder()
                .eliteId(systemEntity.getEliteId())
                .id(systemEntity.getId())
                .name(systemEntity.getName())
                .xCoordinate(systemEntity.getXCoordinate())
                .yCoordinate(systemEntity.getYCoordinate())
                .zCoordinate(systemEntity.getZCoordinate())
                .build();
    }

    public SystemEntity map(System system) {
        return SystemEntity.builder()
                .eliteId(system.getEliteId())
                .id(system.getId())
                .name(system.getName())
                .xCoordinate(system.getXCoordinate())
                .yCoordinate(system.getYCoordinate())
                .zCoordinate(system.getZCoordinate())
                .build();
    }
}
