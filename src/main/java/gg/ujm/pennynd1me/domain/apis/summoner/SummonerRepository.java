package gg.ujm.pennynd1me.domain.apis.summoner;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SummonerRepository extends JpaRepository<Summoner, String> {

    Optional<Summoner> findByName(String name);
}
