package com.example.nisar;

import static com.example.nisar.signin.TAG;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

public class sellerresult extends AppCompatActivity implements PaymentResultListener {
    TextView name,dis,phone,state,price;
    ImageView img;
    Button pay, msg;
    String c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellerresult);
        name= findViewById(R.id.reultfname);
        //dis=findViewById(R.id.reultfdis);
        //phone=findViewById(R.id.reultfphone);
        price=findViewById(R.id.reultfprice);
        //state=findViewById(R.id.reultfstate);
        img = findViewById(R.id.imgv);
        pay = findViewById(R.id.button4);
        msg = findViewById(R.id.msgb);

        Intent intent = getIntent();
        String cname1 = intent.getStringExtra("name");//name
        String cprice = intent.getStringExtra("price");
        String cimage = intent.getStringExtra("image");//img
        //String cdis =intent.getStringExtra("District");//district
        //String cphone = intent.getStringExtra("phone");
        //String cstate = intent.getStringExtra("state");



        name.setText(" "+cname1);
        //dis.setText("C-district: "+cdis);
        //phone.setText("C-phone: "+cphone);
        price.setText("₹ "+cprice);
        //state.setText("C-state: "+cstate);
        c = cimage;
        if(c.length()!=0){
            Picasso.get().load(c).into(img);
        }

        String m = "Hello, I want to talk with you regarding your land";
        String p = "+917304284215";
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!m.isEmpty() && !p.isEmpty()) {

                   // countryCodePicker.registerCarrierNumberEditText(phone);
                  //  phonestr = countryCodePicker.getFullNumber();

                    if (isWhatappInstalled()){

                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone="+p+
                                "&text="+m));
                        startActivity(i);



                    }else {

                        Toast.makeText(sellerresult.this,"Whatsapp is not installed",Toast.LENGTH_SHORT).show();

                    }


                } else {

                    Toast.makeText(sellerresult.this, "Please fill in the Phone no. and message it can't be empty", Toast.LENGTH_LONG).show();

                }







            }
        });









        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    Intent intent1 = new Intent(farmresult.this,paymentgate.class);
                intent1.putExtra("canme",cname1);
                intent1.putExtra("cquant",cquant);
                intent1.putExtra("cemail",cmail);
                intent1.putExtra("cphone",cphone);
                intent1.putExtra("fname",fname);
                startActivity(intent1);*/
                Toast.makeText(getApplicationContext(),"success", Toast.LENGTH_SHORT).show();
            }
        });


        Checkout checkout =new Checkout();
        Checkout.preload(getApplicationContext());
        checkout.setKeyID("rzp_test_WWeWqbVeNrplMv");
        checkout.setImage(R.drawable.logonisar);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final Activity activity = sellerresult.this;


                try {
                    JSONObject options = new JSONObject();

                    options.put("name", "Nisarchana");
                    options.put("description", "Reference No. #123456");
                    options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg");
                    // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
                    options.put("theme.color", "#3399cc");
                    options.put("currency", "INR");
                    options.put("amount", cprice);//pass amount in currency subunits
                    options.put("prefill.email", "nisar@help.gmail.com");
                    options.put("prefill.contact","7304284215");
                    JSONObject retryObj = new JSONObject();
                    retryObj.put("enabled", true);
                    retryObj.put("max_count", 4);
                    options.put("retry", retryObj);

                    checkout.open(activity, options);

                } catch(Exception e) {
                    Log.e(TAG, "Error in starting Razorpay Checkout", e);
                    Toast.makeText(sellerresult.this, "Error:"+e.getMessage(), Toast.LENGTH_SHORT).show();
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
    }


    private boolean isWhatappInstalled(){

        PackageManager packageManager = getPackageManager();
        boolean whatsappInstalled;

        try {

            packageManager.getPackageInfo("com.whatsapp",PackageManager.GET_ACTIVITIES);
            whatsappInstalled = true;


        }catch (PackageManager.NameNotFoundException e){

            whatsappInstalled = false;

        }

        return whatsappInstalled;

    }



}
