package pl.ciecierski.sbh.ui.muzea;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import pl.ciecierski.sbh.R;

import static pl.ciecierski.sbh.MainActivity.lat;
import static pl.ciecierski.sbh.MainActivity.lng;
import static pl.ciecierski.sbh.MainActivity.mapsTitle;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in any Muzeum and move the camera
        LatLng muzeum = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(muzeum).title(mapsTitle));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(muzeum));
    }

}
