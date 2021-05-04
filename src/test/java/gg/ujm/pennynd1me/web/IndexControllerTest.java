package gg.ujm.pennynd1me.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void 메인페이지_로딩() {
        //given

        //when
        String body = this.testRestTemplate.getForObject("/", String.class);
        //then
        Assertions.assertThat(body).contains("UJM.GG");
    }

    @Test
    public void 소환사_검색() {
        //given
        String name = "hide on bush";
        //when
        String body = testRestTemplate.getForObject("/summoner/" + name, String.class);
        //then
        Assertions.assertThat(body).containsIgnoringCase(name);
    }
}
