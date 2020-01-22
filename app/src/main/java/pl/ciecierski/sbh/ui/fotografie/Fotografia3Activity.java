package pl.ciecierski.sbh.ui.fotografie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pl.ciecierski.sbh.MainActivity;
import pl.ciecierski.sbh.R;

public class Fotografia3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotografia3);
    }

    public void onClickLargeImage(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}
