package io.eddb.eddb2backend.domain.model;

import lombok.Builder;

@Builder
public record Station(Long id, String name) {
}
