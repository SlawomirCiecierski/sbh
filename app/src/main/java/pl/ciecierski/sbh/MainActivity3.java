
package pl.ciecierski.sbh;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;


import pl.ciecierski.sbh.ui.media.Film1Activity3;

import pl.ciecierski.sbh.ui.media.Film2Activity3;

import pl.ciecierski.sbh.ui.media.Film3Activity3;
import pl.ciecierski.sbh.ui.media.Film4Activity3;
import pl.ciecierski.sbh.ui.media.Film5Activity3;
import pl.ciecierski.sbh.ui.media.Film6Activity3;

import pl.ciecierski.sbh.ui.media.Fotografia31Activity3;
import pl.ciecierski.sbh.ui.media.Fotografia32Activity3;
import pl.ciecierski.sbh.ui.media.Fotografia33Activity3;
import pl.ciecierski.sbh.ui.media.Fotografia34Activity3;
import pl.ciecierski.sbh.ui.media.Fotografia35Activity3;
import pl.ciecierski.sbh.ui.media.Fotografia36Activity3;
import pl.ciecierski.sbh.ui.media.Fotografia37Activity3;

import pl.ciecierski.sbh.ui.media.Muzyka1Activity3;
import pl.ciecierski.sbh.ui.media.Web1Activity3;
import pl.ciecierski.sbh.ui.media.Web2Activity3;
import pl.ciecierski.sbh.ui.media.Web3Activity3;
import pl.ciecierski.sbh.ui.media.Www3GithubActivity;
import pl.ciecierski.sbh.ui.muzea.MapsActivity;


public class MainActivity3 extends AppCompatActivity {

    public final static String FRAI = "first_run_after_installation";
    public final static String FRMA = "first_run_mainactivity";
    public static boolean isRun;
//    private static final int notification2Id = 1963;
    private AppBarConfiguration mAppBarConfiguration3;
    public static String txtBibl;
    public static String txtMO;
    public static String txtIPG;
    public static String txtMWL;

    //LOKALIZACJA
    private FusedLocationProviderClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_main);

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

        DrawerLayout drawer3 = findViewById(R.id.drawer_layout3);
        NavigationView navigationView3 = findViewById(R.id.nav_view3);
/*
todo w zalezności od wybranego działu skontruować menu z różnymi fragmentami
 */
        mAppBarConfiguration3 = new AppBarConfiguration.Builder(
                R.id.nav_home3,
                R.id.nav_fotografie3,
                R.id.nav_ciekawostki3,
                R.id.nav_autor3,
                R.id.nav_muzea3)
                .setDrawerLayout(drawer3)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment3);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration3);
        NavigationUI.setupWithNavController(navigationView3, navController);



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
                                MainActivity3.txtMWL = txtD;
                            } catch (RuntimeException e) {
                                txtD = "Do prawidłowego odczytu odległości aplikacja wymaga dostępu do lokalizacji Twojego urządzenia!";
                                MainActivity.txtMWL = txtD;
                            }

                            try {
                                txtD = "Odległość ";
                                txtD += String.valueOf((int) task.getResult().distanceTo(locationMO));
                                txtD += " m";
                                MainActivity3.txtMO = txtD;
                            } catch (RuntimeException e) {
                                txtD = "Odległość: brak danych";
                                MainActivity.txtMO = txtD;
                            }

                            try {
                                txtD = "Odległość ";
                                txtD += String.valueOf((int) task.getResult().distanceTo(locationIPG));
                                txtD += " m";
                                MainActivity3.txtIPG = txtD;
                            } catch (RuntimeException e) {
                                txtD = "Odległość: brak danych";
                                MainActivity.txtIPG = txtD;
                            }

                            try {
                                txtD = "Odległość ";
                                txtD += String.valueOf((int) task.getResult().distanceTo(locationBibl));
                                txtD += " m";
                                MainActivity3.txtBibl = txtD;
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
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment3);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration3)
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
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity3.this);
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
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity3.this);
                dialogBuilder.setTitle(title);
                dialogBuilder.setMessage(msg);
                dialogBuilder.show();

                SharedPreferences.Editor editorFRMA = preferencesFirstRunMainActivity.edit();
                editorFRMA.putBoolean(FRMA, false);
                editorFRMA.apply();
            }
        }
    }

//todo powiązac metody z xmlami
    public void onClickSmallFotografia31(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia31Activity3.class));
    }

    public void onClickSmallFotografia32(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia32Activity3.class));
    }

    public void onClickSmallFotografia33(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia33Activity3.class));
    }

    public void onClickSmallFotografia34(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia34Activity3.class));
    }

    public void onClickSmallFotografia35(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia35Activity3.class));
    }

    public void onClickSmallFotografia36(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia36Activity3.class));
    }

    public void onClickSmallFotografia37(View view) {
        isRun = true;
        startActivity(new Intent(this, Fotografia37Activity3.class));
    }

    public void onClickBtnFilm31(View view) {
        isRun = true;
        startActivity(new Intent(this, Film1Activity3.class));
    }

    public void onClickBtnFilm32(View view) {
        isRun = true;
        startActivity(new Intent(this, Film2Activity3.class));
    }

    public void onClickBtnFilm33(View view) {
        isRun = true;
        startActivity(new Intent(this, Film3Activity3.class));
    }

    public void onClickBtnFilm34(View view) {
        isRun = true;
        startActivity(new Intent(this, Film4Activity3.class));
    }

    public void onClickBtnFilm35(View view) {
        isRun = true;
        startActivity(new Intent(this, Film5Activity3.class));
    }

    public void onClickBtnFilm36(View view) {
        isRun = true;
        startActivity(new Intent(this, Film6Activity3.class));
    }

    public void onClickBtnMuzyka31(View view) {
        isRun = true;
        startActivity(new Intent(this, Muzyka1Activity3.class));
    }

    public void onClickBtnWeb31(View view) {
        isRun = true;
        startActivity(new Intent(this, Web1Activity3.class));
    }

    public void onClickBtnWeb32(View view) {
        isRun = true;
        startActivity(new Intent(this, Web2Activity3.class));
    }

    public void onClickBtnWeb33(View view) {
        isRun = true;
        startActivity(new Intent(this, Web3Activity3.class));
    }



    /*
link do githuba w treści autora
*/
    public void onClickWeb3GitHub(View view){
        isRun = true;
        startActivity(new Intent(this, Www3GithubActivity.class));
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
