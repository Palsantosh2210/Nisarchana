package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    labouradapter labouradapter;

    Button all;
    Button newest;
    Button popular;
    Button trend;
    FirebaseAuth firebaseAuth;

    Button bfn;
    FirebaseFirestore firebaseFirestore;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private long pressedtime;
    String userId;

    ImageView Setting;
    ImageView Home;

    ImageView twodimensional;

    ImageView All;

    ImageView Twod;
    ImageView LandBidding;
    ImageView Hireworker;
    ImageView F_all;

    ImageView Land;
    ImageView Bidding;
    ImageView Profile;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);
        searchView.clearFocus();
        listView = findViewById(R.id.list_view);
        String[] items = {
                "land", "Acres", "Cherry", "Date", "Fig", "Grape", "Kiwi", "Lemon", "Mango",
                "Orange", "Papaya", "Peach", "Pear", "Pineapple", "Plum", "Raspberry", "Strawberry",
                "Tangerine", "Watermelon"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        setupSearchView();

        Bidding=findViewById(R.id.imageButton5);
        Bidding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity21();
            }
        });

        textview=findViewById(R.id.viewmore);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openActivity20();

            }
        });


        Setting = findViewById(R.id.imageButton);
        Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        Home=findViewById(R.id.imageButton7);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });

        twodimensional=findViewById(R.id.imageButton2);
        twodimensional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        All=findViewById(R.id.imageButton3);
        All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });

        Land =findViewById(R.id.imageButton11);
        Land.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });
        Land =findViewById(R.id.imageButton12);
        Land.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity12();
            }
        });
        Land =findViewById(R.id.imageButton13);
        Land.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity13();
            }
        });
        Land =findViewById(R.id.imageButton14);
        Land.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity14();
            }
        });

        Profile=findViewById(R.id.imageButton10);
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity5();
            }
        });

        F_all = findViewById(R.id.imageButton3);
        F_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity6();
            }
        });
        Hireworker = findViewById(R.id.imageButton4);
        Hireworker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity7();
            }
        });
        LandBidding = findViewById(R.id.imageButton5);
        LandBidding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity8();
            }
        });
        Twod = findViewById(R.id.imageButton6);
        Twod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity9();
            }
        });




        all = findViewById(R.id.all);
        newest = findViewById(R.id.newest);
        popular = findViewById(R.id.popular);
        trend = findViewById(R.id.trend);

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

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity( new Intent(getApplicationContext(), all.class));




            }
        });

        newest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity( new Intent(getApplicationContext(), newest.class));




            }
        });

        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity( new Intent(getApplicationContext(), Popular.class));




            }
        });

        trend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity( new Intent(getApplicationContext(), trend.class));




            }
        });





        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //profile


                int id = item.getItemId();

                if(id == R.id.optprofile){
                    startActivity(new Intent(getApplicationContext(),Profile.class));


                }
                else if(id == R.id.opthome){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }
                else if(id == R.id.opttips){
                    startActivity(new Intent(getApplicationContext(),contract.class));

                }
                else if(id == R.id.optservice){
                    startActivity(new Intent(getApplicationContext(),Services.class));

                }
                else if(id == R.id.optshare){
                    startActivity(new Intent(getApplicationContext(),share.class));
                }

                else if(id == R.id.Hiring){
                    startActivity(new Intent(getApplicationContext(),hiringlist.class));

                }

                else if(id == R.id.contact){
                    startActivity(new Intent(getApplicationContext(),developer.class));

                }
                else if(id == R.id.sellandbuy){
                    startActivity(new Intent(getApplicationContext(),Sellandbuy.class));


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

    private void openActivity21() {
        Intent intent = new Intent(MainActivity.this, Bidding.class);
        startActivity(intent);
    }

    private void openActivity20() {
        Intent intent = new Intent(MainActivity.this, Viewmore.class);
        startActivity(intent);
    }

    private void openActivity14() {
        Intent intent = new Intent(MainActivity.this, Fouracres.class);
        startActivity(intent);
    }

    private void openActivity13() {
        Intent intent = new Intent(MainActivity.this, threeacres.class);
        startActivity(intent);

    }

    private void openActivity12() {
        Intent intent = new Intent(MainActivity.this, twoacres.class);
        startActivity(intent);
    }

    private void openActivity5() {
        Intent intent = new Intent(MainActivity.this, Profile.class);
        startActivity(intent);
    }

    private void openActivity2() {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);

    }

    private void openActivity1() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);

    }

    private void openActivity3() {
        Intent intent = new Intent(MainActivity.this, twodimensional.class);
        startActivity(intent);

    }

    private void openActivity4() {
        Intent intent = new Intent(MainActivity.this, landinfo.class);
        startActivity(intent);

    }

    private void openActivity6() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);

    }
    private void openActivity7() {
        Intent intent = new Intent(MainActivity.this, Labour.class);
        startActivity(intent);

    }
    private void openActivity8() {
        Intent intent = new Intent(MainActivity.this, Bidding.class);
        startActivity(intent);
    }
    private void openActivity9() {
        Intent intent = new Intent(MainActivity.this, twodimensional.class);
        startActivity(intent);
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
        if(id1 == R.id.Hiring){
            startActivity( new Intent(getApplicationContext(),Hiring.class) );

        }

        else {
            startActivity( new Intent(getApplicationContext(),developer.class) );

        }

        return true;
    }

    //end

    private void filter(String query) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) listView.getAdapter();
        adapter.getFilter().filter(query);
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
    }

}