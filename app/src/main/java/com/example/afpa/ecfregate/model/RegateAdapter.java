package com.example.afpa.ecfregate.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afpa.ecfregate.R;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by Afpa on 28/02/2017.
 */

public class RegateAdapter extends ArrayAdapter<Regate> {

    public RegateAdapter(Context context, List<Regate> regates) { super(context, 0, regates) ;}

    public View getView(int position, View convertView, ViewGroup parent) {

        Regate regate = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_description, parent, false);
        }

        TextView regateTitre = (TextView) convertView.findViewById(R.id.regateTitre);

        regateTitre.setText(regate.getNom_regate());

        return convertView;

    }
}
