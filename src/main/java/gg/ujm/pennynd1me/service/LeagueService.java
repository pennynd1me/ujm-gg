package gg.ujm.pennynd1me.service;

import gg.ujm.pennynd1me.domain.apis.dto.LeagueEntryDTO;
import gg.ujm.pennynd1me.domain.apis.dto.LeagueEntryResponseDTO;
import gg.ujm.pennynd1me.domain.apis.league.LeagueEntry;
import gg.ujm.pennynd1me.domain.apis.league.LeagueEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LeagueService {

    private final APIService apiService;

    private final LeagueEntryRepository repository;

    public LeagueEntryResponseDTO entriesBySummonerId(String summonerId) {
        LeagueEntry leagueEntry = repository.findById(summonerId)
                .orElseGet(() -> apiService.leagueBySummonerId(summonerId).toEntity());
        if (!leagueEntry.getLeagueId().equals("invalid")) {
            repository.save(leagueEntry);
        }
        return new LeagueEntryResponseDTO(leagueEntry);
    }
}
