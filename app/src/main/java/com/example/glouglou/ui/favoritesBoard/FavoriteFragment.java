package com.example.glouglou.ui.favoritesBoard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glouglou.MainActivity;
import com.example.glouglou.R;
import com.example.glouglou.ui.Async.RetrievedFromBDD;
import com.example.glouglou.ui.Interfaces.DrinksListener;
import com.example.glouglou.ui.pojo.Drinks;
import com.example.glouglou.ui.searchBoad.Adapter_research;

public class FavoriteFragment extends Fragment implements DrinksListener {

    private FavoriteViewModel notificationsViewModel;
    private TextView textView;
    private View root;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Drinks drinks;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(FavoriteViewModel.class);
        root = inflater.inflate(R.layout.fragment_favorite, container, false);
        textView = root.findViewById(R.id.text_favorite);
        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview_favorite);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(MainActivity.getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        new RetrievedFromBDD(this).execute();
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        
    }
    @Override
    public void onDrinksRetrieved(Drinks drinks) {
        if (drinks != null){
            this.drinks = drinks;
            mAdapter = new Adapter_research(drinks);
            recyclerView.setAdapter(mAdapter);
        }

    }
}