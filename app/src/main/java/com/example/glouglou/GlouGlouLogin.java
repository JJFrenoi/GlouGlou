package com.example.glouglou;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.glouglou.utils.Constants;
import com.example.glouglou.utils.PreferenceUtils;


public class GlouGlouLogin extends AppCompatActivity implements View.OnClickListener {

    private EditText sLoginEdit;
    private EditText sPasswordEdit;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sLoginEdit = (EditText) findViewById(R.id.loginEditText);
        sPasswordEdit = (EditText) findViewById(R.id.passwordEditText);
        findViewById(R.id.loginButton).setOnClickListener(this);

        final String login = PreferenceUtils.getLogin();
        if(!TextUtils.isEmpty(login)) startActivity(getNameIntent(login));
        getActionBar().setTitle("GlouGlou Login");

    }


    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(sLoginEdit.getText())){
            Toast.makeText(this, "Empty Login", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(sPasswordEdit.getText())){
            Toast.makeText(this, "Empty PassWord", Toast.LENGTH_SHORT).show();
            return;
        }

        String login = sLoginEdit.getText().toString();
        PreferenceUtils.setLogin(login);
        startActivity(getNameIntent(login));
    }

    private Intent getNameIntent(String username){

        final Intent nameIntent = new Intent(this, MainActivity.class);
        final Bundle extras = new Bundle();
        extras.putString(Constants.Login.EXTRA_LOGIN, username);
        nameIntent.putExtras(extras);
        return nameIntent;
    }


}
