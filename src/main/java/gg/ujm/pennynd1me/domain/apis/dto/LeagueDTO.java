package gg.ujm.pennynd1me.domain.apis.dto;

import gg.ujm.pennynd1me.domain.apis.league.League;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class LeagueDTO implements Serializable {

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

    private List<MiniSeriesDTO> miniSeries;

    @Getter
    @NoArgsConstructor
    public class MiniSeriesDTO implements Serializable {

        private int losses;
        private String progress;
        private int target;
        private int wins;

        public MiniSeriesDTO(int losses, String progress, int target, int wins) {
            this.losses = losses;
            this.progress = progress;
            this.target = target;
            this.wins = wins;
        }
    }

    @Builder
    public LeagueDTO(String leagueId, String summonerId, String summonerName, String queueType, String tier, String rank, int leaguePoints, int wins, int losses, boolean hotStreak, boolean veteran, boolean freshBlood, boolean inactive, List<MiniSeriesDTO> miniSeries) {
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

    public League toEntity() {
        return League.builder()
                .leagueId(leagueId)
                .summonerId(summonerId)
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
                .build();

    }
}
