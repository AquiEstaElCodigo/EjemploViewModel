package cl.aquilotienes.ejemploviewmodel.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cl.aquilotienes.ejemploviewmodel.R;
import cl.aquilotienes.ejemploviewmodel.Operacion;
import cl.aquilotienes.ejemploviewmodel.viewmodel.SumarViewModel;


public class ViewModelSumarActivity extends AppCompatActivity {

    private TextView tvSumar, tvSumarViewModel;
    private Button btnSumar;
    private int numero;
    private SumarViewModel sumarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_sumar);

        configView();
    }

    private void configView() {

        sumarViewModel = ViewModelProviders.of(this).get(SumarViewModel.class);

        tvSumar = (TextView) findViewById(R.id.tv_sumar);
        tvSumarViewModel = (TextView) findViewById(R.id.tv_suma_viewmodel);

        tvSumar.setText("" + numero);
        tvSumarViewModel.setText("" + sumarViewModel.getResultado());

        btnSumar = (Button) findViewById(R.id.btn_sumar);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero = Operacion.realizarSuma(numero);
                tvSumar.setText("" + numero);
                sumarViewModel.setResultado(Operacion.realizarSuma(sumarViewModel.getResultado()));
                tvSumarViewModel.setText("" + sumarViewModel.getResultado());
            }
        });

    }
}
