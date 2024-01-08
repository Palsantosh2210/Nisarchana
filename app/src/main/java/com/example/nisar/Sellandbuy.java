package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Sellandbuy extends AppCompatActivity {
    //NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellandbuy);

        View mango1 = findViewById(R.id.mango1);
        toolbar = findViewById(R.id.toolar);
       setSupportActionBar(toolbar);
        mango1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sellandbuy.this,info.class);
                //intent.putExtra("img",R.drawable.mango1);
                intent.putExtra("pricetraad","100");
                intent.putExtra("nametrad","Mango");
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dosell, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id1 = item.getItemId();
        if(id1 == R.id.Sell){
            startActivity( new Intent(getApplicationContext(),sell.class) );

        }

        else {
           startActivity( new Intent(getApplicationContext(),developer.class) );

        }

        return true;
    }

}