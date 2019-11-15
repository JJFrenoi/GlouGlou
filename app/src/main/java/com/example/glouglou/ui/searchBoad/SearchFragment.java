package com.example.glouglou.ui.searchBoad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glouglou.MainActivity;
import com.example.glouglou.R;
import com.example.glouglou.ui.pojo.Drinks;
import com.example.glouglou.ui.pojo.Thecocktaildb_Api;
import com.example.glouglou.ui.retrofit.RetrofitHelper;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SearchFragment extends Fragment {
    private SearchViewModel searchViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View root ;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        root = inflater.inflate(R.layout.fragment_research, container, false);
        final TextView textView = root.findViewById(R.id.text_research);
        searchViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview_research);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(MainActivity.getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        EditText etValue = (EditText) root.findViewById(R.id.plain_text_input);
        etValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(final TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    RetrofitHelper retrofitHelper = new RetrofitHelper(v.getText().toString());
                    Call<Drinks> call = retrofitHelper.getCall();
                    call.enqueue(new Callback<Drinks>() {
                        @Override
                        public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                            if(!response.isSuccessful()){
                                textView.setText(response.code());
                                return;
                            }
                            else {
                                Drinks drinks = response.body();
                                mAdapter = new Adapter_research(drinks);
                                recyclerView.setAdapter(mAdapter);

                            }



                        }

                        @Override
                        public void onFailure(Call<Drinks> call, Throwable t) {
                            textView.setText("Can't Find a cocktail with this ingredient "+ v.getText().toString());

                        }
                    });
                    hideKeyboardFrom(MainActivity.getContext() , root);
                    return true;
                }
                hideKeyboardFrom(MainActivity.getContext() , root);
                return false;

            }
        });



        return root;
    }
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}