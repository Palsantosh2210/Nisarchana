package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class contract extends AppCompatActivity  {
    TextView textview;


    ImageView Setting;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contract);

            textview=findViewById(R.id.bidding);
            textview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {openActivity1();

                }
            });


            Setting = findViewById(R.id.imageButton2);
            Setting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openActivity2();
                }
            });
        }

    private void openActivity1() {
        Intent intent = new Intent(contract.this, Bidding.class);
        startActivity(intent);
    }

    private void openActivity2() {
            Intent intent = new Intent(contract.this, SettingsActivity.class);
            startActivity(intent);

        }
    }
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);

        /*pay = findViewById(R.id.paynow);


        String cemail = "amarjeetvishwakarma0352@gmail.com";
        String cphone = "8850499374";
        String amount = "1500";


        Checkout checkout =new Checkout();
        Checkout.preload(getApplicationContext());
        checkout.setKeyID("rzp_test_WWeWqbVeNrplMv");
        checkout.setImage(R.drawable.logonisar);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Activity activity = contract.this;


                try {
                    JSONObject options = new JSONObject();

                    options.put("name", "Nisarchana");
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
                    Toast.makeText(contract.this, "Error:"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }



            }
        });*/




   /* @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(getApplicationContext(),"success id "+s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(),"failure id "+s,Toast.LENGTH_SHORT).show();
    }*/
