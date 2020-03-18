package pl.ciecierski.sbh.ui.media;

import androidx.appcompat.app.AppCompatActivity;

import pl.ciecierski.sbh.R;

import android.os.Bundle;

import static pl.ciecierski.sbh.MainActivity.isRun;

public class Fotografia1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotografia1);
        isRun=true;
    }


    @Override
    protected void onStop() {

        super.onStop();
        System.gc();
    }
}
