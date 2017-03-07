package com.example.afpa.ecfregate;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afpa.ecfregate.model.Regate;
import com.example.afpa.ecfregate.model.findRegateById;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

/**
 * Created by Afpa on 01/03/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    TextView titreRegate;
    TextView dateRegate;
    TextView commissaireRegate;
    TextView distanceRegate;
    int regateId;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        titreRegate = (TextView) findViewById(R.id.titreRegate);
        dateRegate = (TextView) findViewById(R.id.dateRegate);
        commissaireRegate = (TextView) findViewById(R.id.commissaireRegate);
        distanceRegate = (TextView) findViewById(R.id.distanceRegate);
        regateId = getIntent().getExtras().getInt("liste_regate");
        findRegateById data = new findRegateById();
        data.execute("" + regateId);
        try {
            Regate reg = data.get();
            if (reg == null) {
                System.out.println("Regate is null");
                return;
            }
            titreRegate.setText(reg.getNom_regate());
            dateRegate.setText(String.valueOf(reg.getDate_regate()));
            distanceRegate.setText(String.valueOf(reg.getDistance()));
            commissaireRegate.setText(reg.getNom_personne() + " " + reg.getPrenom_personne());

            final Button button = (Button) findViewById(R.id.ResultButton);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent i = new Intent(getApplicationContext(), ResultatActivity.class);
                    i.putExtra("resultat_regate", regateId);
                    startActivity(i);
                }
            });

            System.out.println("Film getted");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
