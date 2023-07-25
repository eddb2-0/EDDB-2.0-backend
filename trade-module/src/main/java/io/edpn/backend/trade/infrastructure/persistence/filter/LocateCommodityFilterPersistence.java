package io.edpn.backend.trade.infrastructure.persistence.filter;

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
public class LocateCommodityFilterPersistence {
    private String commodityDisplayName;
    private Double xCoordinate;
    private Double yCoordinate;
    private Double zCoordinate;
    private Boolean includePlanetary;
    private Boolean includeOdyssey;
    private Boolean includeFleetCarriers;
    private String maxLandingPadSize;
    private Long minSupply;
    private Long minDemand;
}
