package io.edpn.backend.trade.adapter.persistence.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class MybatisLocateSingleHopTradeFilter {
    
    private String buyFromSystemName;//TODO
    private String buyFromStationName;//TODO
    private String sellToSystemName;
    private String sellToStationName;//TODO
    private List<String> commodityDisplayNames;
    private Integer maxPriceAgeHours;
    private Integer maxRouteDistance;
    private String maxLandingPadSize;
    private Integer maxArrivalDistance;
    private Integer cargoCapacity;
    private Boolean includeSurfaceStations;
    private Boolean includeFleetCarriers;
}
