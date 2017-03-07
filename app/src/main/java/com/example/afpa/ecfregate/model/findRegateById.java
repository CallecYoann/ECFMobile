package com.example.afpa.ecfregate.model;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Afpa on 01/03/2017.
 */

public class findRegateById extends AsyncTask<String, Void, Regate> {

    private final String link = "http://10.105.49.5:8080/api/regatebyid/";

    protected Regate doInBackground(String... params) {
        Regate regate = null;
        StringBuilder sb = new StringBuilder();
        HttpURLConnection urlConnection;

        try {
            System.out.println("Regate id: " + params[0]);
            URL url = new URL(link + params[0]);
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

            System.out.println("result: " + sb.toString());

            JSONObject jsonObject = new JSONObject(sb.toString());

            int id_regate = jsonObject.getInt("id_regate");
            String nom_regate = jsonObject.getString("nom_regate");
            int num_regate = jsonObject.getInt("num_regate");
            String date_regate = jsonObject.getString("date_regate");
            int distance = jsonObject.getInt("distance");
            Date dateRegate = convertDate(date_regate);
            String nom_personne = jsonObject.getString("nom_personne");
            String prenom_personne = jsonObject.getString("prenom_personne");

            Regate r = new Regate(id_regate, nom_regate, num_regate, dateRegate, distance, nom_personne, prenom_personne);

            regate = r;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return regate;

    }

    private static Date convertDate(String str) {
        DateFormat formatter = null;
        Date convertedDate = null;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            convertedDate = (Date) formatter.parse(str);
        } catch (ParseException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convertedDate;
    }

}


