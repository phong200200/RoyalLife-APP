package com.example.royallifeapplication;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.royallifeapplication.HelperClass.HomeAdapter.CatgoriersCard;
import com.example.royallifeapplication.HelperClass.HomeAdapter.FeatureAdpater;
import com.example.royallifeapplication.HelperClass.HomeAdapter.FeaturedHelpersClass;
import com.example.royallifeapplication.HelperClass.HomeAdapter.ViewedCard;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class mmeennuu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static int choosingNo;
    RecyclerView viewedCard;
    ViewedCard adapter1;
    RecyclerView featuredRecycler;
    FeatureAdpater adapter;
    RecyclerView catgoriersCard;
    CatgoriersCard adapter2;
    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FirebaseAuth fAuth;

    public LinearLayout lnShopping;
    public LinearLayout lnCine;
    public LinearLayout lnHotel;
    public LinearLayout lnRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mmeennuu);

        binding();
        featuredRecycler = findViewById(R.id.featred_recycler);
        featuredRecycler();
        viewedCard = findViewById(R.id.featred_recycler1);
        viewedCard();
        catgoriersCard = findViewById(R.id.featred_recycler2);
        catgoriersCard();

        //Menu
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(mmeennuu.this,
                drawerLayout,
                R.string.open,
                R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getCheckedItem();

        lnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosingNo = 1;
                Intent intent = new Intent(mmeennuu.this, choosingPlace.class);
                startActivity(intent);
            }
        });
        lnHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosingNo = 2;
                Intent intent = new Intent(mmeennuu.this, choosingPlace.class);
                startActivity(intent);
            }
        });
        lnShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosingNo = 3;
                Intent intent = new Intent(mmeennuu.this, choosingPlace.class);
                startActivity(intent);
            }
        });
        lnCine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosingNo = 4;
                Intent intent = new Intent(mmeennuu.this, choosingPlace.class);
                startActivity(intent);
            }
        });
    }

    private void binding() {
        lnShopping = (LinearLayout) findViewById(R.id.lnShopp);
        lnCine = (LinearLayout) findViewById(R.id.lnCine);
        lnHotel = (LinearLayout) findViewById(R.id.lnHotel);
        lnRest = (LinearLayout) findViewById(R.id.lnRest);
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelpersClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelpersClass(R.drawable.cgv, "CGV CINEMA", "CGV is one of the top 5 largest cinema clusters in the world and the largest distributor and cinema complex in Vietnam."));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.kfc, "KFC", "KFC specializes in fried and grilled chicken products, with side dishes and sandwiches made from fresh chicken."));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.mc, "McDonald's", "McDonald's is known as the world famous fast food restaurant system with more than 35,000 stores."));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.gym, "California", "In 2007 California Fitness & Yoga became the first and largest international fitness company to launch in Vietnam."));

        adapter = new FeatureAdpater(featuredLocations);
        featuredRecycler.setAdapter(adapter);

        GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }


    private void viewedCard() {
        viewedCard.setHasFixedSize(true);
        viewedCard.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHelpersClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelpersClass(R.drawable.cgv, "CGV CINEMA", "CGV is one of the top 5 largest cinema clusters in the world and the largest distributor and cinema complex in Vietnam."));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.kfc, "KFC", "KFC specializes in fried and grilled chicken products, with side dishes and sandwiches made from fresh chicken."));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.mc, "McDonald's", "McDonald's is known as the world famous fast food restaurant system with more than 35,000 stores."));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.gym, "California", "In 2007 California Fitness & Yoga became the first and largest international fitness company to launch in Vietnam."));

        adapter1 = new ViewedCard(featuredLocations);
        viewedCard.setAdapter(adapter1);

        GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }


    private void catgoriersCard() {
        catgoriersCard.setHasFixedSize(true);
        catgoriersCard.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHelpersClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelpersClass(R.drawable.restaurant, "Restaurant", ""));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.hotel, "Hotels", ""));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.shopping, "Shopping's", ""));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.cinema, "Cinema", ""));

        adapter2 =new CatgoriersCard(featuredLocations);
        catgoriersCard.setAdapter(adapter2);

        GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
    }


    //onclick
    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navProfile:
                showprofile();
                break;
            case R.id.SignoutMenu:
                FirebaseAuth.getInstance().signOut();
                Intent intentt = new Intent(mmeennuu.this,Login.class);
                intentt.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentt);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
    public  void showprofile(){
        Intent intent = getIntent();
        String fullname = intent.getStringExtra("fullname");
        String email = intent.getStringExtra("email");
        String pass = intent.getStringExtra("pass");
        String username = intent.getStringExtra("username");
        String phone = intent.getStringExtra("phone");

        Intent intent1 = new Intent(getApplication(), Profile.class);
        intent1.putExtra("fullname",fullname);
        intent1.putExtra("email",email);
        intent1.putExtra("phone",phone);
        intent1.putExtra("pass",pass);
        intent1.putExtra("username",username);
        startActivity(intent1);
    }
}