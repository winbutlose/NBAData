package com.example.winbutlose.nbadata;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class JSONFetcher {
    public JSONFetcher() {
        //no args needed
    }

    public String fetchJSON(String URLString) {
        String ans = null;
        try {
            URL url = new URL(URLString);
            HttpURLConnection HUC = (HttpURLConnection) url.openConnection();
            HUC.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(HUC.getInputStream());
            ans = convertStreamToString(in);
        } catch (MalformedURLException e) {
            Log.e(JSONFetcher.class.getSimpleName(), "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(JSONFetcher.class.getSimpleName(), "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(JSONFetcher.class.getSimpleName(), "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(JSONFetcher.class.getSimpleName(), "Exception: " + e.getMessage());
        }

        return ans;
    }
    private String convertStreamToString(InputStream ins) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
