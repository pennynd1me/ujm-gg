package gg.ujm.pennynd1me.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RiotConfigTest {

    @Autowired
    RiotConfig riotConfig;

    @Autowired
    Environment environment;

    @Test
    public void 프로퍼티_파일_읽기() {
        //given
        String url = "https://kr.api.riotgames.com/";
        //when
        String configUrl = riotConfig.getUrl();
        //then
        Assertions.assertThat(configUrl).isEqualTo(url);
    }

    @Test
    public void 토큰값_읽어오기() {
        //given
        String configToken = environment.getProperty("riot.api.token");
        //when
        String token = riotConfig.getToken();
        //then
        Assertions.assertThat(token).isEqualTo(configToken);
    }

}
