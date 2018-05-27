package com.example.winbutlose.nbadata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NBATeamAdapter extends ArrayAdapter<NBATeam> {
    private Context context;
    private int resource;

    public NBATeamAdapter(@NonNull Context context, int resource, @NonNull List<NBATeam> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String nickname = getItem(position).getNickname();
        String city = getItem(position).getCity();
        String tricode = getItem(position).getTricode();
        String fullName = getItem(position).getFullName();
        String urlName = getItem(position).getUrlName();
        String confName = getItem(position).getConfName();
        String divName = getItem(position).getDivName();
        int teamId = getItem(position).getTeamId();
        NBATeam x = new NBATeam(city, nickname, tricode, fullName, urlName, confName, divName, teamId);

        LayoutInflater inflaterino = LayoutInflater.from(context);
        convertView = inflaterino.inflate(resource,parent,false);

        TextView tv_city = (TextView)convertView.findViewById(R.id.tv_city);
        TextView tv_nickname = (TextView)convertView.findViewById(R.id.tv_nickname);
        TextView tv_tricode = (TextView)convertView.findViewById(R.id.tv_tricode);
        ImageView im_team = (ImageView)convertView.findViewById(R.id.imageview_teamimage);

        tv_city.setText(city);
        tv_nickname.setText(nickname);
        tv_tricode.setText(tricode);
        String logoname = tricode.toLowerCase();
        //im_team.setImageResource(R.drawable.resourcename);
        im_team.setImageResource(context.getResources().getIdentifier(logoname, "drawable", context.getPackageName()));

        return convertView;
    }
}
