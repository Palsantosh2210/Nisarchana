package com.example.nisar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Services extends AppCompatActivity {

    TextView pm1,pm2,pm3;

    Button bupm1,bupm2,bupm3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        pm1 = findViewById(R.id.pmk);
        pm2 = findViewById(R.id.pm123);
        pm3 = findViewById(R.id.pmtm12);
        bupm1= findViewById(R.id.boopm23);
        bupm2= findViewById(R.id.buoopm);
        bupm3= findViewById(R.id.pmtmmpm);

        pm1.setText("Pradhan Mantri Fasal Bima Yojana (PMFBY) scheme was launched in India by Ministry of Agriculture & Farmers welfare, New Delhi from Kharif 2016 season onwards. National Insurance Company started participating in PMFBY from Rabi 2016 onwards and covered 8 States and 2 Union Territories during the past 5 seasons namely, Rabi 2016-17, Kharif & Rabi 2017 and Kharif & Rabi 2018 covering 70,27,637 farmers. Farmers share of premium is Rs. 453 crores and with subsidy from State/Central Govts RS.1909 Crores, gross Premium is Rs.2362 Crores for the 5 seasons together. Whilst the claims of Kharif 18 and Rabi 18 are under process, we have closed the first 3 seasons with a gross premium amount of Rs.1804 Crores collected from 35,22,616 farmers and claims to the tune of Rs.1703 crores were paid, by which 17,66,455 no of farmers benefited, which shows almost 50% of the farmers insured were benefitted.");
        pm2.setText("The Pradhan Mantri Kisan Samman Nidhi Yojana (PM-Kisan Yojana) is a government scheme through which, all small and marginal farmers will get up to Rs 6,000 per year as minimum income support. This 75,000-crore scheme aims to cover 125 million farmers, irrespective of the size of their landholding in India.");
        pm3.setText("Agriculture Infrastructure Fund Scheme is a top-up scheme along with all other available state and central government schemes. Any grant or subsidy available under any present or future scheme of Central/State government can be availed for projects in addition to this financing facility.");


        bupm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://pmfby.gov.in/");
            }
        });

        bupm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://pmkisan.gov.in/RegistrationFormnew.aspx");
            }
        });

        bupm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://vikaspedia.in/schemesall/schemes-for-farmers/agriculture-infrastructure-fund");
            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));



    }
}

