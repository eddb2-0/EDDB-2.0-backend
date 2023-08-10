package io.edpn.backend.trade.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class MarketDatum {

    private Commodity commodity;
    private LocalDateTime timestamp;
    private long meanPrice;
    private long buyPrice;
    private long stock;
    private long stockBracket;
    private long sellPrice;
    private long demand;
    private long demandBracket;
    @Builder.Default
    private List<String> statusFlags = new ArrayList<>();
    private boolean prohibited;
}
