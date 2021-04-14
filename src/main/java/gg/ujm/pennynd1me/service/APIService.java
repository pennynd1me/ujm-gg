package gg.ujm.pennynd1me.service;

import gg.ujm.pennynd1me.domain.apis.Apis;
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
            body = new SummonerDTO();
        }
        return body;
    }
}
