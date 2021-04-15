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

    private final SummonerRepository summonerRepository;

    private final APIService apiService;

    @Transactional
    public SummonerResponseDTO findByName(String name) {
        Summoner summoner = summonerRepository.findTopByNameIgnoreCaseOrderByModifiedDateDesc(name.replaceAll("[\\+]+", " "))
                // DB에서 이름으로 찾지 못하면, riot api 요청
                .orElseGet(() -> apiService.summonerByName(name).toEntity());
        if (!summoner.getAccountId().equals("invalid")) {
            summonerRepository.save(summoner);
        }

        return new SummonerResponseDTO(summoner);
    }

    @Transactional
    public String save(SummonerDTO summonerDTO) {
        return summonerRepository.save(summonerDTO.toEntity()).getAccountId();
    }

    @Transactional
    public String update(String accountId, String name, SummonerUpdateDTO summonerUpdateDTO) {
        Summoner summoner = summonerRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("해당 소환사가 없습니다. no=" + accountId));

//        summoner.update();
        return accountId;
    }
}
