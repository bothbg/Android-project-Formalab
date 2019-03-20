package com.example.flousi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class depenseAdapter extends ArrayAdapter<Expense> {
    private ArrayList<Expense>arrayList;
    private Context ctx;
    private int item;

    public depenseAdapter(@NonNull Context context, int resource , ArrayList<Expense> myarrayList){
        super(context, resource,myarrayList);
        this.arrayList=myarrayList;
        this.ctx=context;
        this.item=resource; }

    @NonNull
    @Override
    public boolean isEnabled(int e)
    {
        return true;
    }

    public View getView(int e, @Nullable View convertView, @NonNull ViewGroup parent) {
        super.getView(e, convertView, parent);
        convertView= LayoutInflater.from(ctx).inflate(item,parent,false);

        TextView  prix=convertView.findViewById(R.id.prix);

        TextView  achat=convertView.findViewById(R.id.achat);

        TextView date=convertView.findViewById(R.id.date);

        prix.setText(Float.toString(arrayList.get(e).getPrix()));
        achat.setText(arrayList.get(e).getAchat());
        date.setText(arrayList.get(e).getDate());

        return convertView; }
}
