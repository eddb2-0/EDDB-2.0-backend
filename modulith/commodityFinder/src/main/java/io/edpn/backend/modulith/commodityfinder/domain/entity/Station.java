package io.edpn.backend.modulith.commodityfinder.domain.entity;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Station {

    private UUID id;
    private Long marketId;
    private String name;
    private System system;
    private boolean planetary;
    private boolean requireOdyssey;
    private boolean fleetCarrier;
    private LandingPadSize maxLandingPadSize;
    private LocalDateTime marketUpdatedAt;
    private Map<Commodity, MarketDatum> commodityMarketData;
}
