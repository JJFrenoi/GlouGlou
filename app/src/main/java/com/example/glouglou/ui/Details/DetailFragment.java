package com.example.glouglou.ui.Details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glouglou.MainActivity;
import com.example.glouglou.R;
import com.example.glouglou.ui.Async.AddToBDDAsync;
import com.example.glouglou.ui.home.Adapter_home;
import com.example.glouglou.ui.pojo.Drink;
import com.example.glouglou.ui.pojo.Drinks;
import com.example.glouglou.ui.retrofit.RetrofitHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView imageView ;
    private TextView textView ;
    private TextView text_glass ;
    private TextView text_instruction ;
    private Button button_fav ;
    private Drink drink;
    private Drinks drinks ;
    public DetailFragment(){

    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        drink = getArguments().getParcelable("drink");
        List<Drink> drinkList = new ArrayList<>();
        drinkList.add(drink);
        drinks = new Drinks(drinkList);
        final View root = inflater.inflate(R.layout.fragment_detail, container, false);
        imageView = root.findViewById(R.id.image_detail);
        Picasso.get().load(drink.getStrDrinkThumb()).into(imageView);
        button_fav = root.findViewById(R.id.fav_detail);
        textView = root.findViewById(R.id.text_home_detail);
        textView.setText(drink.getStrDrink());

        text_glass = root.findViewById(R.id.text_glass_detail);
        text_glass.setText(drink.getStrGlass());
        text_instruction = root.findViewById(R.id.text_instruction_detail);
        text_instruction.setText(drink.getStrInstructions());

        recyclerView = (RecyclerView) root.findViewById(R.id.list_ingredients_detail);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(MainActivity.getContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new Adapter_home(RetrofitHelper.getListofIngredient(drinks));
        recyclerView.setAdapter(mAdapter);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        button_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AddToBDDAsync().execute(drinks);
                Toast.makeText(MainActivity.getContext(),"Adding to BDD",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
