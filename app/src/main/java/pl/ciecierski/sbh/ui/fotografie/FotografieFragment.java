package pl.ciecierski.sbh.ui.fotografie;

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


//todo po załadowaniu statycznym layoutu fragment_fotografie
// (posłużyć się navigation) tu można zmienić na inny
//        fragment np:
//        return inflater.inflate(R.layout.fragment_muzea, container, false);
        ImageView image1View=(ImageView) container.findViewById(R.id.image1);

//        image1View.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClickFotografia1(View v) {
//
//
//               return  inflater.inflate(R.layout.fragment_fotografia1, container, false);
//            }
//        });



        return inflater.inflate(R.layout.fragment_fotografie, container, false);

    }



}