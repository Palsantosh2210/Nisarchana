package com.example.nisar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bidding extends AppCompatActivity {
    TextView pmk;
    Button bupm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidding);

        pmk = findViewById(R.id.pmk);
        bupm1= findViewById(R.id.boopm23);
        pmk.setText("Explore an exclusive land opportunity at our upcoming bidding event! This prime real estate offers versatile zoning, investment potential, and a strategic location. Participate in the transparent bidding process for a chance to secure this valuable property. Easy access, a range of possibilities, and a fair competition await. Register, preview, bid, and win – make this exceptional land yours for investment or dream home aspirations. Don't miss out on this chance to own a piece of prime real estate – secure your spot in the bidding process now!");
       bupm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://eauction.gov.in/eauction/#/");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}