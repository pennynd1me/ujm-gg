package gg.ujm.pennynd1me.domain.apis;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApisTest {

    @Test
    public void basePath_불러오기() {
        //given
        String basePath = "/lol/summoner/v4/summoners";
        //when
        //then
        Assertions.assertThat(Apis.Summoner.getBasePath()).isEqualTo(basePath);
    }

    @Test
    public void API_선택하기() {
        //given
        String api = "/by-account/";
        //when
        //then
        Assertions.assertThat(Apis.Summoner.getList().get(0)).isEqualTo(api);
    }

}