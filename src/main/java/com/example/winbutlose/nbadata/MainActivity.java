package com.example.winbutlose.nbadata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView teamListView = (ListView)findViewById(R.id.teamListView);
        ArrayList<NBATeam> teamslist = new ArrayList<NBATeam>();
        teamslist.add(new NBATeam("Atlanta","Hawks","ATL","Atlanta Hawks","hawks","East","Southeast",1610612737));
        teamslist.add(new NBATeam("Boston","Celtics","BOS","Boston Celtics","celtics","East","Atlantic",1610612738));

        NBATeamAdapter teamsadapter = new NBATeamAdapter(this,R.layout.listview_row_layout,teamslist);
        teamListView.setAdapter(teamsadapter);
    }

}
