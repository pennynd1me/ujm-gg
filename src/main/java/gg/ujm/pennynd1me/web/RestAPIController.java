package gg.ujm.pennynd1me.web;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import gg.ujm.pennynd1me.domain.apis.dto.LeagueDTO;
import gg.ujm.pennynd1me.domain.apis.dto.SummonerResponseDTO;
import gg.ujm.pennynd1me.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestAPIController {

    private final SummonerService summonerService;

    @GetMapping("/api/summoner/{summonerName}")
    public SummonerResponseDTO summoner(@PathVariable String summonerName) {
        return summonerService.findByName(summonerName);
    }

    @GetMapping("/api/league/{encryptedSummonerId}")
    public LeagueDTO league(@PathVariable String encryptedSummonerId) {
        return new LeagueDTO();
    }
}
