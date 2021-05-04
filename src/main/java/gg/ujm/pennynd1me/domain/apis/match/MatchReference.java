package gg.ujm.pennynd1me.domain.apis.match;

import gg.ujm.pennynd1me.domain.apis.summoner.Summoner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MatchReference {

    @Id
    private Long gameId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Summoner accountId;
    private Integer champion;
    private String platformId;
    private Integer queue;
    private Integer season;
    private Long timestamp;
    private String role;
    private String lane;

    @Builder
    public MatchReference(Long gameId, Summoner accountId, Integer champion, String platformId, Integer queue, Integer season, Long timestamp, String role, String lane) {
        this.gameId = gameId;
        this.accountId = accountId;
        this.champion = champion;
        this.platformId = platformId;
        this.queue = queue;
        this.season = season;
        this.timestamp = timestamp;
        this.role = role;
        this.lane = lane;
    }
}

