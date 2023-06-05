package io.edpn.backend.commodityfinder.domain.repository;

import io.edpn.backend.commodityfinder.domain.model.System;
import io.edpn.backend.util.exception.DatabaseEntityNotFoundException;

import java.util.Optional;
import java.util.UUID;

public interface SystemRepository {

    System findOrCreateByName(String name) throws DatabaseEntityNotFoundException;

    System update(System entity);

    System create(System entity) throws DatabaseEntityNotFoundException;

    Optional<System> findById(UUID id);
}
