package cl.aquilotienes.ejemploviewmodel.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import cl.aquilotienes.ejemploviewmodel.R;
import cl.aquilotienes.ejemploviewmodel.Usuario;
import cl.aquilotienes.ejemploviewmodel.viewmodel.UsusarioViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ViewModelUsuarioActivity extends AppCompatActivity {

    private EditText etNombre, etEdad;
    private Button btnSalvar, btnVer;
    private TextView tvUsuario, tvUsuarioVM;
    private List<Usuario> usuarioList;
    private UsusarioViewModel ususarioViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_usuario);

        configView();
    }

    private void configView() {

        ususarioViewModel = ViewModelProviders.of(this).get(UsusarioViewModel.class);
        usuarioList = new ArrayList<>();

        tvUsuario   =   (TextView) findViewById(R.id.tv_usuario);
        tvUsuarioVM =   (TextView) findViewById(R.id.tv_usuario_vm);
        etNombre    =   (EditText) findViewById(R.id.et_nombre);
        etEdad      =   (EditText) findViewById(R.id.et_edad);
        btnSalvar   =   (Button) findViewById(R.id.btn_salvar);
        btnVer      =   (Button) findViewById(R.id.btn_ver);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario = new Usuario();
                usuario.setNombre(etNombre.getText().toString());
                usuario.setEdad(etEdad.getText().toString());
                usuarioList.add(usuario);
                ususarioViewModel.addUsuario(usuario);
                Toast.makeText(getApplicationContext(), "Datos guardados!",
                        Toast.LENGTH_SHORT).show();

               etNombre.setText("");
               etEdad.setText("");
            }
        });

        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = "";
                for(int i = 0; i < usuarioList.size(); i++)
                    texto += usuarioList.get(i).getNombre() + " "
                            + usuarioList.get(i).getEdad() + "\n";

                tvUsuario.setText(texto);
                texto = "";

                for(Usuario usuario : ususarioViewModel.getUsuarioList())
                    texto += usuario.getNombre() + " " + usuario.getEdad() + "\n";

                tvUsuarioVM.setText(texto);

             }
        });



    }


}
