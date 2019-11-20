package com.example.glouglou.ui.searchBoad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glouglou.MainActivity;
import com.example.glouglou.R;
import com.example.glouglou.ui.Async.InitCocktailAsyncTask;
import com.example.glouglou.ui.Details.DetailFragment;
import com.example.glouglou.ui.Interfaces.DrinksListener;
import com.example.glouglou.ui.pojo.Drink;
import com.example.glouglou.ui.pojo.Drinks;
import com.example.glouglou.ui.retrofit.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment implements DrinksListener {
    private SearchViewModel searchViewModel;
    private RecyclerView recyclerView;
    private Adapter_research mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View root ;
    private Drinks drinks ;
    private EditText etValue;
    private TextView textView;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //TODO: Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Drink thisDrink = drinks.getDrinks().get(position);
            Toast.makeText(MainActivity.getContext(), "You Clicked: " + thisDrink.getStrDrink(), Toast.LENGTH_SHORT).show();
            final FragmentTransaction transaction = getFragmentManager().beginTransaction();
            final DetailFragment detailFragment = new DetailFragment();
            final Bundle bundle = new Bundle();
            bundle.putParcelable("drink", (Parcelable) thisDrink);
            detailFragment.setArguments(bundle);
            transaction.replace(R.id.nav_host_fragment,detailFragment);
            transaction.setCustomAnimations(R.animator.slide_in_right,0,0,R.animator.slide_in_left);
            transaction.addToBackStack(null).commit();

        }
    };


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
        mAdapter.setOnItemClickListener(onItemClickListener);
    }
}