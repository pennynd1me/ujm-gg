package gg.ujm.pennynd1me.domain.apis;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum Apis {
    Summoner("/lol/summoner/v4/summoners", Arrays.asList("/by-account/", "/by-name/", "/by-puuid/", "/")),
    League("/lol/league/v4", Arrays.asList("/entries/by-summoner/", "/leagues/", "/entries/")),
    ChampionMastery("/lol/champion-mastery/v4", Arrays.asList("/champion-masteries/by-summoner/", "/champion-masteries/by-summoner/{encryptedSummonerId}/by-champion/", "/scores/by-summoner/")),
    Match("/lol/match/v4", Arrays.asList("/matches/", "/matchlists/by-account/", "/timelines/by-match"));

    private final String basePath;
    private final List<String> list;
}
