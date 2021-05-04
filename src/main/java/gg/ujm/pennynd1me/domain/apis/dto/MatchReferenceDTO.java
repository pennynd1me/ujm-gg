package gg.ujm.pennynd1me.domain.apis.dto;

import gg.ujm.pennynd1me.domain.apis.match.MatchReference;
import gg.ujm.pennynd1me.domain.apis.summoner.Summoner;

import java.io.Serializable;

public class MatchReferenceDTO implements Serializable {

    private Long gameId;
    private String accountId;
    private Integer champion;
    private String platformId;
    private Integer queue;
    private Integer season;
    private Long timestamp;
    private String role;
    private String lane;

    public MatchReferenceDTO(String accountId) {
        this.accountId = accountId;
    }

//    public MatchReference toEntity() {
//        return MatchReference.builder()
//
//                .build()
//    }
}
