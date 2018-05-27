package com.example.winbutlose.nbadata;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<NBATeam> teamslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView teamListView = (ListView)findViewById(R.id.teamListView);
        teamslist = new ArrayList<NBATeam>();
        //teamslist.add(new NBATeam("Atlanta","Hawks","ATL","Atlanta Hawks","hawks","East","Southeast",1610612737));
        //teamslist.add(new NBATeam("Boston","Celtics","BOS","Boston Celtics","celtics","East","Atlantic",1610612738));

        //async get data
        new fetchTeams().execute();


        NBATeamAdapter teamsadapter = new NBATeamAdapter(this,R.layout.listview_row_layout,teamslist);
        teamListView.setAdapter(teamsadapter);




    }

    private class fetchTeams extends AsyncTask<Void, Void, Void> {

        protected Void doInBackground(Void... arg0) {
            //get json from nba.com
            JSONFetcher sh = new JSONFetcher();
            String jsonStr = sh.fetchJSON("http://data.nba.net/data/10s/prod/v1/2017/teams.json");
            String nickname,city,tricode,fullname,urlName,confName,divName;
            int teamId;
            //organize data
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONObject league = jsonObj.getJSONObject("league");
                    JSONArray standard = league.getJSONArray("standard");

                    // looping through All teams
                    for (int i = 0; i < standard.length(); i++) {
                        JSONObject c = standard.getJSONObject(i);
                        teamId = Integer.parseInt(c.getString("teamId"));
                        nickname = c.getString("nickname");
                        city = c.getString("city");
                        tricode = c.getString("tricode");
                        fullname = c.getString("fullName");
                        urlName = c.getString("urlName");
                        confName = c.getString("confName");
                        divName = c.getString("divName");
                        Boolean isNBA = c.getBoolean("isNBAFranchise");
                        //check to make sure its an NBA team
                        if(isNBA==false){
                            continue;
                        }
                         NBATeam x = new NBATeam(city,nickname,tricode,fullname,urlName,confName,divName,teamId);
                         teamslist.add(x);
                    }
                } catch (final JSONException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't fetch JSON :( Check internet connection", Toast.LENGTH_LONG).show();
                    }
                });

            }

            return null;
        }
    }
}
