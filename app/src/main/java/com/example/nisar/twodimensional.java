package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class twodimensional extends AppCompatActivity {

    double l,h, w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twodimensional);

        TextView t1, t2, t3,t4, t5, t6, t7, t8, t9,t10;
        ImageView side, front , ground;
//
//    String bridge[][] ={{"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%201%20front.png?alt=media&token=392394e2-0275-4786-8c24-de5638de210f","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%201%20side.png?alt=media&token=18846d1a-eb5e-4bda-ba5c-cf2b4b1311ce"},
//
//        {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%202%20front.png?alt=media&token=a2c39a6a-d114-481f-a2a2-c9bfb70318b0","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%202%20side.png?alt=media&token=33f4f70d-ea2e-4300-a8a3-fff5c61bde39"}};
//
//    String House[][] ={{"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%202%20Ground.png?alt=media&token=eb4bfdeb-8632-468f-a27f-2f7f3da1bfcd","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%202%20side.png?alt=media&token=654f36a9-c5a0-4f91-8f42-aa549327e1b6","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%202.png?alt=media&token=5eeb45d6-1d05-4097-9372-84828f7a69b4"},
//
//        {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%203%20Ground.png?alt=media&token=dcca879a-db8f-4928-bcd4-cedc118a22d3","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%203%20side.png?alt=media&token=392ea733-49e8-4f82-b045-56cc4c44223d","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%203.png?alt=media&token=a721654b-b0b8-466e-9809-ff9c44a23390"}};
//
//        String build[][] = {{"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%201%20ground.png?alt=media&token=0b294421-5367-4d59-a34c-63fff1970235","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%201%20side.png?alt=media&token=2741856f-f915-48ff-af43-815c24322b95","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%201.png?alt=media&token=9f1f8c69-2e55-4e34-a772-aa3ae6dd5ff2"},
//
//                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%202%20ground.png?alt=media&token=b1914058-351b-415a-91a2-b4998f4fac27","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%202%20side.png?alt=media&token=c3f5c46d-0d96-4de8-98a0-e3f45cbe0d5f","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%202.png?alt=media&token=6d8ca0b7-0649-4f21-95f5-1676b6305f37"}};


        String damb [][]= {{"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Dam%2FDam%201%20side.png?alt=media&token=1da2570b-3f83-4692-b63c-ca0d4a623c9d","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Dam%2Fdam%201%20front.png?alt=media&token=a0e66df1-bde6-4079-ab05-2b8c566944ef"},

                        {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Dam%2Fdam%202%20side.png?alt=media&token=f999ad46-cc69-4d09-954f-a0ce566bae0e","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Dam%2Fdam%202%20front.png?alt=media&token=ca5f88d9-f503-4503-a780-5d0a7ca6fc74"},

                        {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Dam%2Fdam%203%20side.png?alt=media&token=9c411e9b-ab28-4bc9-85dc-8ca0d8507318","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Dam%2Fdam%203%20front.png?alt=media&token=2acf75fe-959d-4deb-8cf9-6d8f0d580ca4"}};





        String House [][]= {{"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%202%20Ground.png?alt=media&token=eb4bfdeb-8632-468f-a27f-2f7f3da1bfcd","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%202%20side.png?alt=media&token=654f36a9-c5a0-4f91-8f42-aa549327e1b6","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%202.png?alt=media&token=5eeb45d6-1d05-4097-9372-84828f7a69b4"},{"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%203%20Ground.png?alt=media&token=dcca879a-db8f-4928-bcd4-cedc118a22d3","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%203%20side.png?alt=media&token=392ea733-49e8-4f82-b045-56cc4c44223d","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%203.png?alt=media&token=a721654b-b0b8-466e-9809-ff9c44a23390"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%205%20Ground.png?alt=media&token=9b62fac7-3c01-4efc-9b8d-fdb3744dd001","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%205%20side.png?alt=media&token=244b664a-ff32-4d71-9a9a-59692f09accd","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%205.png?alt=media&token=8d9bc7ae-a3a1-4518-bbd6-f1a3ff4b00e9"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%206%20Side.png?alt=media&token=9c54a5c4-433b-4538-a378-9145088ad273","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%206%20ground.png?alt=media&token=3244155b-3f11-49c3-b27f-e6cad47b9556","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%206.png?alt=media&token=42636557-935d-4ffc-a53b-344a4ad7d60e"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%207%20ground.png?alt=media&token=2f2229ce-3e06-452a-8c1b-c1afb947b0d5","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%207%20.png?alt=media&token=e28825d0-2c9d-459d-9861-ef35205987e5","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%207%20side.png?alt=media&token=aa32a92a-70b0-44e3-b3a3-f6ec64afb5ab"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%208%20ground.png?alt=media&token=dbead1e4-50e5-45d0-a37e-e09d16b16bc5","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%208%20side.png?alt=media&token=ff1e7c39-7b9b-4545-b88e-6617afd7652d","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%208.png?alt=media&token=b9ea1c91-afa1-4ffb-8683-0394573584bd"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse%20ground1.png?alt=media&token=972cfb9b-64f4-45cc-9cae-73747c3aa243","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse1%20side.png?alt=media&token=501ebdd1-3c2c-4369-aa8d-2c1cf420843b","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/House%2FHouse1.png?alt=media&token=74f35eff-e8a7-4946-bad0-e1473d7fb97e"}};

        String building[][]= {{"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%201%20ground.png?alt=media&token=0b294421-5367-4d59-a34c-63fff1970235","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%201%20side.png?alt=media&token=2741856f-f915-48ff-af43-815c24322b95","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%201.png?alt=media&token=9f1f8c69-2e55-4e34-a772-aa3ae6dd5ff2"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%202%20ground.png?alt=media&token=b1914058-351b-415a-91a2-b4998f4fac27","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%202%20side.png?alt=media&token=c3f5c46d-0d96-4de8-98a0-e3f45cbe0d5f","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%202.png?alt=media&token=6d8ca0b7-0649-4f21-95f5-1676b6305f37"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%203%20ground.png?alt=media&token=c1006399-1fc1-4061-8582-17dfa8ccd039","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%203%20side.png?alt=media&token=31f6aa3f-e62b-4b5c-a66a-c850cc2b9898","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%203.png?alt=media&token=aca575bf-8f32-4ccf-b48d-abbaf3bcb7cc"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuiding%204%20ground.png?alt=media&token=b7714f72-f1ea-4708-8347-9d833ed0cd2d","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%204%20side.png?alt=media&token=f70d4c3b-3cf6-4103-aa1b-290e41aa3d77","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%204.png?alt=media&token=f42187da-9194-492b-9853-53448f5e8526"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%205%20ground.png?alt=media&token=16f90de3-f65e-4e14-8b78-75f322f7b703","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%205%20side.png?alt=media&token=b82367f4-cd4a-4e2d-8689-5abe1e41bcdc","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Buildings%2FBuilding%205%20.png?alt=media&token=0ee13257-e12a-4874-9245-c2f86443b1ea"}};


        String bridge[][]= {{"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%201%20front.png?alt=media&token=392394e2-0275-4786-8c24-de5638de210f","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%201%20side.png?alt=media&token=18846d1a-eb5e-4bda-ba5c-cf2b4b1311ce"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%202%20front.png?alt=media&token=a2c39a6a-d114-481f-a2a2-c9bfb70318b0","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%202%20side.png?alt=media&token=33f4f70d-ea2e-4300-a8a3-fff5c61bde39"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%203%20front.png?alt=media&token=70a5c8e8-3215-4d79-a774-095452fb09fa","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%203%20side.png?alt=media&token=cf4fbd53-cec9-40ec-a907-edf9e054c4ab"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%204%20front.png?alt=media&token=1b587df7-d764-4ed2-8b08-31a899458f1a","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%204%20side.png?alt=media&token=51569ff6-b145-4c02-be7d-1fb3b131c3c2"},

                {"https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%205%20front%20.png?alt=media&token=f8cb0471-3582-4ffb-b0fe-a1200b20af68","https://firebasestorage.googleapis.com/v0/b/nisar-c08a1.appspot.com/o/Bridge%2FBridge%205%20side.png?alt=media&token=4885a11b-3096-47b3-bb4d-ed0bfe2515c2"}};


            t1 = findViewById(R.id.t1);
            t2 = findViewById(R.id.t2);
            t3 = findViewById(R.id.t3);
            t4= findViewById(R.id.t4);
            t5= findViewById(R.id.t5);
            t6= findViewById(R.id.t6);
            t7= findViewById(R.id.t7);
            t8= findViewById(R.id.t8);
            t9= findViewById(R.id.t9);
            t10 = findViewById(R.id.t10);
            side = findViewById(R.id.side);
            front = findViewById(R.id.front);
            ground = findViewById(R.id.ground);

            String s = " M";
            Intent intent = getIntent();
            String len =  intent.getStringExtra("len");
            String wid=  intent.getStringExtra("wid");
            String bread  =intent.getStringExtra("bread");
            String heigh =  intent.getStringExtra("heig");
            String weigh = intent.getStringExtra("weigh");
            String st =intent.getStringExtra("strtyp");

            String s1 = "Dam";
            String s2 = "Bridge";
            String s3 = "Building";
            String s4 = "House";


         l=Double.parseDouble(len);
         h=Double.parseDouble(heigh);
     w=Double.parseDouble(wid);

            int i =0;
            if(st.equals(s1)) i=1;
            else if(st.equals(s2)) i=2;
            else if (st.equals(s3)) {
                i=3;
            }
            else{
                i=4;
            }


        //  System.out.println(st);

            t1.setText(len+s);
            t2.setText(wid+s);
            t3.setText(bread+s);

            t4.setText(heigh+s);
            t5.setText(bread+s);
            t6.setText(wid+s);

            t7.setText(len+s);
            t8.setText(wid+s);
            t9.setText(heigh+s);

            t10.setText("Total Height: "+heigh+"  "+"Total Weight: "+weigh);


            if(i==1){

//                Picasso.get().load(damb[0][0]).into(side);
//                Picasso.get().load(damb[0][1]).into(front);
//                Picasso.get().load(damb[1][0]).into(ground);

                if(l>= 31 && l<=37){

                Picasso.get().load(damb[0][0]).into(side);
                Picasso.get().load(damb[0][1]).into(front);
                Picasso.get().load(damb[1][0]).into(ground);


                }
                else if(l>= 38 && l<= 45){
                    Picasso.get().load(damb[1][0]).into(side);
                    Picasso.get().load(damb[1][1]).into(front);
                    Picasso.get().load(damb[1][0]).into(ground);

                } else if (l>=46 && l<= 55) {
                    Picasso.get().load(damb[2][0]).into(side);
                    Picasso.get().load(damb[2][1]).into(front);
                    Picasso.get().load(damb[1][0]).into(ground);

                }  else  {
                    Picasso.get().load(damb[2][1]).into(side);
                    Picasso.get().load(damb[1][1]).into(front);
                    Picasso.get().load(damb[1][0]).into(ground);
                }


                //
//                Picasso.get().load(bridge[0][0]).into(side);
//                Picasso.get().load(bridge[0][1]).into(front);
//                Picasso.get().load(bridge[1][0]).into(ground);


            }
            else if(i==2){
                if(l>= 31 && l<=37){

                    Picasso.get().load(bridge[0][0]).into(side);
                    Picasso.get().load(bridge[0][1]).into(front);
                    Picasso.get().load(bridge[1][0]).into(ground);



                }
                else if(l>= 38 && l<= 45){
                    Picasso.get().load(bridge[1][0]).into(side);
                    Picasso.get().load(bridge[1][1]).into(front);
                    Picasso.get().load(bridge[1][0]).into(ground);

                } else if (l>=46 && l<= 55) {
                    Picasso.get().load(bridge[2][0]).into(side);
                    Picasso.get().load(bridge[2][1]).into(front);
                    Picasso.get().load(bridge[1][0]).into(ground);

                } else if ( l>=56 && l<= 62) {
                    Picasso.get().load(bridge[3][0]).into(side);
                    Picasso.get().load(bridge[3][1]).into(front);
                    Picasso.get().load(bridge[1][0]).into(ground);
                } else if (l>= 63 && l<= 70) {
                    Picasso.get().load(bridge[4][0]).into(side);
                    Picasso.get().load(bridge[4][1]).into(front);
                    Picasso.get().load(bridge[1][0]).into(ground);
                } else if (l>= 71 && l<= 77) {
                    Picasso.get().load(bridge[4][1]).into(side);
                    Picasso.get().load(bridge[2][1]).into(front);
                    Picasso.get().load(bridge[1][0]).into(ground);
                } else if (l>=78 && l<= 85) {
                    Picasso.get().load(bridge[3][1]).into(side);
                    Picasso.get().load(bridge[4][1]).into(front);
                    Picasso.get().load(bridge[1][0]).into(ground);
                }

            }
            else if(i==3) {
                if(l>= 31 && l<=37){

                    Picasso.get().load(building[0][0]).into(side);
                    Picasso.get().load(building[0][1]).into(front);
                    Picasso.get().load(building[0][2]).into(ground);



                }
                else if(l>= 38 && l<= 45){
                    Picasso.get().load(building[1][0]).into(side);
                    Picasso.get().load(building[1][1]).into(front);
                    Picasso.get().load(building[1][2]).into(ground);

                } else if (l>=46 && l<= 55) {
                    Picasso.get().load(building[2][0]).into(side);
                    Picasso.get().load(building[2][1]).into(front);
                    Picasso.get().load(building[2][2]).into(ground);

                } else if ( l>=56 && l<= 62) {
                    Picasso.get().load(building[3][0]).into(side);
                    Picasso.get().load(building[3][1]).into(front);
                    Picasso.get().load(building[3][2]).into(ground);
                } else if (l>= 63 && l<= 70) {
                    Picasso.get().load(building[4][0]).into(side);
                    Picasso.get().load(building[4][1]).into(front);
                    Picasso.get().load(building[4][2]).into(ground);
                } else if (l>= 71 && l<= 77) {
                    Picasso.get().load(building[3][0]).into(side);
                    Picasso.get().load(building[4][1]).into(front);
                    Picasso.get().load(building[4][2]).into(ground);
                } else if (l>=78 && l<= 85) {
                    Picasso.get().load(building[3][1]).into(side);
                    Picasso.get().load(building[4][1]).into(front);
                    Picasso.get().load(building[2][2]).into(ground);
                }

            }
            else {
                if(l>= 31 && l<=37){

                    Picasso.get().load(House[0][0]).into(side);
                    Picasso.get().load(House[0][1]).into(front);
                    Picasso.get().load(House[1][0]).into(ground);



                }
                else if(l>= 38 && l<= 45){
                    Picasso.get().load(House[1][0]).into(side);
                    Picasso.get().load(House[1][1]).into(front);
                    Picasso.get().load(House[1][0]).into(ground);

                } else if (l>=46 && l<= 55) {
                    Picasso.get().load(House[2][0]).into(side);
                    Picasso.get().load(House[2][1]).into(front);
                    Picasso.get().load(House[1][0]).into(ground);

                } else if ( l>=56 && l<= 62) {
                    Picasso.get().load(House[3][0]).into(side);
                    Picasso.get().load(House[3][1]).into(front);
                    Picasso.get().load(House[1][0]).into(ground);
                } else if (l>= 63 && l<= 70) {
                    Picasso.get().load(House[4][0]).into(side);
                    Picasso.get().load(House[4][1]).into(front);
                    Picasso.get().load(House[1][0]).into(ground);
                } else if (l>= 71 && l<= 77) {
                    Picasso.get().load(House[4][1]).into(side);
                    Picasso.get().load(House[2][1]).into(front);
                    Picasso.get().load(House[1][0]).into(ground);
                } else if (l>=78 && l<= 85) {
                    Picasso.get().load(House[3][1]).into(side);
                    Picasso.get().load(House[4][1]).into(front);
                    Picasso.get().load(House[1][0]).into(ground);
                }
            }

        }
    }
