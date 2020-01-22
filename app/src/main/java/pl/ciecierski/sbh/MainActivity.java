/*
todo wersja 5 do testowania wewnętrznego v.1.0.5
 */

//todo obrazki 1200 px wysokość

package pl.ciecierski.sbh;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import pl.ciecierski.sbh.ui.fotografie.Fotografia1Activity;
import pl.ciecierski.sbh.ui.fotografie.Fotografia2Activity;
import pl.ciecierski.sbh.ui.fotografie.Fotografia3Activity;
import pl.ciecierski.sbh.ui.fotografie.Fotografia4Activity;
import pl.ciecierski.sbh.ui.fotografie.Fotografia5Activity;
import pl.ciecierski.sbh.ui.fotografie.Fotografia6Activity;

import static pl.ciecierski.sbh.sections.RandomDialogBySections.showRandomDialogBySection;
import static pl.ciecierski.sbh.sections.Sections.RETURN_TO_POLAND;
import static pl.ciecierski.sbh.ui.toasts.VersionToast.showVersionToast;


public class MainActivity extends AppCompatActivity {

    public final static String FRAI = "first_run_after_installation";
    public final static String FRMA = "first_run_mainactivity";
    public static boolean isRun;
    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
//-----------
//       todo toasty do modyfikacji
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showVersionToast(view);
            }
        });

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
        przy pierwszym użyciu aplikacji wyświetla komunikat powitalny
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
/*
todo utworzyć case do menu - wybór tematu/działu
1. 1920
2. kwiecień
3. ?
 */
        if (id == R.id.action_witaj) {
            new HistoricalDialog().showCzyWieszZe();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /*
    Dialogs implementation start
     */
    private class FirstWelcomeDialog {
        void showFirstWelcomeDialog() {
//            wykorzystanie preferences do wykrycia pierwszego użycia aplikacji
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
                msg = "Aplikacja ma za zadanie przybliżyć ważne wydarzenia z życia Bydgoszczy, które przez lata popadły w zapomnienie. Piękna historia miasta, nietuzinkowe postaci – przyjrzyj się uważnie tym unikalnym zdjęciom.\n\n" + "\t\t\t\t\t\t\t\tKrzysztof Drozdowski";
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

    private class HistoricalDialog {
        void showCzyWieszZe() {

            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
            dialogBuilder.setTitle("Czy wiesz, że..");
            dialogBuilder.setMessage(showRandomDialogBySection(RETURN_TO_POLAND));
            dialogBuilder.setIconAttribute(android.R.attr.alertDialogIcon);
            dialogBuilder.show();
        }
    }

    public void onClickSmallFotografia1(View view) {
        isRun=true;
        startActivity(new Intent(this, Fotografia1Activity.class));
    }

    public void onClickSmallFotografia2(View view) {
        isRun=true;
        startActivity(new Intent(this, Fotografia2Activity.class));
    }

    public void onClickSmallFotografia3(View view) {
        isRun=true;
        startActivity(new Intent(this, Fotografia3Activity.class));
    }

    public void onClickSmallFotografia4(View view) {
        isRun=true;
        startActivity(new Intent(this, Fotografia4Activity.class));
    }

    public void onClickSmallFotografia5(View view) {
        isRun=true;
        startActivity(new Intent(this, Fotografia5Activity.class));
    }

    public void onClickSmallFotografia6(View view) {
        isRun=true;
        startActivity(new Intent(this, Fotografia6Activity.class));
    }

}
