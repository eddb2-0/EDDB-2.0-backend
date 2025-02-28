package io.edpn.backend.trade.adapter.web.dto.filter;

import java.util.List;

public record RestLocateLoopRouteFilterDto(
        Double xCoordinate,
        Double yCoordinate,
        Double zCoordinate,
        List<String>commodityDisplayNames,
        Integer maxPriceAgeHours,
        Integer maxRouteDistance,
        String maxLandingPadSize,
        Integer maxArrivalDistance,
        Integer minSupply,
        Integer minDemand,
        Boolean includeSurfaceStations,
        Boolean includeOdyssey,
        Boolean includeFleetCarriers) {
}
