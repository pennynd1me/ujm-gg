package gg.ujm.pennynd1me.service;

import gg.ujm.pennynd1me.domain.apis.dto.SummonerDTO;
import gg.ujm.pennynd1me.domain.apis.summoner.SummonerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SummonerApi {

    private final SummonerRepository summonerRepository;

    public void refresh() {
    }
}
