package com.example.glouglou.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glouglou.MainActivity;
import com.example.glouglou.R;
import com.example.glouglou.ui.Async.AddToBDDAsync;
import com.example.glouglou.ui.pojo.Drinks;
import com.example.glouglou.ui.retrofit.RetrofitHelper;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView imageView ;
    private TextView textView ;
    private TextView text_glass ;
    private TextView text_instruction ;
    private Button button_fav ;
    private Drinks drinks;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        imageView = root.findViewById(R.id.image);
        button_fav = root.findViewById(R.id.fav);
        textView = root.findViewById(R.id.text_home);
        text_glass = root.findViewById(R.id.text_glass);
        text_instruction = root.findViewById(R.id.text_instruction);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        recyclerView = (RecyclerView) root.findViewById(R.id.list_ingredients);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(MainActivity.getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        final RetrofitHelper retrofitHelper = new RetrofitHelper();
        final Call<Drinks> call = retrofitHelper.getCall();
        call.enqueue((new Callback<Drinks>() {
            @Override
            public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                if(!response.isSuccessful()){
                    textView.setText("code : "+response.code());
                    return;
                }
                try {
                    drinks = response.body();
                    textView.setText(drinks.getDrinks().get(0).getStrDrink());
                    text_glass.setText(drinks.getDrinks().get(0).getStrGlass());
                    text_instruction.setText(drinks.getDrinks().get(0).getStrInstructions());
                    Picasso.get().load(drinks.getDrinks().get(0).getStrDrinkThumb()).into(imageView);
                    mAdapter = new Adapter_home(retrofitHelper.getListofIngredient(drinks));
                    recyclerView.setAdapter(mAdapter);
                }catch (Exception e ){
                    textView.setText("Error marche pas");
                }


            }

            @Override
            public void onFailure(Call<Drinks> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        }));
        button_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AddToBDDAsync().execute(drinks);
                Toast.makeText(MainActivity.getContext(),"Adding to BDD",Toast.LENGTH_SHORT).show();
            }
        });
    }
}