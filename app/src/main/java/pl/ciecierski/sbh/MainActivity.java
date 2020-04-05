
package pl.ciecierski.sbh;

import android.app.AlertDialog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
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
import androidx.appcompat.widget.Toolbar;

import pl.ciecierski.sbh.eternalservices.ProcessMainClass;
import pl.ciecierski.sbh.eternalservices.restarter.RestartServiceBroadcastReceiver;
import pl.ciecierski.sbh.ui.media.Film1Activity;
import pl.ciecierski.sbh.ui.media.Film2Activity;
import pl.ciecierski.sbh.ui.media.Film3Activity;
import pl.ciecierski.sbh.ui.media.Fotografia1Activity;
import pl.ciecierski.sbh.ui.media.Fotografia2Activity;
import pl.ciecierski.sbh.ui.media.Fotografia3Activity;
import pl.ciecierski.sbh.ui.media.Fotografia4Activity;
import pl.ciecierski.sbh.ui.media.Fotografia5Activity;
import pl.ciecierski.sbh.ui.media.Fotografia6Activity;
import pl.ciecierski.sbh.ui.media.Muzyka1Activity;
import pl.ciecierski.sbh.ui.muzea.MapsActivity;


public class MainActivity extends AppCompatActivity {

    public final static String FRAI = "first_run_after_installation";
    public final static String FRMA = "first_run_mainactivity";
    public static boolean isRun;
    //    private static final int notification1Id = 1964;
    private AppBarConfiguration mAppBarConfiguration;
    public static String txtBibl;
    public static String txtMO;
    public static String txtIPG;
    public static String txtMWL;
    public static String mapsTitle;
    public static double lat;
    public static double lng;

    //LOKALIZACJA
    private FusedLocationProviderClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
/*
todo w zalezności od wybranego działu skontruować menu z różnymi fragmentami
 */
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_fotografie,
                R.id.nav_ciekawostki,
                R.id.nav_autor,
                R.id.nav_muzea)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

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
                                MainActivity.txtMWL = txtD;
                            } catch (RuntimeException e) {
                                txtD = "Do prawidłowego odczytu odległości aplikacja wymaga dostępu do lokalizacji Twojego urządzenia!";
                                MainActivity.txtMWL = txtD;
                            }

                            try {
                                txtD = "Odległość ";
                                txtD += String.valueOf((int) task.getResult().distanceTo(locationMO));
                                txtD += " m";
                                MainActivity.txtMO = txtD;
                            } catch (RuntimeException e) {
                                txtD = "Odległość: brak danych";
                                MainActivity.txtMO = txtD;
                            }

                            try {
                                txtD = "Odległość ";
                                txtD += String.valueOf((int) task.getResult().distanceTo(locationIPG));
                                txtD += " m";
                                MainActivity.txtIPG = txtD;
                            } catch (RuntimeException e) {
                                txtD = "Odległość: brak danych";
                                MainActivity.txtIPG = txtD;
                            }

                            try {
                                txtD = "Odległość ";
                                txtD += String.valueOf((int) task.getResult().distanceTo(locationBibl));
                                txtD += " m";
                                MainActivity.txtBibl = txtD;
                            } catch (RuntimeException e) {
                                txtD = "Odległość: brak danych";
                                MainActivity.txtBibl = txtD;
                            }

                        }
                    }
                });

        /*
        przy pierwszym użyciu aplikacji (po zainstalowaniu) wyświetla komunikat powitalny
         */
        new FirstWelcomeDialog().showFirstWelcomeDialog();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


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

    @Override
    protected void onRestart() {
//todo tutaj destination powinien być fragment media
        super.onRestart();
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
                msg += "\nAplikacja ma za zadanie przybliżyć ważne wydarzenia z życia Bydgoszczy, które przez lata popadły w zapomnienie. Piękna historia miasta, nietuzinkowe postaci – przyjrzyj się uważnie tym unikalnym zdjęciom: to wszystko w aplikacji pod nazwą: Sekrety Bydgoskiej Historii.\n\n" + "\t\t\t\t\t\t\t\tZespół Autorski";
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
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
                msg = "Aplikacja przybliży Ci ważne wydarzenia z życia Bydgoszczy, które przez lata popadły w zapomnienie. \n\n" + "\t\t\t\t\t\t\t\tZespół Autorski";
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle(title);
                dialogBuilder.setMessage(msg);
                dialogBuilder.show();

                SharedPreferences.Editor editorFRMA = preferencesFirstRunMainActivity.edit();
                editorFRMA.putBoolean(FRMA, false);
                editorFRMA.apply();
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            RestartServiceBroadcastReceiver.scheduleJob(getApplicationContext());
        } else {
            ProcessMainClass bck = new ProcessMainClass();
            bck.launchService(getApplicationContext());
        }
    }


    public void onClickSmallFotografia1(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia1Activity.class));
    }

    public void onClickSmallFotografia2(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia2Activity.class));
    }

    public void onClickSmallFotografia3(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia3Activity.class));
    }

    public void onClickSmallFotografia4(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia4Activity.class));
    }

    public void onClickSmallFotografia5(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia5Activity.class));
    }

    public void onClickSmallFotografia6(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia6Activity.class));
    }

    public void onClickBtnFilm1(View view) {
        isRun = true;
        startActivity(new Intent(this, Film1Activity.class));
    }

    public void onClickBtnFilm2(View view) {
        isRun = true;
        startActivity(new Intent(this, Film2Activity.class));
    }

    public void onClickBtnFilm3(View view) {
        isRun = true;
        startActivity(new Intent(this, Film3Activity.class));
    }

    public void onClickBtnMuzyka1(View view) {
        isRun = true;
        startActivity(new Intent(this, Muzyka1Activity.class));
    }


    public void onClickBtnMapsMWL(View view) {
        isRun = true;
        lat = 53.142302;
        lng = 18.020765;
        mapsTitle = "Muzeum Wojsk Lądowych";
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void onClickBtnMapsMO(View view) {
        isRun = true;
        lat = 53.122532;
        lng = 17.997541;
        mapsTitle = "Muzeum Okręgowe w Bydgoszczy";
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void onClickBtnMapsIPG(View view) {
        isRun = true;
        lat = 53.128717;
        lng = 18.008444;
        mapsTitle = "Izba Pamięci Adama Grzymały Siedleckiego";
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void onClickBtnMapsBibl(View view) {
        isRun = true;
        lat = 53.120912;
        lng = 18.000407;
        mapsTitle = "Wojewódzka i Miejska Biblioteka";
        startActivity(new Intent(this, MapsActivity.class));
    }

}
