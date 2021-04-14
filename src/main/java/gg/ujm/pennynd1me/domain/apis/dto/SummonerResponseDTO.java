package gg.ujm.pennynd1me.domain.apis.dto;

import gg.ujm.pennynd1me.domain.apis.summoner.Summoner;
import lombok.Getter;

@Getter
public class SummonerResponseDTO {

    private String accountId;
    private int profileIconId;
    private long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private long summonerLevel;

    public SummonerResponseDTO(Summoner entity) {
        this.accountId = entity.getAccountId();
        this.profileIconId = entity.getProfileIconId();
        this.revisionDate = entity.getRevisionDate();
        this.name = entity.getName();
        this.id = entity.getId();
        this.puuid = entity.getPuuid();
        this.summonerLevel = entity.getSummonerLevel();
    }
}
