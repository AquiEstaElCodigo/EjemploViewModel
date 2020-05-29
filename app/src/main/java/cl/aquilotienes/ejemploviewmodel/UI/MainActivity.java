package cl.aquilotienes.ejemploviewmodel.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cl.aquilotienes.ejemploviewmodel.R;

public class MainActivity extends AppCompatActivity {

    Button btnAbrirViewModel, btnIngresarUsuario, btnLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbrirViewModel = (Button) findViewById(R.id.btn_viewmodel_activity);
        btnIngresarUsuario = (Button) findViewById(R.id.btn_ingresar_usuario);
        btnLiveData = (Button) findViewById(R.id.btn_livedata);

    }

    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_viewmodel_activity:
                startActivity(new Intent(getApplicationContext(), ViewModelSumarActivity.class));
                break;

            case R.id.btn_ingresar_usuario:
                startActivity(new Intent(getApplicationContext(), ViewModelUsuarioActivity.class));
                break;

            case R.id.btn_livedata:
                startActivity(new Intent(getApplicationContext(), LiveDataActivity.class));
                break;

        }


    }


}
