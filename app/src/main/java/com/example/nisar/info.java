package com.example.nisar;

import static com.razorpay.AppSignatureHelper.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class info extends AppCompatActivity implements PaymentResultListener {

    Button addtocart,pay;

    FirebaseAuth Auth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        firestore=FirebaseFirestore.getInstance();
        Auth=FirebaseAuth.getInstance();



        addtocart=findViewById(R.id.button);
        pay = findViewById(R.id.button4);

        Checkout checkout =new Checkout();
        Checkout.preload(getApplicationContext());
        checkout.setKeyID("rzp_test_WWeWqbVeNrplMv");
        checkout.setImage(R.drawable.logonisar);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               final Activity activity = info.this;


                try {
                    JSONObject options = new JSONObject();

                    options.put("name", "Nisarchana");
                    options.put("description", "Reference No. #123456");
                    options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg");
                     options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
                    options.put("theme.color", "#3399cc");
                    options.put("currency", "INR");

                    JSONObject retryObj = new JSONObject();
                    retryObj.put("enabled", true);
                    retryObj.put("max_count", 4);
                    options.put("retry", retryObj);

                    checkout.open(activity, options);

                } catch(Exception e) {
                    Log.e(TAG, "Error in starting Razorpay Checkout", e);
                    Toast.makeText(info.this, "Error:"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }



            }
        });
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addtocart();
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

    private void addtocart() {

        String saveCurrentTime,saveCurrentDate;

        Calendar calFprDate = Calendar.getInstance();

        SimpleDateFormat currentDate =new SimpleDateFormat("mm dd,yyyy");
        saveCurrentDate = currentDate.format(calFprDate.getTime());

        SimpleDateFormat currentTime =new SimpleDateFormat("mm dd,yyyy");
        saveCurrentTime = currentTime.format(calFprDate.getTime());

        final HashMap<String,Object> cartMap= new HashMap<>();
        //cartMap.put("productName",name.getText().toString());
        //cartMap.put("productPrice",price.getText().toString());
        cartMap.put("currentTime",saveCurrentTime);
        cartMap.put("currentDate",saveCurrentDate);

        firestore.collection("AddToCart").document(Auth.getCurrentUser().getUid()).collection("user").add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(info.this,"Added to Cart",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    }
