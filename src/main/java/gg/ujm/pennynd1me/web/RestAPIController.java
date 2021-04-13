package gg.ujm.pennynd1me.web;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import gg.ujm.pennynd1me.domain.apis.Apis;
import gg.ujm.pennynd1me.domain.apis.dto.LeagueDTO;
import gg.ujm.pennynd1me.domain.apis.dto.SummonerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RestAPIController {

    private final Environment environment;

    private final RestTemplate restTemplate;

    private final HttpHeaders httpHeaders;

    @GetMapping("/api/summoner/{summonerName}")
    public SummonerDTO summoner(@PathVariable String summonerName) {
        SummonerDTO body;
        String url = environment.getProperty("riot.api.url") + Apis.Summoner.getBasePath() + Apis.Summoner.getList().get(1) + summonerName;
        try {
            body = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), SummonerDTO.class).getBody();
        } catch (final HttpClientErrorException e) {
            return new SummonerDTO();
        }
        return body;
    }

    @GetMapping("/api/league/{encryptedSummonerId}")
    public LeagueDTO league(@PathVariable String encryptedSummonerId) throws MismatchedInputException {
        LeagueDTO body;
        String url = environment.getProperty("riot.api.url") + Apis.League.getBasePath() + Apis.League.getList().get(0) + encryptedSummonerId;
        try {
            body = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), LeagueDTO.class).getBody();
            if (body.getMiniSeries() != null) {
                System.out.println("미니시리즈 있어");
                return body;
            }
            System.out.println("미니시리즈 없어");
            return LeagueDTO.builder()
                    .leagueId(body.getLeagueId())
                    .summonerId(body.getSummonerId())
                    .summonerName(body.getSummonerName())
                    .queueType(body.getQueueType())
                    .tier(body.getTier())
                    .rank(body.getRank())
                    .leaguePoints(body.getLeaguePoints())
                    .wins(body.getWins())
                    .losses(body.getLosses())
                    .hotStreak(body.isHotStreak())
                    .veteran(body.isVeteran())
                    .freshBlood(body.isFreshBlood())
                    .inactive(body.isInactive())
                    .build();
        } catch (final HttpClientErrorException e) {
            return new LeagueDTO();
        }
    }
}
