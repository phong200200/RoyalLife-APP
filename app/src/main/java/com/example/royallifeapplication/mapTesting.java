package com.example.royallifeapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapTesting extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 100;
    EditText text;
    TelephonyManager telephonyManager;
    LocationManager locationManager;
    LocationListener locationListener;
    String str;
    Button btnGo;
    LatLng userLatLng;
    double longtitude,latitude;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                userLatLng = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(userLatLng).title("Your Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(userLatLng));
            }
        };
        btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (EditText) findViewById(R.id.edtPlace);
                str = text.getText().toString();
                latitude = getLocation()[1];
                longtitude = getLocation()[0];
                goMap(latitude,longtitude,str);
            }
        });
    }

    private void goMap(double latitude, double longtitude, String str) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/search/"+ str +"/@"
                        + latitude + "," + longtitude + ","+"10z/data=!3m1!4b1"));
        startActivity(intent);
    }

    private double[] getLocation() {
        double[] arrTitude= new double[2];
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            arrTitude[0] = lastLocation.getLongitude();
            arrTitude[1] = lastLocation.getLatitude();
        }
        else{
            for (int i = 0; i < 2; i++) {
                arrTitude[i] = i;
            }
        }
        return arrTitude;
    }
}