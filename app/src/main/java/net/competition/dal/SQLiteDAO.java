package net.competition.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import net.competition.domain.Competition;
import net.competition.domain.Competitor;
import net.competition.domain.Match;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korisnik on 7/23/2015.
 */
public class SQLiteDAO implements DAO {

    private static final String TAG = "SQLiteDAO";

    private CompetitionNetDBHelper helper;

    public SQLiteDAO(Context context) {
        helper = new CompetitionNetDBHelper(context);
    }

    @Override
    public void addCompetition(Competition competition) {
        // Gets the data repository in write mode
        SQLiteDatabase db = helper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(CompetitionNetDBContract.Competition.COLUMN_NAME_NAME, competition.getName());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                CompetitionNetDBContract.Competition.TABLE_NAME,
                null,
                values);

        Log.d(TAG, "New Row Id: " + String.valueOf(newRowId));

        db.close();
    }

    @Override
    public void addCompetitor(Competitor competitor) {
        // Gets the data repository in write mode
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "INSERT INTO " + CompetitionNetDBContract.Competitor.TABLE_NAME + " ("+CompetitionNetDBContract.Competitor.COLUMN_NAME_NAME+","+CompetitionNetDBContract.Competitor.COLUMN_NAME_IMAGE+") VALUES(?,?)";
        SQLiteStatement insertStmt = db.compileStatement(sql);
        insertStmt.clearBindings();
        insertStmt.bindString(1, competitor.getName());
        insertStmt.bindBlob(2, competitor.getImage());
        long newRowId = insertStmt.executeInsert();

        Log.d(TAG, "New Row Id: " + String.valueOf(newRowId));

        db.close();
    }

    @Override
    public void addMatchToCompetition(Competition competition, Match match) {

    }

    @Override
    public void addCompetitorToCompetition(Competition competition, Competitor competitor) {

    }

    @Override
    public List<Competition> getAllCompetitions() {
        SQLiteDatabase db = helper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                CompetitionNetDBContract.Competition._ID,
                CompetitionNetDBContract.Competition.COLUMN_NAME_NAME
        };

        Cursor c = db.query(
                CompetitionNetDBContract.Competition.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        String[] names = c.getColumnNames();

        List<Competition> competitions = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(c.getColumnIndexOrThrow(CompetitionNetDBContract.Competition._ID));
                String name = c.getString(c.getColumnIndexOrThrow(CompetitionNetDBContract.Competition.COLUMN_NAME_NAME));
                Competition competition = new Competition(id, name);
                competitions.add(competition);
            } while (c.moveToNext());
        }

        return competitions;
    }

    @Override
    public List<Competitor> getAllCompetitorsFromCompetition(Competition competition) {
        return null;
    }

    @Override
    public List<Match> getAllMatchesFromCompetition(Competition competition) {
        return null;
    }

    @Override
    public void updateCompetition(Competition competition) {

    }

    @Override
    public void updateCompetitor(Competitor competitor) {

    }

    @Override
    public void updateMatch(Match match) {

    }

    @Override
    public void deleteCompetition(Competition competition) {

    }

    @Override
    public void deleteCompetitor(Competitor competitor) {

    }

    @Override
    public void deleteMatch(Match match) {

    }
}
