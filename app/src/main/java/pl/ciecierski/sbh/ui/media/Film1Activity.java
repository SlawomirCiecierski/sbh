package pl.ciecierski.sbh.ui.media;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.webkit.WebView;

import pl.ciecierski.sbh.R;

public class Film1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//W drodze do wolności. Bydgoszcz w 1920 roku
        setContentView(R.layout.activity_film_or_music);
        WebView webView = findViewById(R.id.webview_film_or_music);
        webView.loadUrl("https://youtu.be/JD5ths5Jusg");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        this.onBackPressed();

    }
}