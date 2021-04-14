package gg.ujm.pennynd1me.web;

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

    @GetMapping("/summoner/{summonerName}")
    public String summoner(Model model, @PathVariable String summonerName) {
        model.addAttribute("summoner", summonerService.findByName(summonerName));
        return "summoner";
    }

    @PostMapping("/summoner/{summonerName}")
    public String summonerPost(Model model, @PathVariable String summonerName) {

        return "summoner";
    }
}
