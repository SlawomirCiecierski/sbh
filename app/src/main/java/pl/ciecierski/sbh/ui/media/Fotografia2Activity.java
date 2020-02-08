package pl.ciecierski.sbh.ui.media;

import androidx.appcompat.app.AppCompatActivity;

import pl.ciecierski.sbh.MainActivity;
import pl.ciecierski.sbh.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Fotografia2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotografia2);
    }

    public void onClickLargeImage(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}
