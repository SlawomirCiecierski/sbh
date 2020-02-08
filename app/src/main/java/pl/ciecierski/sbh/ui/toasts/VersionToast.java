/*
toasty do modyfikacji
już nie będą pokazywać randomowych ciekawostek
 */
package pl.ciecierski.sbh.ui.toasts;


import android.view.View;
import android.widget.Toast;


public class VersionToast {

    public static void showVersionToast(View view) {

        Toast toast = Toast.makeText(view.getContext(), "Sekrety Bydgoskiej Historii wersja 1.2.18", Toast.LENGTH_SHORT);
        toast.show();
    }
}
