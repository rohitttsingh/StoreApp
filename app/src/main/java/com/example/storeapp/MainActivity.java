package com.example.storeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.android.material.navigation.NavigationView;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    private SmoothBottomBar smoothBottomBar;
    ImageView imageView;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Rohit singh1");
        imageView=findViewById(R.id.imagelemon);
        smoothBottomBar=findViewById(R.id.smooth);
        navigationView=findViewById(R.id.navigatev);

        toolbar= findViewById(R.id.toolar);
        drawerLayout=findViewById(R.id.drawer);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout,toolbar,R.string.app_name,R.string.app_name);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.e:
                        Toast.makeText(getApplicationContext(),"Exit",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });



        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        smoothBottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {

                switch (i){
                    case 0:
                        Toast.makeText(getApplicationContext(),"0",Toast.LENGTH_LONG);
                        break;
                    case 1: break;

                    case 2:
                        startActivity(new Intent(getApplicationContext(),CartActivity.class));
                        break;

                }
                return true;
            }
        });




        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Activity2.class);
                ActivityOptionsCompat optionsCompat =  ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this
                        ,imageView, ViewCompat.getTransitionName(imageView));

                startActivity(intent,optionsCompat.toBundle());
            }
        });

    }

}