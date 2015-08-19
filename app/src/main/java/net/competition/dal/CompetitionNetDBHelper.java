package net.competition.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Korisnik on 7/23/2015.
 */
public class CompetitionNetDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "competitionnet.db";
    public static final int DATABASE_VERSION = 2;

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String DATETIME_TYPE = " DATETIME";
    private static final String BLOB_TYPE = " BLOB";
    private static final String PK = " PRIMARY KEY";
    private static final String AUTOINCREMENT = " AUTOINCREMENT";
    private static final String COMMA = ", ";

    private static final String[] SQL_CREATE_ENTRIES =
            { "CREATE TABLE " + CompetitionNetDBContract.Competitor.TABLE_NAME + " (" +
                    CompetitionNetDBContract.Competitor._ID + INTEGER_TYPE + PK + AUTOINCREMENT + COMMA +
                    CompetitionNetDBContract.Competitor.COLUMN_NAME_NAME + TEXT_TYPE + COMMA +
                    CompetitionNetDBContract.Competitor.COLUMN_NAME_IMAGE + BLOB_TYPE +
                    " ); ",
            "CREATE TABLE " + CompetitionNetDBContract.Competition.TABLE_NAME + " (" +
                    CompetitionNetDBContract.Competition._ID + INTEGER_TYPE + PK + AUTOINCREMENT + COMMA +
                    CompetitionNetDBContract.Competition.COLUMN_NAME_NAME + TEXT_TYPE +
            " ); ",

            "CREATE TABLE " + CompetitionNetDBContract.Match.TABLE_NAME + " (" +
                    CompetitionNetDBContract.Match._ID + INTEGER_TYPE + PK + AUTOINCREMENT + COMMA +
                    CompetitionNetDBContract.Match.COLUMN_NAME_COMPETITION_ID + INTEGER_TYPE + COMMA +
                    CompetitionNetDBContract.Match.COLUMN_NAME_HOME_ID + INTEGER_TYPE + COMMA +
                    CompetitionNetDBContract.Match.COLUMN_NAME_AWAY_ID + INTEGER_TYPE + COMMA +
                    "FOREIGN KEY(" + CompetitionNetDBContract.Match.COLUMN_NAME_COMPETITION_ID +
                    ") REFERENCES " + CompetitionNetDBContract.Competition.TABLE_NAME + "(" + CompetitionNetDBContract.Competition._ID + ")" + COMMA +
                    "FOREIGN KEY(" + CompetitionNetDBContract.Match.COLUMN_NAME_HOME_ID +
                    ") REFERENCES " + CompetitionNetDBContract.Competitor.TABLE_NAME + "(" + CompetitionNetDBContract.Competitor._ID + ")" + COMMA +
                    "FOREIGN KEY(" + CompetitionNetDBContract.Match.COLUMN_NAME_AWAY_ID +
                    ") REFERENCES " + CompetitionNetDBContract.Competitor.TABLE_NAME + "(" + CompetitionNetDBContract.Competitor._ID + ")" +
                    //        CompetitionNetDBContract.Match.COLUMN_NAME_DATETIME + DATETIME_TYPE + COMMA +
            " ); ",
            "CREATE TABLE " + CompetitionNetDBContract.CompetitionCompetitor.TABLE_NAME + " (" +
                    CompetitionNetDBContract.CompetitionCompetitor._ID + INTEGER_TYPE + PK + AUTOINCREMENT + COMMA +
                    CompetitionNetDBContract.CompetitionCompetitor.COLUMN_NAME_COMPETITION_ID + INTEGER_TYPE + COMMA +
                    CompetitionNetDBContract.CompetitionCompetitor.COLUMN_NAME_COMPETITOR_ID + INTEGER_TYPE + COMMA +
                    "FOREIGN KEY(" + CompetitionNetDBContract.CompetitionCompetitor.COLUMN_NAME_COMPETITION_ID +
                    ") REFERENCES " + CompetitionNetDBContract.Competition.TABLE_NAME + "(" + CompetitionNetDBContract.Competition._ID + ")" + COMMA +
                    "FOREIGN KEY(" + CompetitionNetDBContract.CompetitionCompetitor.COLUMN_NAME_COMPETITOR_ID +
                    ") REFERENCES " + CompetitionNetDBContract.Competitor.TABLE_NAME + "(" + CompetitionNetDBContract.Competitor._ID + ")" +
            " ); ",
            "CREATE TABLE " + CompetitionNetDBContract.Result.TABLE_NAME + " (" +
                    CompetitionNetDBContract.Result._ID + INTEGER_TYPE + PK + AUTOINCREMENT + COMMA +
                    CompetitionNetDBContract.Result.COLUMN_NAME_MATCH_ID + INTEGER_TYPE + COMMA +
                    CompetitionNetDBContract.Result.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA +
                    "FOREIGN KEY(" + CompetitionNetDBContract.Result.COLUMN_NAME_MATCH_ID +
                    ") REFERENCES " + CompetitionNetDBContract.Match.TABLE_NAME + "(" + CompetitionNetDBContract.Match._ID + ")" +
            " ); "};

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + CompetitionNetDBContract.Competition.TABLE_NAME;

    public CompetitionNetDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String sql : SQL_CREATE_ENTRIES) {
            db.execSQL(sql);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
