package com.example.nisar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Services extends AppCompatActivity {

    TextView pm1,pm2,pm3,pm4,pm5,pm6,pm7,pm8;

    Button bupm1,bupm2,bupm3,bupm4,bupm5,bupm6,bupm7,bupm8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        pm1 = findViewById(R.id.pmk);
        pm2 = findViewById(R.id.pm123);
        pm3 = findViewById(R.id.pmtm12);
        pm4=findViewById(R.id.pm4);
        pm5=findViewById(R.id.pm5);
        pm6=findViewById(R.id.pm6);
        pm7=findViewById(R.id.pm7);
        pm8=findViewById(R.id.pm8);
        bupm1= findViewById(R.id.boopm23);
        bupm2= findViewById(R.id.buoopm);
        bupm3= findViewById(R.id.pmtmmpm);
        bupm4=findViewById(R.id.boopm4);
        bupm5=findViewById(R.id.boopm5);
        bupm6=findViewById(R.id.boopm6);
        bupm7=findViewById(R.id.boopm7);
        bupm8=findViewById(R.id.boopm8);


        pm1.setText("E-SHRAM, Construction Sites (Palghar)");
        pm2.setText("Maharashtra Building and Other Construction Worker Welfare");
        pm3.setText("Construction Workers Child Education Yojanas");
        pm4.setText("Model Welfare Scheme for Building and Other Construction Workers and Action Plan for Strengthening Implementation Machinery");
        pm5.setText("State Welfare Boards for Building and Other Construction Workers (BOCW)");
        pm6.setText("Building and Other Construction Workers (BOCW)");
        pm7.setText("For Women Labour");
        pm8.setText("Assistance Scheme for Construction Worker in Case of General or Accidental Death or Injury");

        bupm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://palghar.gov.in/en/notice_category/welfare-schemes/");
            }
        });

        bupm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://mahabocw.in/mr/%E0%A4%95%E0%A4%B2%E0%A5%8D%E0%A4%AF%E0%A4%BE%E0%A4%A3%E0%A4%95%E0%A4%BE%E0%A4%B0%E0%A5%80-%E0%A4%AF%E0%A5%8B%E0%A4%9C%E0%A4%A8%E0%A4%BE/");
            }
        });

        bupm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.myscheme.gov.in/schemes/nsky");
            }
        });
        bupm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://labour.gov.in/whatsnew/model-welfare-scheme-building-and-other-construction-workers-and-action-plan-strengthening");
            }
        });
        bupm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.insightsonindia.com/2021/03/26/state-welfare-boards-for-building-and-other-construction-workers-bocw/");
            }
        });
        bupm6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://upvesd.gov.in/en/article/building-other-construction-workers-scheme-(bocw)");
            }
        });
        bupm7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://labour.gov.in/womenlabour/about-women-labour");
            }
        });
        bupm8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.myscheme.gov.in/schemes/asfcw");
            }
        });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));



    }
}

