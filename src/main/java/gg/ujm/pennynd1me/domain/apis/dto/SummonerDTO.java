package gg.ujm.pennynd1me.domain.apis.dto;

import gg.ujm.pennynd1me.domain.apis.summoner.Summoner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class SummonerDTO implements Serializable {

    private String accountId;
    private int profileIconId;
    private long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private long summonerLevel;

    @Builder
    public SummonerDTO(String accountId, int profileIconId, long revisionDate, String name, String id, String puuid, long summonerLevel) {
        this.accountId = accountId;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.name = name;
        this.id = id;
        this.puuid = puuid;
        this.summonerLevel = summonerLevel;
    }
    // api 호출시 DB에 없을 때: accountId에 "invalid" 담아서 생성
    public SummonerDTO(String accountId) {
        this.accountId = accountId;
    }

    public Summoner toEntity() {
        return Summoner.builder()
                .accountId(accountId)
                .profileIconId(profileIconId)
                .revisionDate(revisionDate)
                .name(name)
                .id(id)
                .puuid(puuid)
                .summonerLevel(summonerLevel)
                .build();
    }
}
