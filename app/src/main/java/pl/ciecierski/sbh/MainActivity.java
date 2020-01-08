/*
todo wersja 5 do testowania wewnętrznego v.1.0.5
 */


package pl.ciecierski.sbh;

import android.app.AlertDialog;
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

import static pl.ciecierski.sbh.sections.RandomDialogBySections.showRandomDialogBySection;
import static pl.ciecierski.sbh.sections.Sections.RETURN_TO_POLAND;
//toasty do modyfikacji
import static pl.ciecierski.sbh.ui.toasts.BydgoszczRandomToast.showBydgoszczRandomToast;


public class MainActivity extends AppCompatActivity {


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

//        toasty do modyfikacji
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBydgoszczRandomToast(view);
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

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
        przy pierwszym użyciu wyświetla komunikat powitalny
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
todo utworzyć case do menu - wybór tematu
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
            SharedPreferences preferences = getPreferences(MODE_PRIVATE);
            boolean firstRun = preferences.getBoolean("first_run", true);

            if (firstRun) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("Łączy nas Bydgoszcz!");
                dialogBuilder.setMessage("Cieszymy się, że zdecydowałeś się skorzystać z tej aplikacji. Życzymy miłego odbioru.");
                AlertDialog dialog = dialogBuilder.create();
                dialog.show();
            }
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("first_run", false);
            editor.apply();
        }
    }

    private class HistoricalDialog {
        void showCzyWieszZe() {

            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
            dialogBuilder.setTitle("Czy wiesz, że..");
            dialogBuilder.setMessage(showRandomDialogBySection(RETURN_TO_POLAND));
            AlertDialog dialog = dialogBuilder.create();
            dialog.show();
        }
    }
    /*
    Dialogs implementation end
    */
}
