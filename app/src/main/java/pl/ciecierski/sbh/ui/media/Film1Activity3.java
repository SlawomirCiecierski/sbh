package pl.ciecierski.sbh.ui.media;


import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import pl.ciecierski.sbh.R;

public class Film1Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//SEKRET ENIGMY cały film
        setContentView(R.layout.activity_film_or_music_or_web);
        WebView webView = findViewById(R.id.webview_film_or_music_or_web);
        webView.loadUrl("https://youtu.be/rGRu-D8j6ts");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        this.onBackPressed();

    }
}
