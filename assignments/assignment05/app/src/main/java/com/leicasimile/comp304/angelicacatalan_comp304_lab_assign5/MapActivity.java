package com.leicasimile.comp304.angelicacatalan_comp304_lab_assign5;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapNormal = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_normal);
        mapNormal.getMapAsync(this);

        SupportMapFragment mapSatellite = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_satellite);
        mapSatellite.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng campus = new LatLng(-34, 151);


        mMap.addMarker(new MarkerOptions().position(campus).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(campus));
    }
}
