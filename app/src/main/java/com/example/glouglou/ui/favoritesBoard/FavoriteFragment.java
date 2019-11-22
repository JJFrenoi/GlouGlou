package com.example.glouglou.ui.favoritesBoard;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glouglou.MainActivity;
import com.example.glouglou.R;
import com.example.glouglou.ui.Async.RetrievedFromBDD;
import com.example.glouglou.ui.Details.DetailFragment;
import com.example.glouglou.ui.Interfaces.DrinksListener;
import com.example.glouglou.ui.pojo.Drink;
import com.example.glouglou.ui.pojo.Drinks;

public class FavoriteFragment extends Fragment implements DrinksListener {

    private FavoriteViewModel notificationsViewModel;
    private TextView textView;
    private View root;
    private RecyclerView recyclerView;
    private Adapter_favorite mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Drinks drinks;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Drink thisDrink = drinks.getDrinks().get(position);
            Toast.makeText(MainActivity.getContext(), "You Clicked: " + thisDrink.getStrDrink(), Toast.LENGTH_SHORT).show();
            final FragmentTransaction transaction = getFragmentManager().beginTransaction();
            final DetailFragment detailFragment = new DetailFragment();
            final Bundle bundle = new Bundle();
            bundle.putParcelable("drink", (Parcelable) thisDrink);
            detailFragment.setArguments(bundle);
            transaction.setCustomAnimations(R.animator.slide_in_right,0,0,R.animator.slide_in_left);
            transaction.replace(R.id.nav_host_fragment,detailFragment);
            transaction.addToBackStack(null).commit();

        }
    };
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
        layoutManager = new GridLayoutManager(MainActivity.getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        new RetrievedFromBDD(this).execute();
        return  root;
    }


    @Override
    public void onStart() {
        super.onStart();

    }
    @Override
    public void onDrinksRetrieved(Drinks drinks) {
        if (drinks != null){
            this.drinks = drinks;
            mAdapter = new Adapter_favorite(drinks);
            recyclerView.setAdapter(mAdapter);
        }
        if (mAdapter != null && drinks.getDrinks().size() >0  ){
            ItemTouchHelper.Callback callback =
                    new SimpleItemTouchHelperCallback(mAdapter);
            ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
            touchHelper.attachToRecyclerView(recyclerView);
            mAdapter.setOnItemClickListener(onItemClickListener);
        }

    }
}