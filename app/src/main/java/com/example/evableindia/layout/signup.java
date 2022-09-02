package com.example.evableindia.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evableindia.R;
import com.example.evableindia.response.retrofitclient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signup<onClick> extends AppCompatActivity
{


    EditText name,email_signup,pass_signup;
    TextView tv;

    Button Sign_upR;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        getSupportActionBar().hide();

        name=findViewById(R.id.name);
        email_signup=findViewById(R.id.email_signup);
        pass_signup=findViewById(R.id.pass_signup);
        Sign_upR=findViewById(R.id.Sign_up);
        tv=findViewById(R.id.tv);
    }

    public void signUpprocess(View view)
    {
   registerUser(name.getText().toString(),email_signup.getText().toString(),pass_signup.getText().toString());
    }

    public void registerUser(String name,String email_signup, String pass_signup)
    {



       /* if (email_signup.isEmpty()|name.isEmpty()|pass_signup.isEmpty())
        {
            email_signup.requestFocus();
            email_signup.setError("Please enter your email");
            nameR.requestFocus();
            nameR.setError("Please enter your name");
            pass_signupR.requestFocus();
            pass_signupR.setError("Please enter your password");
            return;
        }*/

        Call<RegfisterResponse> call= retrofitclient
                .getInstance()
                        .getapi()
                                .registers(name,email_signup,pass_signup);

        call.enqueue(new Callback<RegfisterResponse>()
        {
            @Override
            public void onResponse(Call<RegfisterResponse> call, Response<RegfisterResponse> response)
            {
                RegfisterResponse RegfisterResponse = response.body();
          tv.setText(RegfisterResponse.getMessage());



            }

            @Override
            public void onFailure(Call<RegfisterResponse> call, Throwable t)
            {
                Toast.makeText(signup.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }



}