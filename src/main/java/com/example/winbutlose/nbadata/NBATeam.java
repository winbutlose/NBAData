package com.example.winbutlose.nbadata;

import android.media.Image;

public class NBATeam {
    private String city,nickname,tricode,fullName,urlName,confName,divName;
    private int teamId;

    public NBATeam(String city, String nickname, String tricode, String fullName, String urlName, String confName, String divName, int teamId) {
        this.city = city;
        this.nickname = nickname;
        this.tricode = tricode;
        this.fullName = fullName;
        this.urlName = urlName;
        this.confName = confName;
        this.divName = divName;
        this.teamId = teamId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTricode() {
        return tricode;
    }

    public void setTricode(String tricode) {
        this.tricode = tricode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getDivName() {
        return divName;
    }

    public void setDivName(String divName) {
        this.divName = divName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

}
