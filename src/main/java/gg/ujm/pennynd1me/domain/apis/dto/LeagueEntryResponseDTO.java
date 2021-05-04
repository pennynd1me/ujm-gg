package gg.ujm.pennynd1me.domain.apis.dto;

import gg.ujm.pennynd1me.domain.apis.league.LeagueEntry;
import gg.ujm.pennynd1me.domain.apis.league.MiniSeries;
import lombok.Getter;

@Getter
public class LeagueEntryResponseDTO {

    private String leagueId;
    private String summonerId;
    private String summonerName;
    private String queueType;
    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean veteran;
    private boolean freshBlood;
    private boolean inactive;

    private MiniSeries miniSeries;

    public LeagueEntryResponseDTO(LeagueEntry entity) {
        this.leagueId = entity.getLeagueId();
        this.summonerId = entity.getSummonerId().getId();
        this.summonerName = entity.getSummonerName();
        this.queueType = entity.getQueueType();
        this.tier = entity.getTier();
        this.rank = entity.getRank();
        this.leaguePoints = entity.getLeaguePoints();
        this.wins = entity.getWins();
        this.losses = entity.getLosses();
        this.hotStreak = entity.getHotStreak();
        this.veteran = entity.getVeteran();
        this.freshBlood = entity.getFreshBlood();
        this.inactive = entity.getInactive();
        this.miniSeries = entity.getMiniSeries();
    }
}
