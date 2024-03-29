package com.example.glouglou;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.glouglou.ui.utils.Constants;
import com.example.glouglou.ui.utils.PreferenceUtils;


public class GlouGlouLogin extends AppCompatActivity implements View.OnClickListener {
    private static Context sContext;
    private EditText mLoginEdit;
    private EditText mPasswordEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sContext = getApplicationContext();
        mLoginEdit = (EditText) findViewById(R.id.loginEditText);
        mPasswordEdit = (EditText) findViewById(R.id.passwordEditText);
        findViewById(R.id.loginButton).setOnClickListener(this);
        final String storedLogin = PreferenceUtils.getLogin();
        final String storedPassword = PreferenceUtils.getPassword();
        if ((!TextUtils.isEmpty(storedLogin)) && (!TextUtils.isEmpty(storedPassword))) {
            final Intent homeIntent = getHomeActivityIntent(storedLogin);
            startActivity(homeIntent);
        }


    }


    @Override
    public void onClick(View v) {

        // Check if a login is set
        if (TextUtils.isEmpty(mLoginEdit.getText())){
            // Display a Toast to the user
            Toast.makeText(this, "No login", Toast.LENGTH_LONG).show();
            return;
        }

        // Check if a password is set
        if (TextUtils.isEmpty(mPasswordEdit.getText())){
            // Display a Toast to the user
            Toast.makeText(this, "No password", Toast.LENGTH_LONG).show();
            return;
        }

        // Before launching the second Activity, just save the values in SharedPreferences
        PreferenceUtils.setLogin(mLoginEdit.getText().toString());
        PreferenceUtils.setPassword(mPasswordEdit.getText().toString());


        // Here we are, a login and password are set, try to login
        // For now just launch the second activity, to do that create an Intent
        final Intent homeIntent = getHomeActivityIntent(mLoginEdit.getText().toString());
        startActivity(homeIntent);
    }

    private Intent getHomeActivityIntent(String userName) {
        final Intent intent = new Intent(this, MainActivity.class);
        final Bundle extras = new Bundle();
        extras.putString(Constants.Login.EXTRA_LOGIN, userName);
        intent.putExtras(extras);
        return intent;
    }
    public static Context getContext() {
        return sContext;
    }

}
