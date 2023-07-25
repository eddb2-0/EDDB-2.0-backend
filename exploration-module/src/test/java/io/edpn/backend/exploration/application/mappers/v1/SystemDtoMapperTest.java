package io.edpn.backend.exploration.application.mappers.v1;

import io.edpn.backend.exploration.application.dto.v1.SystemDTO;
import io.edpn.backend.exploration.domain.model.System;
import org.junit.jupiter.api.Test;
import org.springframework.cache.support.NullValue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SystemDtoMapperTest {

    private final SystemDtoMapper underTest = new SystemDtoMapper();

    @Test
    void shouldMapSystemToSystemDTOWithCoordinates() {
        System system = System.builder()
                .name("Test System")
                .eliteId(1L)
                .xCoordinate(2.0)
                .yCoordinate(3.0)
                .zCoordinate(4.0)
                .build();

        SystemDTO result = underTest.map(system);

        assertThat(system.getName(), equalTo(result.getName()));
        assertThat(system.getEliteId(), equalTo(result.getEliteId()));
        assertThat(system.getXCoordinate(), equalTo(result.getCoordinates().getX()));
        assertThat(system.getYCoordinate(), equalTo(result.getCoordinates().getY()));
        assertThat(system.getZCoordinate(), equalTo(result.getCoordinates().getZ()));
    }

    @Test
    void shouldMapSystemToSystemDTOWithoutCoordinates() {
        System system = System.builder()
                .name("Test System")
                .eliteId(1L)
                .build();

        SystemDTO result = underTest.map(system);

        assertThat(system.getName(), equalTo(result.getName()));
        assertThat(system.getEliteId(), equalTo(result.getEliteId()));
        assertThat(result.getCoordinates(), is(nullValue()));
    }
}
