package pl.ciecierski.sbh.ui.fotografie;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import pl.ciecierski.sbh.R;

public class FotografieFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //---------------
        ImageView img1 = container.findViewById(R.id.image1);
//        img1.setOnClickListener
//                (new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        Intent i = new Intent(this, Fotografia1Fragment.class);
//                        startActivity(i);
////                startActivity(new Intent(this, MainActivity2.class));
////                        setContentView(R.layout.fragment_fotografia1);
//                      return inflater.inflate(R.layout.fragment_fotografia1, container, false);
//                    }
//                });

        //-----------

        return inflater.inflate(R.layout.fragment_fotografie, container, false);
    }


}