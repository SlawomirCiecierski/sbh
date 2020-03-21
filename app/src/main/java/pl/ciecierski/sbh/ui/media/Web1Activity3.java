package pl.ciecierski.sbh.ui.media;


import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import pl.ciecierski.sbh.R;

public class Web1Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_film_or_music_or_web);
        WebView webView = findViewById(R.id.webview_film_or_music_or_web);
        webView.loadUrl("https://www.bydgoszcz.pl/aktualnosci/tresc/marian-rejewski-uhonorowany-w-krakowie/");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        this.onBackPressed();

    }
}
