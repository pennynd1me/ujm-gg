package gg.ujm.pennynd1me.domain.apis.dto;


import gg.ujm.pennynd1me.domain.apis.league.MiniSeries;
import lombok.Builder;

import java.io.Serializable;

public class MiniSeriesDTO implements Serializable {

    private String progress;
    private Integer target;
    private Integer wins;
    private Integer losses;

    @Builder
    public MiniSeriesDTO(String progress, Integer target, Integer wins, Integer losses) {
        this.progress = progress;
        this.target = target;
        this.wins = wins;
        this.losses = losses;
    }

    public MiniSeries toEntity() {
        return MiniSeries.builder()
                .progress(progress)
                .target(target)
                .wins(wins)
                .losses(losses)
                .build();
    }
}
