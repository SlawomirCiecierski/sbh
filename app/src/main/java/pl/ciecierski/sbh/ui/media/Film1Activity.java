package pl.ciecierski.sbh.ui.media;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.webkit.WebView;

import pl.ciecierski.sbh.R;

public class Film1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_filmormusic);
        WebView webView = findViewById(R.id.webviewfilmormusic);
        webView.loadUrl("https://youtu.be/JD5ths5Jusg");
    }

    @Override
    protected void onStop() {
        super.onStop();
        setContentView(R.layout.activity_main);
    }

}
