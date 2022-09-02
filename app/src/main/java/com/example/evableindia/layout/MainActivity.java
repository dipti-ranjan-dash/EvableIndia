package com.example.evableindia.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.evableindia.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,
                        loginPage.class));
                finish();
            }
        }, 2000);

    }

    public static class register_response
    {

        String error;
        String message;

        public register_response(String error, String message)
        {
            this.error= error;
            this.message=message;
        }

        public String getError()
        {
            return error;
        }

        public void setError()
        {
            this.error=error;
        }

        public String getMessage()
        {
            return message;
        }

        public void setMessage()
        {
            this.error=error;
        }







    }
}