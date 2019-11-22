package com.example.glouglou.ui.favoritesBoard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.glouglou.R;
import com.example.glouglou.ui.Async.RemoveOneItem;
import com.example.glouglou.ui.Interfaces.ItemTouchHelperAdapter;
import com.example.glouglou.ui.pojo.Drink;
import com.example.glouglou.ui.pojo.Drinks;
import com.squareup.picasso.Picasso;


public class Adapter_favorite extends RecyclerView.Adapter<Adapter_favorite.MyFavoriteHolder> implements ItemTouchHelperAdapter {
    private Drinks mDataset;
    private View.OnClickListener mOnItemClickListener;

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return true;

    }

    @Override
    public void onItemDismiss(int position) {
        if (mDataset.getDrinks().size() > 1 ){
            new RemoveOneItem().execute(mDataset.getDrinks().get(position));
            mDataset.getDrinks().remove(position);
            notifyItemRemoved(position);
        }


    }
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    public  class MyFavoriteHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textName;
        public TextView idDrink;
        public ImageView imageView;
        public MyFavoriteHolder(View v) {
            super(v);
            v.setTag(this);
            v.setOnClickListener(mOnItemClickListener);
            textName = (TextView) v.findViewById(R.id.drink_name);
            idDrink = (TextView) v.findViewById(R.id.drink_id);
            imageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    public Adapter_favorite(Drinks myDataset) {
        mDataset = myDataset;
    }

    @Override
    public Adapter_favorite.MyFavoriteHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View drinkView = inflater.inflate(R.layout.list_view_search,parent,false);
        MyFavoriteHolder vh = new MyFavoriteHolder(drinkView);
        return vh;
    }

    @Override
    public void onBindViewHolder(Adapter_favorite.MyFavoriteHolder holder, int position) {
        Drink drink = mDataset.getDrinks().get(position);
        TextView textName = holder.textName;
        textName.setText(drink.getStrDrink());
        TextView idDrink = holder.idDrink;
        //idDrink.setText(drink.getIdDrink());
        Picasso.get().load(drink.getStrDrinkThumb()).into(holder.imageView);


    }

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

