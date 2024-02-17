package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class civilengiresult extends AppCompatActivity  {
    TextView cropnamere,cropquantityre,croppricere,croptotalpricere,cropfarnamere,cropemailre,cropphonere,cropdistrictre,cropstatere;
    Button paybtn;
    ImageView img;
    String c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civilengiresult);

        cropnamere = findViewById(R.id.cropnamere);
        cropquantityre = findViewById(R.id.cropquantityre);
        croppricere = findViewById(R.id.croppricre);
        croptotalpricere = findViewById(R.id.croptotalpricere);
        cropfarnamere = findViewById(R.id.cropfarnamere);
        cropemailre = findViewById(R.id.cropemailre);
        cropphonere = findViewById(R.id.cropphonere);
        cropdistrictre = findViewById(R.id.cropdistrictre);
        cropstatere = findViewById(R.id.cropstatere);
        paybtn = findViewById(R.id.paytn);
        img = findViewById(R.id.imgv);

        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String education = intent.getStringExtra("education");
        String state = intent.getStringExtra("state");
        String dist = intent.getStringExtra("dist");
        // String ctotalprice = intent1.getStringExtra("totalprice");
        String image = intent.getStringExtra("image");
        String ctotatprice= intent.getStringExtra("experience");
        //String ctotatprice= intent.getStringExtra("experiencex");
        String leng= intent.getStringExtra("engineer");

        cropnamere.setText("Name: " + name1);
        cropquantityre.setText("Age: " + age);
        croppricere.setText("Education " + education);

         cropfarnamere.setText("Experience: " + ctotatprice);
        cropemailre.setText("Email: " + email);
        cropphonere.setText("Phone no.: " + phone);
        cropdistrictre.setText("District: " + dist);
        cropstatere.setText("State: " + state);
        croptotalpricere.setText("CivilEngineer/Labour: " + leng);

        c = image;
        if(c.length()!=0){
            Picasso.get().load(c).into(img);
        }
    }
}





