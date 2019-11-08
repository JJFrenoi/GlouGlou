package com.example.glouglou.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.glouglou.R;
import com.example.glouglou.ui.pojo.Drink;
import com.example.glouglou.ui.pojo.Drinks;
import com.example.glouglou.ui.pojo.Thecocktaildb_Api;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public static final String BASE_URL ="https://www.thecocktaildb.com/api/json/v1/1/";
    public static Retrofit retrofit = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final ImageView imageView = root.findViewById(R.id.image);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Thecocktaildb_Api thecocktaildb_api = retrofit.create(Thecocktaildb_Api.class);
        Call<Drinks> call = thecocktaildb_api.random();
        call.enqueue((new Callback<Drinks>() {
            @Override
            public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                if(!response.isSuccessful()){
                    textView.setText("code : "+response.code());
                    return;
                }
                Drinks drinks = response.body();
                for (Drink d : drinks.getDrinks()){
                    String content="";
                    content+= "ID: "+d.getIdDrink()+"\n";
                    content+="Drink name :"+d.getStrDrink()+"\n";
                    content+="Instructions: "+d.getStrInstructions()+"\n\n";
                    textView.append(content);
                    Picasso.get().load(d.getStrDrinkThumb()).into(imageView);
                }
            }

            @Override
            public void onFailure(Call<Drinks> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        }));
        return root;
    }
}