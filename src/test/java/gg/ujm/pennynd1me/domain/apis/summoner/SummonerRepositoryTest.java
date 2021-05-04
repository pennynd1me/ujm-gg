package gg.ujm.pennynd1me.domain.apis.summoner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SummonerRepositoryTest {

    @Autowired
    SummonerRepository summonerRepository;

    @Test
    public void 소환사_저장_불러오기() {
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
        Assertions.assertThat(summoners.getId()).isEqualTo(id);
        Assertions.assertThat(summoners.getAccountId()).isEqualTo(accountId);
        Assertions.assertThat(summoners.getName()).isEqualTo(name);
        Assertions.assertThat(summoners.getProfileIconId()).isEqualTo(profileIconId);
        Assertions.assertThat(summoners.getPuuid()).isEqualTo(puuid);
        Assertions.assertThat(summoners.getRevisionDate()).isEqualTo(revisionDate);
        Assertions.assertThat(summoners.getSummonerLevel()).isEqualTo(summonerLevel);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        summonerRepository.save(Summoner.builder()
                .id("asd")
                .accountId("asd")
                .name("asd")
                .profileIconId(123)
                .puuid("asd")
                .revisionDate(123)
                .summonerLevel(123)
                .build());
        //when
        List<Summoner> summonerList = summonerRepository.findAll();

        //then
        Summoner summoner = summonerList.get(0);

        System.out.println(">>>>>>>>>>>>>>> createDate=" + summoner.getCreatedDate() + ", modifiedDate=" + summoner.getModifiedDate());

        Assertions.assertThat(summoner.getCreatedDate()).isAfter(now);
        Assertions.assertThat(summoner.getModifiedDate()).isAfter(now);
    }

    @Test
    public void 띄어쓰기_IgnoreCase_조회() {
        //given
        String accountId = "asdasd";
        int profileIconId = 564;
        long revisionDate = 292929L;
        String name = "Hide on bush";
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
        name = "hIde oN buSh";
        String finalName = name;
        Summoner summoner1 = summonerRepository.findTopByNameIgnoreCaseOrderByModifiedDateDesc(name)
                .orElseThrow(() -> new IllegalArgumentException("안돼"));
        //then
        Assertions.assertThat(summoner1.getName()).isEqualToIgnoringCase(name);
    }

    @Test
    public void 닉네임으로_accountId조회() {
        //given
        String accountId = "fakeraccountId";
        int profileIconId = 564;
        long revisionDate = 292929L;
        String name = "Hide on bush";
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
        name = "hIdeOnBUS h";
        String finalName = name;
        String result = summonerRepository.findByNameIgnoreCaseToGetAccountId(name)
                .orElseThrow(() -> new IllegalArgumentException("안돼"));
        //then
        Assertions.assertThat(result).isEqualToIgnoringCase(accountId);
    }
}
