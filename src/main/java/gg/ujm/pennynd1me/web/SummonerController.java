package gg.ujm.pennynd1me.web;

import gg.ujm.pennynd1me.domain.apis.dto.SummonerResponseDTO;
import gg.ujm.pennynd1me.service.LeagueService;
import gg.ujm.pennynd1me.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class SummonerController {

    private final SummonerService summonerService;

    private final LeagueService leagueService;

    @GetMapping("/summoner/{summonerName}")
    public String summoner(Model model, @PathVariable String summonerName) {
        summonerName = summonerName.replaceAll("%20", "+");
        SummonerResponseDTO summoner = summonerService.findByNameAndSaveIfNotExist(summonerName);
        model.addAttribute("summoner", summoner);
        model.addAttribute("league", leagueService.entriesBySummonerId(summoner.getId()));
        return "summoner";
    }

    @PostMapping("/summoner/{summonerName}")
    public String summonerPost(Model model, @PathVariable String summonerName) {
//        model.addAttribute("match", "무야호");
        return "summoner";
    }
}
