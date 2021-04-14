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
    public String save(SummonerDTO summonerDTO) {
        return summonerRepository.save(summonerDTO.toEntity()).getAccountId();
    }

    @Transactional
    public String update(String accountId, SummonerUpdateDTO summonerUpdateDto) {
        Summoner summoner = summonerRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("해당 소환사가 없습니다. id" + accountId));

        summoner.update(summonerUpdateDto.getProfileIconId(), summonerUpdateDto.getRevisionDate(), summonerUpdateDto.getName(), summonerUpdateDto.getId(), summonerUpdateDto.getPuuid(), summonerUpdateDto.getSummonerLevel());
        return accountId;
    }

    public String findByNameToGetAccountId(String name) {
        Summoner summoner = summonerRepository.findByName(name)
                // DB에서 이름으로 찾지 못하면, riot api에서 이름으로 검색해서 getAccountId()
                .orElseGet(() -> apiService.summonerByName(name).toEntity());

        return summoner.getAccountId();
    }

    @Transactional
    public SummonerResponseDTO findByName(String name) {
        Summoner entity = summonerRepository.findByName(name)
                // DB에서 이름으로 찾지 못하면, riot api에서 이름으로 검색하고 db에 저장한다.
                .orElseGet(() -> apiService.summonerByName(name).toEntity());
        if (entity.getName() != null) {
            summonerRepository.save(entity);
        }
        return new SummonerResponseDTO(entity);
    }
}
