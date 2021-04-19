package gg.ujm.pennynd1me.domain.apis.league;

import gg.ujm.pennynd1me.domain.apis.BaseTimeEntity;
import gg.ujm.pennynd1me.domain.apis.summoner.Summoner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class LeagueEntry extends BaseTimeEntity {
    @Id
    private String leagueId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "summoner_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Summoner summonerId;
    private String summonerName;
    private String queueType;
    private String tier;
    private String rank;
    private Integer leaguePoints;
    private Integer wins;
    private Integer losses;
    private Boolean hotStreak;
    private Boolean veteran;
    private Boolean freshBlood;
    private Boolean inactive;

    @Embedded
    private MiniSeries miniSeries;

    @Builder
    public LeagueEntry(String leagueId, Summoner summoner, String summonerName, String queueType, String tier, String rank, Integer leaguePoints, Integer wins, Integer losses, Boolean hotStreak, Boolean veteran, Boolean freshBlood, Boolean inactive, MiniSeries miniSeries) {
        this.leagueId = leagueId;
        this.summonerId = summoner;
        this.summonerName = summonerName;
        this.queueType = queueType;
        this.tier = tier;
        this.rank = rank;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        this.hotStreak = hotStreak;
        this.veteran = veteran;
        this.freshBlood = freshBlood;
        this.inactive = inactive;
        this.miniSeries = miniSeries;
    }
}
