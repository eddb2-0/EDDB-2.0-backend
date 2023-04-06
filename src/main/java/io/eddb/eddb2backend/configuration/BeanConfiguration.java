package io.eddb.eddb2backend.configuration;

import io.eddb.eddb2backend.application.usecase.GetStationUsecase;
import io.eddb.eddb2backend.application.usecase.impl.GetStationUsecaseImpl;
import io.eddb.eddb2backend.domain.repository.StationRepository;
import io.eddb.eddb2backend.infrastructure.persistence.StationRepositoryAdapter;
import io.eddb.eddb2backend.infrastructure.persistence.postgresql.PostgresqlStationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public StationRepository stationRepository(PostgresqlStationRepository postgresqlStationRepository) {
        return new StationRepositoryAdapter(postgresqlStationRepository);
    }

    @Bean
    public GetStationUsecase getStationUsecase(StationRepository stationRepository) {
        return new GetStationUsecaseImpl(stationRepository);
    }
}
