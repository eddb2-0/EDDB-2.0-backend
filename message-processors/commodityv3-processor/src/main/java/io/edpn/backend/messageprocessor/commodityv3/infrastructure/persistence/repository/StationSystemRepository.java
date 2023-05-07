package io.edpn.backend.messageprocessor.commodityv3.infrastructure.persistence.repository;

import io.edpn.backend.messageprocessor.commodityv3.application.dto.persistence.StationSystemEntity;
import io.edpn.backend.messageprocessor.commodityv3.infrastructure.persistence.mappers.StationSystemEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class StationSystemRepository implements io.edpn.backend.messageprocessor.commodityv3.domain.repository.StationSystemRepository {

    private final StationSystemEntityMapper stationSystemEntityMapper;

    @Override
    public StationSystemEntity update(StationSystemEntity entity) {
        stationSystemEntityMapper.update(entity);
        return findById(entity.getStationId())
                .orElseThrow(() -> new RuntimeException("stationSystem with StationId: " + entity.getStationId() + " could not be found after update"));
    }

    @Override
    public StationSystemEntity create(StationSystemEntity entity) {
        stationSystemEntityMapper.insert(entity);
        return findById(entity.getStationId())
                .orElseThrow(() -> new RuntimeException("stationSystem with StationId: " + entity.getStationId() + " could not be found after create"));
    }

    @Override
    public Optional<StationSystemEntity> findById(UUID id) {
        return stationSystemEntityMapper.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        stationSystemEntityMapper.delete(id);
    }
}
