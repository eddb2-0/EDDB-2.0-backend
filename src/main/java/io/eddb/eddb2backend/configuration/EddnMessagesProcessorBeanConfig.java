package io.eddb.eddb2backend.configuration;

import io.eddb.eddb2backend.application.usecase.ReceiveCommodityMessageUsecase;
import io.eddb.eddb2backend.infrastructure.kafka.processor.CommodityV3MessageProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EddnMessagesProcessorBeanConfig {
    @Bean
    public CommodityV3MessageProcessor commodityV3MessageProcessor(ReceiveCommodityMessageUsecase receiveCommodityMessageUsecase) {
        return new CommodityV3MessageProcessor(receiveCommodityMessageUsecase);
    }
}
