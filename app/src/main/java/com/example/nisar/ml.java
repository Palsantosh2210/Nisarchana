package com.example.nisar;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ml extends AppCompatActivity {
    AutoCompleteTextView structure,flood;
    TextInputEditText soiltypeh,soilweighth ,regionh,capabilitiesh,rocktypeh,waterdepthh,maxwaterflowh,magnitudeh,depthh,stormh;
    TextInputLayout soiltype,soilweight ,region,capabilities,rocktype,soilbearing,waterdepth,dropdown,maxwaterflow,magnitude,depth,storm,dropdown1;
    Button PREDICT ;
    String item1,item2;

    String[] item={"Bridge", "Dam","Building"};
     AutoCompleteTextView autoCompleteTextView;

    String[] item3={"Yes", "No"};
    ArrayAdapter<String> adapterItems;
    ArrayList<String> spinnerList;
    double lat ;
    double longi ;
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

        soiltypeh=findViewById(R.id.soiltypeh);
        soilweighth=findViewById(R.id.soilweighth);
        regionh=findViewById(R.id.regionh);
        capabilitiesh=findViewById(R.id.capabilitiesh);
        rocktypeh=findViewById(R.id.rocktypeh);
        waterdepthh=findViewById(R.id.waterdepthh);
        maxwaterflowh=findViewById(R.id.maxwaterflowh);
        magnitudeh=findViewById(R.id.magnitudeh);
        depthh=findViewById(R.id.depthh);
        stormh=findViewById(R.id.stormh);

        soiltype=findViewById(R.id.soiltype);
        soilweight=findViewById(R.id.soilweight);
        region=findViewById(R.id.region);
        capabilities=findViewById(R.id.capabilities);
        rocktype=findViewById(R.id.rocktype);
        waterdepth=findViewById(R.id.waterdepth);
        maxwaterflow=findViewById(R.id.maxwaterflow);
        magnitude=findViewById(R.id.magnitude);
        depth=findViewById(R.id.depth);
        storm=findViewById(R.id.storm);





        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // method to get the location
      //  getLastLocation();

        spinnerList=new ArrayList<>();
        adapterItems=new ArrayAdapter<String>(ml.this, android.R.layout.simple_spinner_dropdown_item,spinnerList);

        structure= findViewById(R.id.auto_complete_txt2);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,item);
        structure.setAdapter(adapterItems);
        structure= findViewById(R.id.auto_complete_txt2);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,item);
        structure.setAdapter(adapterItems);

        flood= findViewById(R.id.auto_complete_txt1);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,item3);
        flood.setAdapter(adapterItems);
        flood= findViewById(R.id.auto_complete_txt1);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,item3);
        flood.setAdapter(adapterItems);
        structure.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item= adapterView.getItemAtPosition(i).toString();
                item1= item;
                //  Toast.makeText(Hiring.this, "+ item"+ item, Toast.LENGTH_SHORT).show();
            }
        });
        flood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item3= adapterView.getItemAtPosition(i).toString();
                item2= item3;
                //  Toast.makeText(Hiring.this, "+ item"+ item, Toast.LENGTH_SHORT).show();
            }
        });
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            double len =  jsonObject.getDouble("Length");
                            double Width =  jsonObject.getDouble("Width");
                            double Breadth =  jsonObject.getDouble("Breadth");
                            double Height =  jsonObject.getDouble("Height");
                            double Weight =  jsonObject.getDouble("Weight");

                            //pass data by intent ok



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

            String lat1 =Double.toString(lat);
            String long1 =Double.toString(longi);

            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String,String>();
                 params.put("Latitude",lat1);
                params.put("Longitude",long1);
                //add your param here use multipe param for mul param
                params.put("Soiltype",soiltypeh.getText().toString().trim());
                params.put("Soilweight",soiltypeh.getText().toString().trim());
                params.put("Region",regionh.getText().toString().trim());
                params.put("Capabilities",capabilitiesh.getText().toString().trim());
                params.put("Rocktype",rocktypeh.getText().toString().trim());
                params.put("Waterdepth",waterdepthh.getText().toString().trim());
                params.put("Structuretype",structure.getText().toString().trim());
                params.put("maxwaterflow",maxwaterflowh.getText().toString().trim());
                params.put("Magnitude",magnitudeh.getText().toString().trim());
                params.put("Depth",depthh.getText().toString().trim());
                params.put("Storm",stormh.getText().toString().trim());
                params.put("Flood",flood.getText().toString().trim());

                return params;
            }


        };

        RequestQueue queue = Volley.newRequestQueue(ml.this);
        queue.add(stringRequest);

    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        // check if permissions are given
        if (checkPermissions()) {

            // check if location is enabled
            if (isLocationEnabled()) {

                // getting last
                // location from
                // FusedLocationClient
                // object
                mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();
                        } else {
                            lat = location.getLatitude();
                            longi  = location.getLongitude() ;
                        }
                    }
                });
            } else {
                Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            // if permissions aren't available,
            // request for permissions
            requestPermissions();
        }
    }


    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        // Initializing LocationRequest
        // object with appropriate methods
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        // setting LocationRequest
        // on FusedLocationClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
    }

    private LocationCallback mLocationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            lat =  mLastLocation.getLatitude();
            longi =  mLastLocation.getLongitude();
        }
    };

    // method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        // If we want background location
        // on Android 10.0 and higher,
        // use:
        // ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    // method to request for permissions
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    // method to check
    // if location is enabled
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    // If everything is alright then
    @Override
    public void
    onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }
    }



}



