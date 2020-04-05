
package pl.ciecierski.sbh;

import android.app.AlertDialog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import pl.ciecierski.sbh.ui.media.Film1Activity2;
import pl.ciecierski.sbh.ui.media.Film2Activity2;
import pl.ciecierski.sbh.ui.media.Film3Activity2;
import pl.ciecierski.sbh.ui.media.Fotografia22Activity2;
import pl.ciecierski.sbh.ui.media.Fotografia23Activity2;
import pl.ciecierski.sbh.ui.media.Fotografia24Activity2;
import pl.ciecierski.sbh.ui.media.Fotografia25Activity2;
import pl.ciecierski.sbh.ui.media.Fotografia26Activity2;
import pl.ciecierski.sbh.ui.media.Muzyka1Activity2;
import pl.ciecierski.sbh.ui.muzea.MapsActivity;


public class MainActivity2 extends AppCompatActivity {

    public final static String FRAI = "first_run_after_installation";
    public final static String FRMA = "first_run_mainactivity";
    public static boolean isRun;
//    private static final int notification2Id = 1963;
    private AppBarConfiguration mAppBarConfiguration2;
    public static String txtBibl;
    public static String txtMO;
    public static String txtIPG;
    public static String txtMWL;

    //LOKALIZACJA
    private FusedLocationProviderClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

//       Toolbar toolbar = findViewById(R.id.toolbar2);
//       setSupportActionBar(toolbar);

//
//        FloatingActionButton fab2 = findViewById(R.id.fab2);
////-----------
////       todo toasty do modyfikacji
//        fab2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showVersionToast(view);
//            }
//        });

        DrawerLayout drawer2 = findViewById(R.id.drawer_layout2);
        NavigationView navigationView2 = findViewById(R.id.nav_view2);
/*
todo w zalezności od wybranego działu skontruować menu z różnymi fragmentami
 */
        mAppBarConfiguration2 = new AppBarConfiguration.Builder(
                R.id.nav_home2,
                R.id.nav_fotografie2,
                R.id.nav_ciekawostki2,
                R.id.nav_autor2,
                R.id.nav_muzea2)
                .setDrawerLayout(drawer2)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment2);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration2);
        NavigationUI.setupWithNavController(navigationView2, navController);



        /*
        LOKALIZACJA
         */

        final Location locationBibl = new Location("Bibl"); //lokalizacja Biblioteki
        locationBibl.setLongitude(18.000407);
        locationBibl.setLatitude(53.120912);
        locationBibl.setAltitude(50);

        final Location locationMWL = new Location("MWL"); //lokalizacja Muzeum Wojsk Lądowych
//        53.142302, 18.020765
        locationMWL.setLongitude(18.020765);
        locationMWL.setLatitude(53.142302);
        locationMWL.setAltitude(50);

        final Location locationMO = new Location("MO"); //lokalizacja Muzeum Okręgowego
//        53.122532, 17.997541
        locationMO.setLongitude(17.997541);
        locationMO.setLatitude(53.122532);
        locationMO.setAltitude(50);

        final Location locationIPG = new Location("IPG"); //lokalizacja Instytutu Pamięci A.Grzymały
//        53.128717, 18.008444
        locationIPG.setLongitude(18.008444);
        locationIPG.setLatitude(53.128717);
        locationIPG.setAltitude(50);

        client = LocationServices.getFusedLocationProviderClient(this);
        client.getLastLocation()
                .addOnCompleteListener(this, new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        String txtD;
                        if (task != null) {


                            try {
                                txtD = "Odległość ";
                                txtD += String.valueOf((int) task.getResult().distanceTo(locationMWL));
                                txtD += " m";
                                MainActivity2.txtMWL = txtD;
                            } catch (RuntimeException e) {
                                txtD = "Do prawidłowego odczytu odległości aplikacja wymaga dostępu do lokalizacji Twojego urządzenia!";
                                MainActivity.txtMWL = txtD;
                            }

                            try {
                                txtD = "Odległość ";
                                txtD += String.valueOf((int) task.getResult().distanceTo(locationMO));
                                txtD += " m";
                                MainActivity2.txtMO = txtD;
                            } catch (RuntimeException e) {
                                txtD = "Odległość: brak danych";
                                MainActivity.txtMO = txtD;
                            }

                            try {
                                txtD = "Odległość ";
                                txtD += String.valueOf((int) task.getResult().distanceTo(locationIPG));
                                txtD += " m";
                                MainActivity2.txtIPG = txtD;
                            } catch (RuntimeException e) {
                                txtD = "Odległość: brak danych";
                                MainActivity.txtIPG = txtD;
                            }

                            try {
                                txtD = "Odległość ";
                                txtD += String.valueOf((int) task.getResult().distanceTo(locationBibl));
                                txtD += " m";
                                MainActivity2.txtBibl = txtD;
                            } catch (RuntimeException e) {
                                txtD = "Odległość: brak danych";
                                MainActivity.txtBibl = txtD;
                            }

                        }
                    }
                });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment2);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration2)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



/*
todo utworzyć case do menu - wybór tematu/działu
1. 1920
2. 1945
3. REJEWSKI
 */
        int id = item.getItemId();
        switch (id) {
            case R.id.action_wybierz1920:
                isRun = true;
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.action_wybierz1945:
                isRun = true;
                startActivity(new Intent(this, MainActivity2.class));
                return true;
            case R.id.action_wybierz_rejewski:
                isRun = true;
                startActivity(new Intent(this, MainActivity3.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /*
    Dialogs implementation start
     */
    private class FirstWelcomeDialog {
        void showFirstWelcomeDialog() {
//            wykorzystanie shared preferences do wykrycia pierwszego użycia aplikacji
            SharedPreferences preferencesFirstRunAfterInstallation = getPreferences(MODE_PRIVATE);
            boolean firstRunAfterInstallation = preferencesFirstRunAfterInstallation.getBoolean(FRAI, true);
            SharedPreferences preferencesFirstRunMainActivity = getPreferences(MODE_PRIVATE);
            boolean firstRunMainActivity = preferencesFirstRunMainActivity.getBoolean(FRMA, true);

            String title;
            String msg;

            if (firstRunAfterInstallation) {
                title = "Twój pierwszy raz!";
                msg = "Cieszymy się, że zdecydowałeś się skorzystać z tej aplikacji.";
                msg += "\nAplikacja ma za zadanie przybliżyć ważne wydarzenia z życia Bydgoszczy, które przez lata popadły w zapomnienie. Piękna historia miasta, nietuzinkowe postaci – przyjrzyj się uważnie tym unikalnym zdjęciom: to wszystko w aplikacji pod nazwą: Sekrety Bydgoskiej Historii.\n\n" + "\t\t\t\t\t\t\t\tKrzysztof Drozdowski";
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity2.this);
                dialogBuilder.setTitle(title);
                dialogBuilder.setMessage(msg);
                dialogBuilder.show();

                SharedPreferences.Editor editorFRAI = preferencesFirstRunAfterInstallation.edit();
                editorFRAI.putBoolean(FRAI, false);
                editorFRAI.apply();

                SharedPreferences.Editor editorFRMA = preferencesFirstRunMainActivity.edit();
                editorFRMA.putBoolean(FRMA, false);
                editorFRMA.apply();

            } else if (firstRunMainActivity || !isRun) {
                title = "Sekrety Bydgoskiej Historii";
                msg = "Aplikacja ma za zadanie przybliżyć ważne wydarzenia z życia Bydgoszczy, które przez lata popadły w zapomnienie. Piękna historia miasta, nietuzinkowe postaci – przyjrzyj się uważnie tym unikalnym zdjęciom, obejrzyj filmy i wysłuchaj muzyki.\n\n" + "\t\t\t\t\t\t\t\tKrzysztof Drozdowski";
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity2.this);
                dialogBuilder.setTitle(title);
                dialogBuilder.setMessage(msg);
                dialogBuilder.show();

                SharedPreferences.Editor editorFRMA = preferencesFirstRunMainActivity.edit();
                editorFRMA.putBoolean(FRMA, false);
                editorFRMA.apply();
            }
        }
    }


    public void onClickSmallFotografia22(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia22Activity2.class));
    }

    public void onClickSmallFotografia23(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia23Activity2.class));
    }

    public void onClickSmallFotografia24(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia24Activity2.class));
    }

    public void onClickSmallFotografia25(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia25Activity2.class));
    }

    public void onClickSmallFotografia26(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia26Activity2.class));
    }

    public void onClickBtnFilm21(View view) {
        isRun = true;
        startActivity(new Intent(this, Film1Activity2.class));
    }

    public void onClickBtnFilm22(View view) {
        isRun = true;
        startActivity(new Intent(this, Film2Activity2.class));
    }

    public void onClickBtnFilm23(View view) {
        isRun = true;
        startActivity(new Intent(this, Film3Activity2.class));
    }

    public void onClickBtnMuzyka21(View view) {
        isRun = true;
        startActivity(new Intent(this, Muzyka1Activity2.class));
    }


    public void onClickBtnMapsMWL(View view){
        isRun=true;
        MainActivity.lat = 53.142302;
        MainActivity.lng = 18.020765;
        MainActivity.mapsTitle="Muzeum Wojsk Lądowych";
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void onClickBtnMapsMO(View view){
        isRun=true;
        MainActivity.lat=53.122532;
        MainActivity.lng=17.997541;
        MainActivity.mapsTitle="Muzeum Okręgowe w Bydgoszczy";
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void onClickBtnMapsIPG(View view){
        isRun=true;
        MainActivity.lat=53.128717;
        MainActivity.lng=18.008444;
        MainActivity.mapsTitle="Izba Pamięci Adama Grzymały Siedleckiego";
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void onClickBtnMapsBibl(View view){
        isRun=true;
        MainActivity.lat=53.120912;
        MainActivity.lng=18.000407;
        MainActivity.mapsTitle="Wojewódzka i Miejska Biblioteka";
        startActivity(new Intent(this, MapsActivity.class));
    }

}
