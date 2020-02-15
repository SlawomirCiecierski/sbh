package pl.ciecierski.sbh.ui.media;


import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;


import pl.ciecierski.sbh.R;

public class Film3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//makieta Starego Rynku w Bydgoszczy w 1920
        setContentView(R.layout.activity_film_or_music);
        WebView webView = findViewById(R.id.webview_film_or_music);
        webView.loadUrl("https://youtu.be/WfSphW3-hzs");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        this.onBackPressed();

    }
}
