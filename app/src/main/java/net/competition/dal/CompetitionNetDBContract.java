package net.competition.dal;

import android.provider.BaseColumns;

/**
 * Created by Korisnik on 7/23/2015.
 */
public final class CompetitionNetDBContract {

    public CompetitionNetDBContract() {
    }

    public static abstract class Competition implements BaseColumns {
        public static final String TABLE_NAME = "competition";
        public static final String COLUMN_NAME_NAME = "name";
    }

    public static abstract class Competitor implements  BaseColumns {
        public static final String TABLE_NAME = "competitor";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_IMAGE = "image";
    }

    public static abstract class Match implements BaseColumns {
        public static final String TABLE_NAME = "match";
        public static final String COLUMN_NAME_COMPETITION_ID = "competitionid";
        public static final String COLUMN_NAME_HOME_ID = "homeid";
        public static final String COLUMN_NAME_AWAY_ID = "awayid";
        public static final String COLUMN_NAME_DATETIME = "datetime";
    }

    public static abstract class Result implements BaseColumns {
        public static final String TABLE_NAME = "result";
        public static final String COLUMN_NAME_MATCH_ID = "matchid";
        public static final String COLUMN_NAME_WINNER_HOME = "winnerhome";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }

    public static abstract class CompetitionCompetitor implements BaseColumns {
        public static final String TABLE_NAME = "competitioncompetitor";
        public static final String COLUMN_NAME_COMPETITION_ID = "competitionid";
        public static final String COLUMN_NAME_COMPETITOR_ID = "competitorid";
    }
}
