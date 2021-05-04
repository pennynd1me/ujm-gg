package gg.ujm.pennynd1me.domain.apis.league;

import gg.ujm.pennynd1me.domain.apis.summoner.Summoner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Embeddable
public class MiniSeries implements Serializable {
    @OneToOne
    @JoinColumn(name = "summoner_id", referencedColumnName = "summoner_id")
    private LeagueEntry summonerId;
    @Column(name="miniseries_progress")
    private String progress;
    @Column(name="miniseries_target")
    private Integer target;
    @Column(name="miniseries_wins")
    private Integer wins;
    @Column(name="miniseries_losses")
    private Integer losses;

    @Builder
    public MiniSeries(String progress, Integer target, Integer wins, Integer losses) {
        this.progress = progress;
        this.target = target;
        this.wins = wins;
        this.losses = losses;
    }
}


