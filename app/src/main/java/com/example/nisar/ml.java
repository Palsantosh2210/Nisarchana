package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ml extends AppCompatActivity {
    AutoCompleteTextView structure, flood, Region, Capabilities, Rock, Soil;
    TextInputEditText soiltypeh, soilweighth, regionh, capabilitiesh, rocktypeh, waterdepthh, maxwaterflowh, magnitudeh, depthh, soilbearinhgh, stormh;
    TextInputLayout soiltype, soilweight, region, capabilities, rocktype, soilbearing, waterdepth, dropdown, maxwaterflow, magnitude, depth, storm, dropdown1;
    Button PREDICT;
    DatabaseReference spinnerRef;
    String item1, item2, item4, item6, item7, item5;
    String[] item = {"Bridge", "Dam", "Building","House"};
    AutoCompleteTextView autoCompleteTextView;
    String[] item3 = {"Yes", "No"};
    String[] capabilities1 = {"good", "Better", "Very Hard", "Hard", "Easy", "Best"};
    String[] Rocktype1 = {"Gneiss", "Schist", "Chalk", "Phonolite", "Syenite", "Limestone", "Granite", "Basalt", "Sandstone", "Slit", "Volcanic Rocks", "Flint", "Marl", "Shale", "Slate", "SlitStone", "Mudstone",
            "SiltStone", "Steatite", "Ochre", "Calcite", "Kota Stone", "Copper", "Marble", "Igneous", "Weathered", "Mineral Rock", "Weathered Rocks", "Laterite ", "Clay", "Silt", "Glacier ", "Metamorphoric",
            "Glacier Rock "};
    String[] Region1 = {"Tropical ", "Semi-Arid", "Arid ", "River Valley", "Flood Plains", "Indo Gangetic Plain", "Indo-Gangetic Plain", "Thar Desert", "Northern Plain", "Deccan Plateau", "Malwa Plateau",
            "Sahyadri Mountains", "Mediterranean", "Us Great Plains", "Argentinian pampa", "Eastern Europe", "Midwest", "Deccan Trap", "North Western", "Eastern Ghats", "Western Ghat", "Central India",
            "Himalayas", "Northeastern", "North Eastern", "Peninsular ", "western siberian Plain", "Russian Far East", "Part of West Bengal", "Tamil Nadu Plateau", "Northern Plateau", "Sundarbans",
            "Western Coasts", "Eastern Coast", "Eastern Plateau", "Northwestern India", "Glaciated ", "River Deltas", "Marshlands", "Taiga ", "Boreal", "Central Part of North America", "Southern Gangetic Plain",
            "Chhattisgarh Plateau", "West Coast", "Central Australia", "Southern Western US", "Nothern Africa", "NorthEastern", "Northern Hemisphere", "Ganga Plain", "Eastern Peninsular"};
    String[] soiltype1 = {"Alfisols soil", "Alkaline Soil", "Alluvial Soil", "Arid Soil", "Aridisol soil", "Azonal Soil", "Black Cotton Soil", "Brown Soil", "Chalk Soil", "Chernozems Soil", "Chestnut Soil",
            "Clay Soil", "Deltaic clay", "Desert Soil", "Entisols Soil", "Forest Soil", "Gray Brown Soil", "Gray soil", "Histosols Soil", "Inceptisols soil", "Laterite Soil", "Marshy Soil", "Mollisols Soil",
            "Mountainous soil", "Oxisol soil", "Peat Soil", "Podsols Soil", "Prairie Soil", "Red Soil", "Saline soil", "Sandy loam", "Semi Arid soil", "Snowfields", "Spodosol Soil", "Tundra soil", "Ultisol soil",
            "Yellow soil", "Zonal Soil"};
    ArrayAdapter<String> adapterItems;
    ArrayList<String> spinnerList;
    double lat;
    double longi;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    FusedLocationProviderClient mFusedLocationClient;
    // Initializing other items
    // from layout file
    // TextView latitudeTextView, longitTextView;
    int PERMISSION_ID = 44;
    String url = "https://web-production-bcd01.up.railway.app/dim";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ml);

        // soiltypeh = findViewById(R.id.soiltypeh);
        soilweighth = findViewById(R.id.soilweighth);
        //regionh = findViewById(R.id.regionh);
        //capabilitiesh = findViewById(R.id.capabilitiesh);
        //rocktypeh = findViewById(R.id.rocktypeh);
        waterdepthh = findViewById(R.id.waterdepthh);
        soilbearinhgh = findViewById(R.id.soilbearinhgh);
        maxwaterflowh = findViewById(R.id.maxwaterflowh);
        // magnitudeh = findViewById(R.id.magnitudeh);
        depthh = findViewById(R.id.depthh);
        stormh = findViewById(R.id.stormh);
        PREDICT= findViewById(R.id.sell);

        soiltype = findViewById(R.id.soiltype);
        soilweight = findViewById(R.id.soilweight);
        region = findViewById(R.id.region);
        capabilities = findViewById(R.id.capabilities);
        rocktype = findViewById(R.id.rocktype);
        waterdepth = findViewById(R.id.waterdepth);
        maxwaterflow = findViewById(R.id.maxwaterflow);
        //magnitude = findViewById(R.id.magnitude);
        depth = findViewById(R.id.depth);
        storm = findViewById(R.id.storm);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        // mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // method to get the location
        //  getLastLocation();

        spinnerRef = FirebaseDatabase.getInstance().getReference("Spinner Data");
        spinnerList = new ArrayList<>();
        adapterItems = new ArrayAdapter<String>(ml.this, android.R.layout.simple_spinner_dropdown_item, spinnerList);
        structure = findViewById(R.id.auto_complete_txt2);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, item);
        structure.setAdapter(adapterItems);

        spinnerRef = FirebaseDatabase.getInstance().getReference("Spinner Data");
        spinnerList = new ArrayList<>();
        adapterItems = new ArrayAdapter<String>(ml.this, android.R.layout.simple_spinner_dropdown_item, spinnerList);
        Soil = findViewById(R.id.auto_complete_txt3);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, soiltype1);
        Soil.setAdapter(adapterItems);

        spinnerRef = FirebaseDatabase.getInstance().getReference("Spinner Data");
        spinnerList = new ArrayList<>();
        adapterItems = new ArrayAdapter<String>(ml.this, android.R.layout.simple_spinner_dropdown_item, spinnerList);
        Region = findViewById(R.id.auto_complete_txt4);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, Region1);
        Region.setAdapter(adapterItems);

        spinnerRef = FirebaseDatabase.getInstance().getReference("Spinner Data");
        spinnerList = new ArrayList<>();
        adapterItems = new ArrayAdapter<String>(ml.this, android.R.layout.simple_spinner_dropdown_item, spinnerList);
        Capabilities = findViewById(R.id.auto_complete_txt5);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, capabilities1);
        Capabilities.setAdapter(adapterItems);

        spinnerRef = FirebaseDatabase.getInstance().getReference("Spinner Data");
        spinnerList = new ArrayList<>();
        adapterItems = new ArrayAdapter<String>(ml.this, android.R.layout.simple_spinner_dropdown_item, spinnerList);
        Rock = findViewById(R.id.auto_complete_txt6);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, Rocktype1);
        Rock.setAdapter(adapterItems);

//        spinnerRef = FirebaseDatabase.getInstance().getReference("Spinner Data");
//        spinnerList = new ArrayList<>();
//        adapterItems = new ArrayAdapter<String>(ml.this, android.R.layout.simple_spinner_dropdown_item, spinnerList);
//        flood = findViewById(R.id.auto_complete_txt1);
//        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, item3);
//        flood.setAdapter(adapterItems);

        structure.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                item1 = item;
                //  Toast.makeText(Hiring.this, "+ item"+ item, Toast.LENGTH_SHORT).show();
            }
        });

//        flood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String item3 = adapterView.getItemAtPosition(i).toString();
//                item2 = item3;
//                //  Toast.makeText(Hiring.this, "+ item"+ item, Toast.LENGTH_SHORT).show();
//            }
//        });

        Region.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Region1 = adapterView.getItemAtPosition(i).toString();
                item6 = Region1;
                //  Toast.makeText(Hiring.this, "+ item"+ item, Toast.LENGTH_SHORT).show();
            }
        });

        Soil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String soiltype1 = adapterView.getItemAtPosition(i).toString();
                item7 = soiltype1;
                //  Toast.makeText(Hiring.this, "+ item"+ item, Toast.LENGTH_SHORT).show();
            }
        });
        Capabilities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String capabilities1 = adapterView.getItemAtPosition(i).toString();
                item5 = capabilities1;
                //  Toast.makeText(Hiring.this, "+ item"+ item, Toast.LENGTH_SHORT).show();
            }
        });

        Rock.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Rocktype1 = adapterView.getItemAtPosition(i).toString();
                item4 = Rocktype1;
                //  Toast.makeText(Hiring.this, "+ item"+ item, Toast.LENGTH_SHORT).show();
            }
        });
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        PREDICT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lat = "17.212334";
                String longt = "12.24245";
                String soil = item7;
                String soilwe = soilweighth.getText().toString().trim();
                String reg = item6;
                String capabi = item5;
                String rockty = item4;
                String soilb = soilbearinhgh.getText().toString().trim();
                String watert = waterdepthh.getText().toString().trim();
                String str = item1.trim();
//                str = str.trim();
                String maxwa = maxwaterflowh.getText().toString().trim();
                String depth = depthh.getText().toString().trim();
                 String maxwind = "100";
                String annrain = stormh.getText().toString().trim();
  //              String flood1 = flood.toString().trim();

//                Map<String, Object> regfa = new HashMap<>();
//                regfa.put("Soil", soil);
//                regfa.put("soil weight", soilwe);
//                regfa.put("Region", reg);
//                regfa.put("capabilities", capabi);
//                regfa.put("rock type", rockty);
//                regfa.put("waterd", watert);
//                regfa.put("str", str);
//                regfa.put("max", maxwa);
//                regfa.put("depth", depth);
//                regfa.put("rain", annrain);
//                regfa.put("flood", flood1);

//                firebaseFirestore.collection("ML").add(regfa).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//
//                        Toast.makeText(ml.this, "Sucessfully stored", Toast.LENGTH_SHORT).show();
////                        Soil.setText("");
////                        soilweighth.setText("");
////                        Region.setText("");
////                        Capabilities.setText("");
////                        Rock.setText("");
////                       soilb.setText("");
////                        waterdepthh.setText("");
////                        structure.setText("");
////                        maxwaterflowh.setText("");
////                        depthh.setText("");
////                        stormh.setText("");
////                        flood.setText("");
//
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(ml.this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                //end

                StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {


                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String len =  jsonObject.getString("Length");
                                    String wid =  jsonObject.getString("Width");
                                    String bread =  jsonObject.getString("Breadth");
                                    String heig =  jsonObject.getString("Height");
                                    String weig =  jsonObject.getString("Weight");


                                    Intent intent = new Intent(ml.this,twodimensional.class);
                                    intent.putExtra("len",len);
                                    intent.putExtra("wid",wid);
                                    intent.putExtra("bread",bread);
                                    intent.putExtra("heig",heig);
                                    intent.putExtra("weigh",weig);
                                    intent.putExtra("strtyp", str);
                                    startActivity(intent);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(ml.this, "Error"+error.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        })   {


                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("Latitude",lat);
                        params.put("Longitude",longt);
                        params.put("Soil Type",soil);
                        params.put("Soil weight",soilwe);
                        params.put("Region",reg);
                        params.put("Capabilities",capabi);
                        params.put("Rock Type",rockty);
                        params.put("Soil Bearing Capacity",soilb);
                        params.put("Water Depth",watert);
                        params.put("Structure Type",str);
                        params.put("Max Water Flow",maxwa);
                        params.put("Depth Drill",depth);
                        params.put("Maximum Wind",maxwind);
                        params.put(" ANNUAL RAINFALL",annrain);

                        return params;
                    }


                };

                RequestQueue queue = Volley.newRequestQueue(ml.this);
                queue.add(stringRequest);

            }
        });

            }



}


