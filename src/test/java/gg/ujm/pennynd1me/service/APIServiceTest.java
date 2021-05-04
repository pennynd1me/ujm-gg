package gg.ujm.pennynd1me.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class APIServiceTest {

    @Autowired
    private APIService apiService;

    @Test
    public void Summoner_API호출() {
        //given
        String name = "hide on bush";
        //when
        String nameInDb = apiService.summonerByName(name).getName();
        //then
        Assertions.assertThat(nameInDb).isEqualToIgnoringCase(name);
    }
}