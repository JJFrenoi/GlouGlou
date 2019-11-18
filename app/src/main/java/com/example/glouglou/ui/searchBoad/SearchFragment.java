package com.example.glouglou.ui.searchBoad;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glouglou.MainActivity;
import com.example.glouglou.R;
import com.example.glouglou.ui.Async.InitCocktailAsyncTask;
import com.example.glouglou.ui.pojo.Drinks;
import com.example.glouglou.ui.retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment implements SearchListener {
    private SearchViewModel searchViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View root ;
    private Drinks drinks ;
    private EditText etValue;
    private TextView textView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        root = inflater.inflate(R.layout.fragment_research, container, false);
        textView = root.findViewById(R.id.text_research);
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
        new InitCocktailAsyncTask(this).execute("A");
        etValue = (EditText) root.findViewById(R.id.plain_text_input);
        return root;
    }
    private static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    @Override
    public void onStart() {
        super.onStart();
        etValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(final TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    RetrofitHelper retrofitHelper = new RetrofitHelper(v.getText().toString());
                    Call<Drinks> call =  retrofitHelper.getCall();
                    call.enqueue(new Callback<Drinks>() {
                        @Override
                        public void onResponse(Call<Drinks> call, Response<Drinks> response) {
                            if(!response.isSuccessful()){
                                textView.setText("Impossible to find with the word");
                            }
                            else{
                                try {
                                    drinks.getDrinks().clear();
                                    drinks.getDrinks().addAll(response.body().getDrinks());
                                    mAdapter.notifyDataSetChanged();

                                }catch (Exception e){
                                    textView.setText("Impossible to find with the word: " +v.getText().toString());
                                }

                            }
                        }

                        @Override
                        public void onFailure(Call<Drinks> call, Throwable t) {
                            textView.setText("E: "+ t.getMessage());

                        }
                    });
                    hideKeyboardFrom(MainActivity.getContext() , root);
                    return true;
                }
                hideKeyboardFrom(MainActivity.getContext() , root);
                return false;

            }
        });

    }

    @Override
    public void onDrinksRetrieved(Drinks drinks) {
        this.drinks = drinks;
        mAdapter = new Adapter_research(drinks);
        recyclerView.setAdapter(mAdapter);
    }
}