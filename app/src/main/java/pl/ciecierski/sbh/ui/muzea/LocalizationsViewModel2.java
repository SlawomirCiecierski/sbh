package pl.ciecierski.sbh.ui.muzea;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import static pl.ciecierski.sbh.MainActivity.txtBibl;
import static pl.ciecierski.sbh.MainActivity.txtIPG;
import static pl.ciecierski.sbh.MainActivity.txtMO;
import static pl.ciecierski.sbh.MainActivity.txtMWL;


public class LocalizationsViewModel2 extends ViewModel {

    private MutableLiveData<String> txtDistanceToMWL;
    private MutableLiveData<String> txtDistanceToMO;
    private MutableLiveData<String> txtDistanceToIPG;
    private MutableLiveData<String> txtDistanceToBibl;

    public LocalizationsViewModel2() {

        txtDistanceToBibl = new MutableLiveData<>();
        txtDistanceToBibl.setValue(txtBibl);
        txtDistanceToMO = new MutableLiveData<>();
        txtDistanceToMO.setValue(txtIPG);
        txtDistanceToIPG = new MutableLiveData<>();
        txtDistanceToIPG.setValue(txtMO);
        txtDistanceToMWL = new MutableLiveData<>();
        txtDistanceToMWL.setValue(txtMWL);
    }

    public LiveData<String> getTextMO() {
        return txtDistanceToMO;
    }

    public LiveData<String> getTextIPG() {
        return txtDistanceToIPG;
    }

    public LiveData<String> getTextBibl() {
        return txtDistanceToBibl;
    }

    public LiveData<String> getTextMWL() {
        return txtDistanceToMWL;
    }


}
