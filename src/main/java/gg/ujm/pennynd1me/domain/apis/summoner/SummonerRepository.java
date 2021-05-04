package gg.ujm.pennynd1me.domain.apis.summoner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SummonerRepository extends JpaRepository<Summoner, String> {

    @Query(value = "SELECT * FROM summoner WHERE upper(replace(name, ' ', '')) = upper(replace(:name, ' ', '')) ORDER BY modified_date DESC", nativeQuery = true)
    Optional<Summoner> findTopByNameIgnoreCaseOrderByModifiedDateDesc(@Param ("name") String name);

    @Query(value = "SELECT account_id FROM summoner where upper(replace(name, ' ', '')) = upper(replace(:name, ' ', '')) ORDER BY modified_date DESC", nativeQuery = true)
    Optional<String> findByNameIgnoreCaseToGetAccountId(@Param("name") String name);

}
