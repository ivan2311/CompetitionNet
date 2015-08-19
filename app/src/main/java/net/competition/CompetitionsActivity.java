package net.competition;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import net.competition.dal.DALProvider;
import net.competition.dal.DAO;
import net.competition.domain.Competition;

import java.util.List;


public class CompetitionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);

        ListView lvCompetitions = (ListView)findViewById(R.id.lv_competitions);

        DAO dao = DALProvider.getDAO();
        List<Competition> competitions = dao.getAllCompetitions();
        ArrayAdapter<Competition> adapterCompetitions = new LvCompetitionsAdapter(this, competitions);
        lvCompetitions.setAdapter(adapterCompetitions);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_competitions, menu);
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


    private class LvCompetitionsAdapter extends ArrayAdapter<Competition> {

        private Context context;
        private List<Competition> values;

        public LvCompetitionsAdapter(Context context, List<Competition> values) {
            super(context, -1, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_row_competition, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.tv_name);
            textView.setText(values.get(position).getName());
            return rowView;
        }
    }
}
