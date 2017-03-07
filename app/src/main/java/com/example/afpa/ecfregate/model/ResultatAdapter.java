package com.example.afpa.ecfregate.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.afpa.ecfregate.R;

import java.util.List;

/**
 * Created by Afpa on 01/03/2017.
 */

public class ResultatAdapter extends ArrayAdapter<Regate> {

    public ResultatAdapter(Context context, List<Regate> regates) { super(context, 0, regates) ;}

    public View getView(int position, View convertView, ViewGroup parent) {

        Regate regate = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_result_details, parent, false);
        }

        TextView textViewRang = (TextView) convertView.findViewById(R.id.textViewRang);
        TextView textViewNomVoilier = (TextView) convertView.findViewById(R.id.textViewNomVoilier);
        TextView TextViewTemps = (TextView) convertView.findViewById(R.id.TextViewTemps);


        textViewRang.setText(String.valueOf(regate.getPoint()));
        textViewNomVoilier.setText(regate.getNom_voilier());
        int minutes = regate.getTemps_reel();
        String startTime = "00:00";
        int h = minutes / 60 + Integer.parseInt(startTime.substring(0,1));
        int m = minutes % 60 + Integer.parseInt(startTime.substring(3,4));
        String newtime = h+"h"+m;
        TextViewTemps.setText(newtime);

        return convertView;

    }
}
