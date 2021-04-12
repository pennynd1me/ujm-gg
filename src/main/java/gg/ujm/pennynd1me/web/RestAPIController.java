package gg.ujm.pennynd1me.web;

import gg.ujm.pennynd1me.domain.apis.Apis;
import gg.ujm.pennynd1me.domain.apis.dto.SummonerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class RestAPIController {

    private final Environment environment;

    private final RestTemplate restTemplate;

    @GetMapping("/")
    public SummonerDTO index(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36");
        httpHeaders.add("X-Riot-Token", environment.getProperty("riot.api.token"));
        String url = environment.getProperty("riot.api.url") + Apis.Summoner.getBasePath() + Apis.Summoner.getList().get(1) + "뚜빠뚜빠";
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), SummonerDTO.class).getBody();
    }
}
