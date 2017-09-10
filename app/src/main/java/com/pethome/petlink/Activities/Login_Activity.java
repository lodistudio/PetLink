package com.pethome.petlink.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;

import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.pethome.petlink.R;

import java.util.Arrays;

public class Login_Activity extends AppCompatActivity {
    CallbackManager callbackManager;
    Context ctx = Login_Activity.this;
    String fbEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Facebook Login System
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        fbEmail = Profile.getCurrentProfile().getId() + "@facebook.com";
                        Toast.makeText(ctx, "Funcionou o login, email coletado: " + fbEmail, Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onCancel() {
                        Toast.makeText(ctx, "Não funcionou o login!", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(ctx, "Deu erro no login!", Toast.LENGTH_LONG).show();
                    }
                });
        Button btLoginFacebook = (Button) findViewById(R.id.btLoginFacebook);
        btLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(Login_Activity.this, Arrays.asList("public_profile", "email"));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
