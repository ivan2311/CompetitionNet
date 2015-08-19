package net.competition.dal;

import net.competition.domain.Competition;
import net.competition.domain.Competitor;
import net.competition.domain.Match;

import java.util.List;

/**
 * Created by Korisnik on 7/23/2015.
 */
public interface DAO {

    void addCompetition(Competition competition);

    void addCompetitor(Competitor competitor);

    void addMatchToCompetition(Competition competition, Match match);

    void addCompetitorToCompetition(Competition competition, Competitor competitor);


    List<Competition> getAllCompetitions();

    List<Competitor> getAllCompetitorsFromCompetition(Competition competition);

    List<Match> getAllMatchesFromCompetition(Competition competition);


    void updateCompetition(Competition competition);

    void updateCompetitor(Competitor competitor);

    void updateMatch(Match match);


    void deleteCompetition(Competition competition);

    void deleteCompetitor(Competitor competitor);

    void deleteMatch(Match match);
}
