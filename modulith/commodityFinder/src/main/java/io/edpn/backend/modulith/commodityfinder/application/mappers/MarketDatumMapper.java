package io.edpn.backend.modulith.commodityfinder.application.mappers;

import io.edpn.backend.modulith.commodityfinder.application.dto.persistence.MarketDatumEntity;
import io.edpn.backend.modulith.commodityfinder.domain.entity.MarketDatum;
import io.edpn.backend.modulith.commodityfinder.domain.entity.Station;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MarketDatumMapper {

    private final CommodityMapper commodityMapper;
    private final StationMapper stationMapper;

    public List<MarketDatum> map(List<MarketDatumEntity> marketDatumEntityList) {
        return marketDatumEntityList.stream().map(this::map).toList();
    }

    public MarketDatum map(MarketDatumEntity marketDatumEntity) {
        return MarketDatum.builder()
                .commodity(commodityMapper.map(marketDatumEntity.getCommodity()))
                .meanPrice(marketDatumEntity.getMeanPrice())
                .buyPrice(marketDatumEntity.getBuyPrice())
                .stock(marketDatumEntity.getStock())
                .stockBracket(marketDatumEntity.getStockBracket())
                .sellPrice(marketDatumEntity.getSellPrice())
                .demand(marketDatumEntity.getDemand())
                .demandBracket(marketDatumEntity.getDemandBracket())
                .statusFlags(marketDatumEntity.getStatusFlags())
                .prohibited(marketDatumEntity.isProhibited())
                .build();
    }

    public List<MarketDatumEntity> map(Station station, List<MarketDatum> marketDatumList) {
        return marketDatumList.stream().map(marketDatum -> this.map(station, marketDatum)).toList();
    }

    public MarketDatumEntity map(Station station, MarketDatum marketDatum) {
        return MarketDatumEntity.builder()
                .station(stationMapper.map(station))
                .commodity(commodityMapper.map(marketDatum.getCommodity()))
                .meanPrice(marketDatum.getMeanPrice())
                .buyPrice(marketDatum.getBuyPrice())
                .stock(marketDatum.getStock())
                .stockBracket(marketDatum.getStockBracket())
                .sellPrice(marketDatum.getSellPrice())
                .demand(marketDatum.getDemand())
                .demandBracket(marketDatum.getDemandBracket())
                .statusFlags(marketDatum.getStatusFlags())
                .prohibited(marketDatum.isProhibited())
                .build();
    }
}
