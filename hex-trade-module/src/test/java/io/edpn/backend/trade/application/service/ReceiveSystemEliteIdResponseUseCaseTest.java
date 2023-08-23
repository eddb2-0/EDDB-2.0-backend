package io.edpn.backend.trade.application.service;

import io.edpn.backend.messageprocessorlib.application.dto.eddn.data.SystemEliteIdResponse;
import io.edpn.backend.trade.application.domain.System;
import io.edpn.backend.trade.application.port.incomming.kafka.ReceiveKafkaMessageUseCase;
import io.edpn.backend.trade.application.port.outgoing.system.LoadOrCreateSystemByNamePort;
import io.edpn.backend.trade.application.port.outgoing.system.UpdateSystemPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReceiveSystemEliteIdResponseUseCaseTest {
    
    @Mock
    private LoadOrCreateSystemByNamePort loadOrCreateSystemByNamePort;
    
    @Mock
    private UpdateSystemPort updateSystemPort;
    
    private ReceiveKafkaMessageUseCase<SystemEliteIdResponse> underTest;

    @BeforeEach
    public void setUp() {
        underTest = new ReceiveSystemEliteIdResponseService(loadOrCreateSystemByNamePort, updateSystemPort);
    }

    @Test
    public void shouldReceiveSystemEliteIdResponse() {
        SystemEliteIdResponse message = new SystemEliteIdResponse();
        message.setSystemName("system");
        message.setEliteId(1234);

        System system = System.builder()
                .name("system")
                .build();
        when(loadOrCreateSystemByNamePort.loadOrCreateSystemByName("system")).thenReturn(system);

        underTest.receive(message);

        verify(loadOrCreateSystemByNamePort, times(1)).loadOrCreateSystemByName(anyString());
        verify(updateSystemPort, times(1)).update(any());

        assert (system.getEliteId() == 1234);
    }
}
