package io.edpn.backend.trade.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.edpn.backend.messageprocessorlib.application.dto.eddn.data.StationArrivalDistanceResponse;
import io.edpn.backend.trade.application.domain.Station;
import io.edpn.backend.trade.application.domain.System;
import io.edpn.backend.trade.application.dto.web.object.mapper.MessageMapper;
import io.edpn.backend.trade.application.port.incomming.kafka.ReceiveKafkaMessageUseCase;
import io.edpn.backend.trade.application.port.outgoing.kafka.SendKafkaMessagePort;
import io.edpn.backend.trade.application.port.outgoing.station.CreateOrLoadStationPort;
import io.edpn.backend.trade.application.port.outgoing.station.LoadStationsByFilterPort;
import io.edpn.backend.trade.application.port.outgoing.station.UpdateStationPort;
import io.edpn.backend.trade.application.port.outgoing.stationarrivaldistancerequest.CreateStationArrivalDistanceRequestPort;
import io.edpn.backend.trade.application.port.outgoing.stationarrivaldistancerequest.DeleteStationArrivalDistanceRequestPort;
import io.edpn.backend.trade.application.port.outgoing.stationarrivaldistancerequest.ExistsStationArrivalDistanceRequestPort;
import io.edpn.backend.trade.application.port.outgoing.stationarrivaldistancerequest.LoadAllStationArrivalDistanceRequestsPort;
import io.edpn.backend.trade.application.port.outgoing.system.CreateOrLoadSystemPort;
import io.edpn.backend.util.IdGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.retry.support.RetryTemplate;

import java.util.concurrent.Executor;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReceiveStationArrivalDistanceResponseUseCaseTest {

    @Mock
    private IdGenerator idGenerator;
    @Mock
    private LoadStationsByFilterPort loadStationsByFilterPort;
    @Mock
    private LoadAllStationArrivalDistanceRequestsPort loadAllStationArrivalDistanceRequestsPort;
    @Mock
    private DeleteStationArrivalDistanceRequestPort deleteStationArrivalDistanceRequestPort;
    @Mock
    private CreateOrLoadSystemPort createOrLoadSystemPort;
    @Mock
    private CreateOrLoadStationPort createOrLoadStationPort;
    @Mock
    private ExistsStationArrivalDistanceRequestPort existsStationArrivalDistanceRequestPort;
    @Mock
    private CreateStationArrivalDistanceRequestPort createStationArrivalDistanceRequestPort;
    @Mock
    private UpdateStationPort updateStationPort;
    @Mock
    private SendKafkaMessagePort sendKafkaMessagePort;
    @Mock
    private RetryTemplate retryTemplate;
    @Mock
    private Executor executor;
    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private MessageMapper messageMapper;

    private ReceiveKafkaMessageUseCase<StationArrivalDistanceResponse> underTest;

    @BeforeEach
    public void setUp() {
        underTest = new StationArrivalDistanceInterModuleCommunicationService(
                idGenerator,
                loadStationsByFilterPort,
                loadAllStationArrivalDistanceRequestsPort,
                createOrLoadSystemPort,
                createOrLoadStationPort,
                existsStationArrivalDistanceRequestPort,
                createStationArrivalDistanceRequestPort,
                deleteStationArrivalDistanceRequestPort,
                updateStationPort,
                sendKafkaMessagePort,
                retryTemplate,
                executor,
                objectMapper,
                messageMapper);
    }

    @Test
    public void shouldReceiveStationArrivalDistanceResponse() {
        StationArrivalDistanceResponse message =
                new StationArrivalDistanceResponse("station", "system", 1.0);

        System system = mock(System.class);
        when(createOrLoadSystemPort.createOrLoad(argThat(argument -> argument.getName().equals("system")))).thenReturn(system);

        Station station = mock(Station.class);
        when(createOrLoadStationPort.createOrLoad(argThat(argument -> argument.getSystem().equals(system) && argument.getName().equals("station")))).thenReturn(station);

        underTest.receive(message);

        verify(station).setArrivalDistance(1.0);
        verify(updateStationPort, times(1)).update(station);
        verify(deleteStationArrivalDistanceRequestPort, times(1)).delete("system", "station");
    }
}
