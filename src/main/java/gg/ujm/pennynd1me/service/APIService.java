package gg.ujm.pennynd1me.service;

import gg.ujm.pennynd1me.domain.apis.Apis;
import gg.ujm.pennynd1me.domain.apis.dto.LeagueEntryDTO;
import gg.ujm.pennynd1me.domain.apis.dto.MatchReferenceDTO;
import gg.ujm.pennynd1me.domain.apis.dto.SummonerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class APIService {

    private final Environment environment;

    private final RestTemplate restTemplate;

    private final HttpHeaders httpHeaders;

    public SummonerDTO summonerByName(String summonerName) {
        String url = environment.getProperty("riot.api.url") + Apis.Summoner.getBasePath() + Apis.Summoner.getList().get(1) + summonerName;
        SummonerDTO body;
        try {
            body = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), SummonerDTO.class).getBody();
        } catch (final HttpClientErrorException e) {
            body = new SummonerDTO("invalid");
        }
        return body;
    }

    public LeagueEntryDTO leagueBySummonerId(String summonerId) {
        String url = environment.getProperty("riot.api.url") + Apis.League.getBasePath() + Apis.League.getList().get(0) + summonerId;
        LeagueEntryDTO body;
        try {
            body = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), LeagueEntryDTO.class).getBody();
        } catch (final HttpClientErrorException e) {
            body = new LeagueEntryDTO("invalid");
        }
        return body;
    }

    public MatchReferenceDTO matchListsByAccountId(String accountId) {
        String url = environment.getProperty("riot.api.url") + Apis.Match.getBasePath() + Apis.Match.getList().get(1) + accountId;
        MatchReferenceDTO body;
        try {
            body = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), MatchReferenceDTO.class).getBody();
        } catch (final HttpClientErrorException e) {
            body = new MatchReferenceDTO("invalid");
        }
        return body;
    }
}
