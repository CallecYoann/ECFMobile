package com.example.afpa.ecfregate.model;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Afpa on 01/03/2017.
 */

public class FindInfoRegate extends AsyncTask<String, Void, List<Regate>> {

    private final String link = "http://10.105.49.5:8080/api/info/";

    protected List<Regate> doInBackground(String... params) {
        List<Regate> regates = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        HttpURLConnection urlConnection;

        try {
            URL url = new URL(link  + params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(800000);
            urlConnection.setConnectTimeout(800000);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent", "ecf_dahouet");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                System.out.println("OK");

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();

            } else {
                System.out.println("PAS OK");
            }
            urlConnection.disconnect();

            System.out.println("result : " + sb.toString());

            JSONArray jsonArray = new JSONArray(sb.toString());

            for (int i = 0, count = jsonArray.length(); i < count; i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id_regate = jsonObject.getInt("id_regate");
                int point = jsonObject.getInt("point");
                int temps_reel = jsonObject.getInt("temps_reel");
                String nom_voilier = jsonObject.getString("nom_voilier");
                String nom_regate = jsonObject.getString("nom_regate");


                Regate r = new Regate(id_regate, point, nom_voilier, temps_reel, nom_regate);

                regates.add(r);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return regates;

    }

}
