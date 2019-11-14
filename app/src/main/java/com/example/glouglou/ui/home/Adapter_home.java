package com.example.glouglou.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.glouglou.R;
import com.example.glouglou.ui.pojo.Drink;
import com.example.glouglou.ui.pojo.Drinks;
import com.example.glouglou.ui.retrofit.Ingredients;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_home extends RecyclerView.Adapter<Adapter_home.MySearchHolder> {
    private List<Ingredients> mDataset;

    public static class MySearchHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView text_ingredient;
        public TextView mesure;
        public MySearchHolder(View v) {
            super(v);
            text_ingredient = (TextView) v.findViewById(R.id.text_ingredient);
            mesure = (TextView) v.findViewById(R.id.text_mesurement);

        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter_home(List<Ingredients> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Adapter_home.MySearchHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View drinkView = inflater.inflate(R.layout.list_ingredient_view,parent,false);
        Adapter_home.MySearchHolder vh = new Adapter_home.MySearchHolder(drinkView);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(Adapter_home.MySearchHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Ingredients i = mDataset.get(position);
        TextView text_ingredient = holder.text_ingredient;
        text_ingredient.setText(i.ingredient);
        TextView mesure = holder.mesure;
        mesure.setText(i.mesure);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
