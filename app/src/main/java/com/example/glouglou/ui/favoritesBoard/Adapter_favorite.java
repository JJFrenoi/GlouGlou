package com.example.glouglou.ui.favoritesBoard;

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
import com.squareup.picasso.Picasso;

public class Adapter_favorite extends RecyclerView.Adapter<Adapter_favorite.MyFavoriteHolder> {
    private Drinks mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyFavoriteHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textName;
        public TextView idDrink;
        public ImageView imageView;
        public MyFavoriteHolder(View v) {
            super(v);
            textName = (TextView) v.findViewById(R.id.drink_name);
            idDrink = (TextView) v.findViewById(R.id.drink_id);
            // btnDetails = (Button) v.findViewById(R.id.message_button);
            imageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter_favorite(Drinks myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Adapter_favorite.MyFavoriteHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View drinkView = inflater.inflate(R.layout.list_view_search,parent,false);
        MyFavoriteHolder vh = new MyFavoriteHolder(drinkView);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(Adapter_favorite.MyFavoriteHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Drink drink = mDataset.getDrinks().get(position);
        TextView textName = holder.textName;
        textName.setText(drink.getStrDrink());
        TextView idDrink = holder.idDrink;
        idDrink.setText(drink.getIdDrink());
        Picasso.get().load(drink.getStrDrinkThumb()).into(holder.imageView);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        try{
            return mDataset.getDrinks().size();
        }
        catch (NullPointerException e){
            return 1;
        }

    }
}

