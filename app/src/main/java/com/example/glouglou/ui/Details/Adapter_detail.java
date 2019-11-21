package com.example.glouglou.ui.Details;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.glouglou.R;
import com.example.glouglou.ui.retrofit.Ingredients;

import java.util.List;

public class Adapter_detail extends RecyclerView.Adapter<Adapter_detail.MySearchHolder> {
    private List<Ingredients> mDataset;

    public Adapter_detail(List<Ingredients> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public Adapter_detail.MySearchHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View drinkView = inflater.inflate(R.layout.list_ingredient_view,parent,false);
        Adapter_detail.MySearchHolder vh = new Adapter_detail.MySearchHolder(drinkView);
        return vh;
    }

    @Override
    public void onBindViewHolder(Adapter_detail.MySearchHolder holder, int position) {
        Ingredients i = mDataset.get(position);
        TextView text_ingredient = holder.text_ingredient;
        text_ingredient.setText(i.getIngredient());
        TextView mesure = holder.mesure;
        mesure.setText(i.getMesure());


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MySearchHolder extends RecyclerView.ViewHolder {
        public TextView text_ingredient;
        public TextView mesure;
        public MySearchHolder(View v) {
            super(v);
            text_ingredient = (TextView) v.findViewById(R.id.text_ingredient);
            mesure = (TextView) v.findViewById(R.id.text_mesurement);

        }
    }
}
