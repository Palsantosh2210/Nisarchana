package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
public class sellerresult extends AppCompatActivity {
    TextView name,dis,phone,state,price;
    ImageView img;
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


    }
}
