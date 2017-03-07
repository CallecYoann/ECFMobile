package com.example.afpa.ecfregate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.afpa.ecfregate.model.FindInfoRegate;
import com.example.afpa.ecfregate.model.Regate;
import com.example.afpa.ecfregate.model.RegateAdapter;
import com.example.afpa.ecfregate.model.ResultatAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Afpa on 01/03/2017.
 */

public class ResultatActivity extends AppCompatActivity {

    List<Regate> regates;
    int regateId;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_details);
        regateId = getIntent().getExtras().getInt("resultat_regate");
        System.out.println("aaaaaaaaaaa " + regateId);
        ListView listResultat = (ListView) findViewById(R.id.listResultat);
        registerForContextMenu(listResultat);

        FindInfoRegate data = new FindInfoRegate();
        data.execute("" +regateId);
        try {
            regates = data.get();
            final ResultatAdapter adapter = new ResultatAdapter(this, regates);
            listResultat.setAdapter(adapter);
            listResultat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Regate regate = adapter.getItem(position);

                }
            });


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
