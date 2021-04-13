package gg.ujm.pennynd1me.domain.apis.summoner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SummonerRepositoryTest {

    @Autowired
    SummonerRepository summonerRepository;

    @AfterEach
    public void cleanup() {
        summonerRepository.deleteAll();
    }

    @Test
    public void 소환사_불러오기() {
        //given
        String accountId = "asdasd";
        int profileIconId = 564;
        long revisionDate = 292929L;
        String name = "asdasd";
        String id = "asdasd";
        String puuid = "asdasd";
        long summonerLevel = 123;
        summonerRepository.save(Summoner.builder()
                .id(id)
                .accountId(accountId)
                .name(name)
                .profileIconId(profileIconId)
                .puuid(puuid)
                .revisionDate(revisionDate)
                .summonerLevel(summonerLevel)
                .build());
        //when
        List<Summoner> summonerList = summonerRepository.findAll();
        //then
        Summoner summoners = summonerList.get(0);
        Assertions.assertThat(summoners.getSummonerLevel()).isEqualTo(summonerLevel);
        Assertions.assertThat(summoners.getAccountId()).isEqualTo(accountId);
    }
}
