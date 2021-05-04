package gg.ujm.pennynd1me.service;

import gg.ujm.pennynd1me.domain.apis.dto.LeagueEntryResponseDTO;
import gg.ujm.pennynd1me.domain.apis.league.LeagueEntryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(MockitoExtension.class)
public class LeagueServiceTest {

    @InjectMocks
    private LeagueService leagueService;

    @Mock
    private LeagueEntryRepository repository;

//    @Test
    public void SummonerId로_entries() {
        //given
        String summonerId = "5H4ZJg3RV_rKs3jzquhtPIjUVv2Ul0eLyALnIgBMtFTohg";
        //when
        LeagueEntryResponseDTO leagueEntryResponseDTO = leagueService.entriesBySummonerId(summonerId);
        //then
        Assertions.assertThat(leagueEntryResponseDTO.getSummonerId()).isEqualTo(summonerId);
    }
}
