package com.chaiidev.kheknoi.ui.compliment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.chaiidev.kheknoi.Visitor;
import com.chaiidev.kheknoi.R;

import java.util.ArrayList;
import java.util.List;

public class VisitorAdapter extends ArrayAdapter<Visitor> {
    public VisitorAdapter(Context context, List<Visitor> visitors) {
        super(context, 0, visitors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Visitor visitors  = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_compliment_list, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        tvName.setText(visitors.getName());
        tvHome.setText(visitors.getMessage());
        // Return the completed view to render on screen
        return convertView;
    }
}
