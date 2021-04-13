package gg.ujm.pennynd1me.domain.apis.league;

import gg.ujm.pennynd1me.domain.apis.BaseTimeEntity;
import gg.ujm.pennynd1me.domain.apis.dto.LeagueDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class League extends BaseTimeEntity {

    private String leagueId;
    @Id
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

    @ElementCollection
    private List<LeagueDTO.MiniSeriesDTO> miniSeriesDTO = new ArrayList<>();

    @Builder
    public League(String leagueId, String summonerId, String summonerName, String queueType, String tier, String rank, int leaguePoints, int wins, int losses, boolean hotStreak, boolean veteran, boolean freshBlood, boolean inactive, List<LeagueDTO.MiniSeriesDTO> miniSeriesDTO) {
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
        this.miniSeriesDTO = miniSeriesDTO;
    }
}
