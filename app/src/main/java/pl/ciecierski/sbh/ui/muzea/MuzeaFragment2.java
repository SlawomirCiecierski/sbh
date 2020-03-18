package pl.ciecierski.sbh.ui.muzea;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import pl.ciecierski.sbh.R;

import static pl.ciecierski.sbh.R.id.bibl_distance;
import static pl.ciecierski.sbh.R.id.ipg_distance;
import static pl.ciecierski.sbh.R.id.mo_distance;
import static pl.ciecierski.sbh.R.id.mwl_distance;


public class MuzeaFragment2 extends Fragment {


private LocalizationsViewModel2 localizationsViewModel2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
    localizationsViewModel2= ViewModelProviders.of(this).get(LocalizationsViewModel2.class);
    View root = inflater.inflate(R.layout.fragment2_muzea, container, false);


        final TextView txtVDistanceToBibl = (TextView) root.findViewById(bibl_distance);
        final TextView txtVDistanceToMWL = (TextView) root.findViewById(mwl_distance);
        final TextView txtVDistanceToMO = (TextView) root.findViewById(mo_distance);
        final TextView txtVDistanceToIPG = (TextView) root.findViewById(ipg_distance);
//this<->getViewLifecycleOwner()
        localizationsViewModel2.getTextBibl().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtVDistanceToBibl.setText(s);
            }
        });

        localizationsViewModel2.getTextIPG().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtVDistanceToIPG.setText(s);
            }
        });

        localizationsViewModel2.getTextMO().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtVDistanceToMO.setText(s);
            }
        });

        localizationsViewModel2.getTextMWL().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtVDistanceToMWL.setText(s);
            }
        });

        return root;

    }


}