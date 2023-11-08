package com.example.nisar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    Button logout;
    FirebaseAuth firebaseAuth;

    Button bfn;
    FirebaseFirestore firebaseFirestore;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private long pressedtime;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      logout = findViewById(R.id.logout);

        firebaseAuth = FirebaseAuth.getInstance();



        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();




        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navview);
        toolbar = findViewById(R.id.toolar);



        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



      logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseAuth.signOut();
                startActivity( new Intent(getApplicationContext(), login.class));
                Toast.makeText(MainActivity.this, "Logout successfully", Toast.LENGTH_SHORT).show();
                finish();


            }
        });




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //profile


                int id = item.getItemId();

                if(id == R.id.optprofile){



                }
                else if(id == R.id.opthome){


                }
                else if(id == R.id.opttips){
                    startActivity(new Intent(getApplicationContext(),contract.class));

                }
                else if(id == R.id.optservice){

                }
                else if(id == R.id.optshare){

                }
                else if(id == R.id.optcontact){
                    startActivity(new Intent(getApplicationContext(),developer.class));


                }
                else {
                    firebaseAuth.signOut();
                    startActivity( new Intent(getApplicationContext(), login.class));
                    Toast.makeText(MainActivity.this, "Logout successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }

                drawerLayout.closeDrawer(GravityCompat.START);




                return true;
            }
        });


















    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
            finish();
        }



    }

    //end
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dotitem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id1 = item.getItemId();
        if(id1 == R.id.joinus){


        }

        else {
            // startActivity( new Intent(getApplicationContext(),MainActivity5.class) );

        }



        return true;
    }



    //end






}