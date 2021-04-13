package gg.ujm.pennynd1me.web;

import gg.ujm.pennynd1me.domain.apis.dto.SummonerDTO;
import gg.ujm.pennynd1me.domain.apis.summoner.Summoner;
import gg.ujm.pennynd1me.service.SummonerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class SummonerController {

    private final SummonerApi summonerApi;

    @PostMapping("/api/summoner/{summonerName}/refresh")
    public String refresh(@PathVariable String summonerName, @RequestBody SummonerDTO summoner) {
        summonerApi.refresh();
        return "#";
    }
}
