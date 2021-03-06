package net.competition;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import net.competition.dal.DALProvider;
import net.competition.dal.DAO;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void startAddCompetition(View view) {
        Intent intent = new Intent(this, AddCompetitionActivity.class);
        startActivity(intent);
    }

    public void startAddCompetitor(View view) {
        Intent intent = new Intent(this, AddCompetitorActivity.class);
        startActivity(intent);
    }

    public void startListCompetitions(View view) {
        Intent intent = new Intent(this, CompetitionsActivity.class);
        startActivity(intent);
    }
}
