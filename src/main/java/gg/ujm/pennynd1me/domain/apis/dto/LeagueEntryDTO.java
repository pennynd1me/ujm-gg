package gg.ujm.pennynd1me.domain.apis.dto;

import gg.ujm.pennynd1me.domain.apis.league.LeagueEntry;
import gg.ujm.pennynd1me.domain.apis.league.MiniSeries;
import gg.ujm.pennynd1me.domain.apis.summoner.Summoner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@NoArgsConstructor
public class LeagueEntryDTO implements Serializable {

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

    @Builder
    public LeagueEntryDTO(String leagueId, String summonerId, String summonerName, String queueType, String tier, String rank, int leaguePoints, int wins, int losses, boolean hotStreak, boolean veteran, boolean freshBlood, boolean inactive, MiniSeries miniSeries) {
        this.leagueId = leagueId;
        this.summonerId = summonerId;
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

    // api 호출시 DB에 없을 때: leagueId에 "invalid" 담아서 생성
    public LeagueEntryDTO(String leagueId) {
        this.leagueId = leagueId;
    }

    public LeagueEntry toEntity() {
        return LeagueEntry.builder()
                .leagueId(leagueId)
//                .summoner(summonerId)
                .summonerName(summonerName)
                .queueType(queueType)
                .tier(tier)
                .rank(rank)
                .leaguePoints(leaguePoints)
                .wins(wins)
                .losses(losses)
                .hotStreak(hotStreak)
                .veteran(veteran)
                .freshBlood(freshBlood)
                .inactive(inactive)
                .miniSeries(miniSeries)
                .build();
    }

}
