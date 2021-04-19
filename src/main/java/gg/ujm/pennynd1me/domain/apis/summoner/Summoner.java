package gg.ujm.pennynd1me.domain.apis.summoner;

import gg.ujm.pennynd1me.domain.apis.BaseTimeEntity;
import gg.ujm.pennynd1me.domain.apis.league.LeagueEntry;
import gg.ujm.pennynd1me.domain.apis.match.MatchReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class Summoner extends BaseTimeEntity {

    @Id
    private String accountId;
    private String puuid;
    private Integer profileIconId;
    private Long revisionDate;
    private String name;
    private String id;
    private Long summonerLevel;

    @Builder
    public Summoner(String accountId, int profileIconId, long revisionDate, String name, String id, String puuid, long summonerLevel) {
        this.accountId = accountId;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.name = name;
        this.id = id;
        this.puuid = puuid;
        this.summonerLevel = summonerLevel;
    }
    // 소환사명 변경, 레벨 업, 프로필 사진 변경 등
    public Summoner update(int profileIconId, long revisionDate, String name, String id, long summonerLevel) {
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.name = name;
        this.id = id;
        this.summonerLevel = summonerLevel;
        return this;
    }

}
