package gg.ujm.pennynd1me.config;

import gg.ujm.pennynd1me.domain.apis.Apis;
import gg.ujm.pennynd1me.domain.apis.dto.SummonerDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@SpringJUnitConfig(HttpClientConfig.class)
public class HttpClientConfigTest {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Environment environment;

    @Test
    public void Http_헤더추가() {
        //given
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36");
        httpHeaders.add("X-Riot-Token", environment.getProperty("riot.api.token"));

        String url = environment.getProperty("riot.api.url") + Apis.Summoner.getBasePath() + Apis.Summoner.getList().get(1) + "뚜빠뚜빠";
        //when
        //then
        Assertions.assertThat(restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), SummonerDTO.class).getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
