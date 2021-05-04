package gg.ujm.pennynd1me.domain.apis.dto;

import gg.ujm.pennynd1me.domain.apis.summoner.Summoner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SummonerUpdateDTO {

    private int profileIconId;
    private long revisionDate;
    private String name;
    private String id;
    private long summonerLevel;

    @Builder
    public SummonerUpdateDTO(int profileIconId, long revisionDate, String name, String id, long summonerLevel) {
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.name = name;
        this.id = id;
        this.summonerLevel = summonerLevel;
    }

    public Summoner toEntity() {
        return Summoner.builder()
                .profileIconId(profileIconId)
                .revisionDate(revisionDate)
                .name(name)
                .id(id)
                .summonerLevel(summonerLevel)
                .build();

    }
}
