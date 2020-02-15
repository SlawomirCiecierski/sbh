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
import static pl.ciecierski.sbh.R.id.mwl_distance;
import static pl.ciecierski.sbh.R.id.mo_distance;
import static pl.ciecierski.sbh.R.id.ipg_distance;


public class MuzeaFragment extends Fragment {


private LocalizationsViewModel localizationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
    localizationsViewModel= ViewModelProviders.of(this).get(LocalizationsViewModel.class);
    View root = inflater.inflate(R.layout.fragment_muzea, container, false);


        final TextView txtVDistanceToBibl = (TextView) root.findViewById(bibl_distance);
        final TextView txtVDistanceToMWL = (TextView) root.findViewById(mwl_distance);
        final TextView txtVDistanceToMO = (TextView) root.findViewById(mo_distance);
        final TextView txtVDistanceToIPG = (TextView) root.findViewById(ipg_distance);

        localizationsViewModel.getTextBibl().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtVDistanceToBibl.setText(s);
            }
        });

        localizationsViewModel.getTextIPG().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtVDistanceToIPG.setText(s);
            }
        });

        localizationsViewModel.getTextMO().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtVDistanceToMO.setText(s);
            }
        });

        localizationsViewModel.getTextMWL().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                txtVDistanceToMWL.setText(s);
            }
        });

        return root;

    }


}