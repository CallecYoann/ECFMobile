package com.example.afpa.ecfregate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.afpa.ecfregate.model.Regate;
import com.example.afpa.ecfregate.model.RegateAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    List<Regate> regates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listRegate = (ListView) findViewById(R.id.listRegate);
        registerForContextMenu(listRegate);

        FindByChallenge data = new FindByChallenge();
        data.execute();
        try {
            regates = data.get();
            final RegateAdapter adapter = new RegateAdapter(this, regates);
            listRegate.setAdapter(adapter);
            listRegate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Regate regate = adapter.getItem(position);

                    Log.i("selected id regate:", String.valueOf(regate.getId_regate()));
                    Intent i = new Intent(getApplicationContext(), DetailsActivity.class);
                    System.out.println("Regate id: " + regate.getId_regate());
                    i.putExtra("liste_regate", regate.getId_regate());
                    startActivity(i);
                }
            });


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
