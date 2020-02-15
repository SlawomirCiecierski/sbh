package pl.ciecierski.sbh.ui.media;


import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import android.webkit.WebView;

import pl.ciecierski.sbh.R;

public class Muzyka1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_film_or_music);
        WebView webView = findViewById(R.id.webview_film_or_music);
        webView.loadUrl("https://soundcloud.com/ciecierski/sets/bydgoszcz100");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        this.onBackPressed();
    }

}
