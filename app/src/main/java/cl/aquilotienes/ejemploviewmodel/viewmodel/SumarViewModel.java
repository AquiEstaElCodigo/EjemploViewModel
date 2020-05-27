package cl.aquilotienes.ejemploviewmodel.viewmodel;

import androidx.lifecycle.ViewModel;

public class SumarViewModel extends ViewModel {

    private int resultado;

    public SumarViewModel() {
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
