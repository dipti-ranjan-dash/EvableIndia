package com.example.evableindia.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evableindia.R;

public class loginPage extends AppCompatActivity
{
    Button  login;
    EditText emailid,password;

    String rightemailid="admin";
    String rightpass="123";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        getSupportActionBar().hide();

        emailid = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.b1);
    }


        private  boolean validateEmail()
        {
            String emailinput=emailid.getText().toString().trim();
            if (emailinput.isEmpty())
            {
                emailid.setError("enter EmailId");
                return false;
            }
            else
            {
                emailid.setError(null);
                return true;
            }

        }

        private boolean valiidatePass()
        {
            String emailPass=password.getText().toString().trim();
            if (emailPass.isEmpty())
            {
                password.setError("enter password");
                return false;
            }
            else
            {
                password.setError(null);
                return true;
            }
        }

        public void signIn(View view)
        {
            if(!validateEmail() | !valiidatePass())
            {
                return;
            }
            else if(  password.getText().toString().equals(rightpass) & emailid.getText().toString().equals(rightemailid) )
            {
                Intent intent = new Intent(loginPage.this, home.class);
                startActivity(intent);



            }
            else
            {
                Toast.makeText(loginPage.this,"Incorect email Id or password",Toast.LENGTH_LONG).show();
            }
        }



    public void signUp(View view)
    {
        Intent intent = new Intent(loginPage.this, signup.class);
        startActivity(intent);
    }





}