package pl.ciecierski.sbh.ui.media;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import pl.ciecierski.sbh.R;

public class Film1Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//W drodze do wolności. Bydgoszcz w 1920 roku
        setContentView(R.layout.activity_film_or_music);
        WebView webView = findViewById(R.id.webview_film_or_music);
        webView.loadUrl("https://youtu.be/HnIS2twdA_0");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        this.onBackPressed();

    }
}
