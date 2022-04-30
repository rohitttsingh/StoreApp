package com.example.storeapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class CartActivity extends AppCompatActivity {
    SmoothBottomBar smoothBottomBar;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        smoothBottomBar=findViewById(R.id.bottombar);

        smoothBottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {

                switch (i){
                    case 0:break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        break;

                    case 2: break;
                }
                return true;
            }
        });
    }
}