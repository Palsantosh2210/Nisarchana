package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class farmresult extends AppCompatActivity  {
    TextView cropnamere, cropquantityre, croppricere, croptotalpricere, cropfarnamere, cropemailre, cropphonere, cropdistrictre, cropstatere;
    Button paybtn;
    ImageView img;
    String c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmresult);


        Intent intent = getIntent();
        String lname = intent.getStringExtra("name");
        String lage = intent.getStringExtra("age");
        String lemail = intent.getStringExtra("email");
        String lphone = intent.getStringExtra("phone");
        String ledu = intent.getStringExtra("education");
        String lstate = intent.getStringExtra("state");
        String ldis = intent.getStringExtra("dist");
        String limage = intent.getStringExtra("image");
        String lexp= intent.getStringExtra("experience");
        String leng= intent.getStringExtra("engineer");


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

        Intent intent1 = getIntent();
        String name1 = intent1.getStringExtra("name");
        String age = intent1.getStringExtra("age");
        String email = intent.getStringExtra("email");
        String phone = intent1.getStringExtra("phone");
        String education = intent1.getStringExtra("education");
        String state = intent1.getStringExtra("state");
        String dist = intent1.getStringExtra("dist");
        String ctotalprice = intent1.getStringExtra("experience");
        String image = intent1.getStringExtra("image");

       cropnamere.setText("Name: " + name1);
        cropquantityre.setText("Age: " + age);
        croppricere.setText("Education " + education);
        //croptotalpricere.setText("Total Price: " + ctotalprice);
       // cropfarnamere.setText("Name: " + name);
        cropfarnamere.setText("Experience: " + ctotalprice);
        cropemailre.setText("Email: " + email);
        cropphonere.setText("Phone no.: " + phone);
        cropdistrictre.setText("District: " + dist);
        cropstatere.setText("State: " + state);
        //cropstatere.setText("Experience: " + state);
        croptotalpricere.setText("CivilEngineer/Labour: " + leng);
        c = image;
        if(c.length()!=0){
            Picasso.get().load(c).into(img);
        }



      /*  String amount = ctotalprice + "00";

        Checkout checkout =new Checkout();
        Checkout.preload(getApplicationContext());
        checkout.setKeyID("rzp_test_WWeWqbVeNrplMv");
        checkout.setImage(R.drawable.logonisar);


        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Activity activity = farmresult.this;


                try {
                    JSONObject options = new JSONObject();

                    options.put("name", "Krushivottam");
                    options.put("description", "Reference No. #123456");
                    options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg");
                    // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
                    options.put("theme.color", "#3399cc");
                    options.put("currency", "INR");
                    options.put("amount", amount);//pass amount in currency subunits
                    options.put("prefill.email", cemail);
                    options.put("prefill.contact",cphone);
                    JSONObject retryObj = new JSONObject();
                    retryObj.put("enabled", true);
                    retryObj.put("max_count", 4);
                    options.put("retry", retryObj);

                    checkout.open(activity, options);

                } catch(Exception e) {
                    Log.e(TAG, "Error in starting Razorpay Checkout", e);
                    Toast.makeText(farmresult.this, "Error:"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }





            }
        });



    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(getApplicationContext(),"success id "+s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(),"failure id "+s,Toast.LENGTH_SHORT).show();
    }*/
    }
}





