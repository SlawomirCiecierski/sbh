package pl.ciecierski.sbh.ui.fotografie;

import androidx.appcompat.app.AppCompatActivity;

import pl.ciecierski.sbh.MainActivity;
import pl.ciecierski.sbh.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static pl.ciecierski.sbh.MainActivity.isRun;

public class Fotografia1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotografia1);
        isRun=true;
    }

    public void onClickLargeImage(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onStop() {

        super.onStop();
        System.gc();
    }
}
