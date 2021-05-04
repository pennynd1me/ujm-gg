package gg.ujm.pennynd1me.service;

import gg.ujm.pennynd1me.domain.apis.dto.SummonerDTO;
import gg.ujm.pennynd1me.domain.apis.dto.SummonerResponseDTO;
import gg.ujm.pennynd1me.domain.apis.dto.SummonerUpdateDTO;
import gg.ujm.pennynd1me.domain.apis.summoner.Summoner;
import gg.ujm.pennynd1me.domain.apis.summoner.SummonerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SummonerService {

    private final SummonerRepository repository;

    private final APIService apiService;

    @Transactional
    public SummonerResponseDTO findByNameAndSaveIfNotExist(String name) {
        Summoner summoner = repository.findTopByNameIgnoreCaseOrderByModifiedDateDesc(name.replaceAll("[\\+]+", ""))
                // DB에서 이름으로 찾지 못하면, riot api 요청
                .orElseGet(() -> apiService.summonerByName(name).toEntity());
        if (!summoner.getAccountId().equals("invalid")) {
            repository.save(summoner);
        }

        return new SummonerResponseDTO(summoner);
    }

    public String findByNameToGetAccountId(String name) {
        return repository.findByNameIgnoreCaseToGetAccountId(name.replaceAll("[\\+]", ""))
                .orElseGet(() -> apiService.summonerByName(name).toEntity().getAccountId());
    }

    @Transactional
    public String save(SummonerDTO summonerDTO) {
        return repository.save(summonerDTO.toEntity()).getAccountId();
    }

    @Transactional
    public String update(String accountId, SummonerUpdateDTO updateDTO) {
        Summoner summoner = repository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("해당 accountId가 없습니다. id =" + accountId));
        summoner.update(updateDTO.getProfileIconId(), updateDTO.getRevisionDate(), updateDTO.getName(), updateDTO.getId(), updateDTO.getSummonerLevel());
        return accountId;
    }
}
