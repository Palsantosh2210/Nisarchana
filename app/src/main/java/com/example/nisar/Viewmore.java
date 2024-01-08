package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Viewmore extends AppCompatActivity {
    ImageButton twod,bidding,calamities,hireworker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmore);

        twod=findViewById(R.id.imageButton2);
        twod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        bidding=findViewById(R.id.imageButton3);
        bidding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        hireworker=findViewById(R.id.imageButton4);
        hireworker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

    calamities=findViewById(R.id.imageButton5);
    calamities.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openActivity5();
        }
    });
    }

    private void openActivity3() {
        Intent intent = new Intent(Viewmore.this, Bidding.class);
        startActivity(intent);
    }

    private void openActivity4() {
        Intent intent = new Intent(Viewmore.this, hiringlist.class);
        startActivity(intent);
    }

    private void openActivity5() {
       // Intent intent = new Intent(Viewmore.this, Fouracres.class);
        //startActivity(intent);
    }

    private void openActivity2() {
        Intent intent = new Intent(Viewmore.this, twodimensional.class);
        startActivity(intent);
    }

}