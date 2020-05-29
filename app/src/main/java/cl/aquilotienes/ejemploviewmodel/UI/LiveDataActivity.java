package cl.aquilotienes.ejemploviewmodel.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import cl.aquilotienes.ejemploviewmodel.R;
import cl.aquilotienes.ejemploviewmodel.Usuario;
import cl.aquilotienes.ejemploviewmodel.viewmodel.LiveDataUsuarioViewModel;

public class LiveDataActivity extends AppCompatActivity {

    private TextView tvTextoLV;
    private Button bntSalvarLV;
    private int numero = 0;
    private LiveDataUsuarioViewModel liveDataUsuarioViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        configView();

    }

    public void configView() {
        liveDataUsuarioViewModel = ViewModelProviders.of(this).get(LiveDataUsuarioViewModel.class);

        tvTextoLV = (TextView) findViewById(R.id.tv_texto_lv);
        bntSalvarLV = (Button) findViewById(R.id.btn_salvar_lv);

        bntSalvarLV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numero == 0){
                    Usuario usuario = new Usuario();
                    usuario.setNombre("aaaaa");
                    usuario.setEdad("33");
                    liveDataUsuarioViewModel.addUsuario(usuario);
                }
                if(numero == 1){
                    Usuario usuario = new Usuario();
                    usuario.setNombre("bbbbb");
                    usuario.setEdad("44");
                    liveDataUsuarioViewModel.addUsuario(usuario);
                }
                if(numero == 2){
                    Usuario usuario = new Usuario();
                    usuario.setNombre("ccccc");
                    usuario.setEdad("55");
                    liveDataUsuarioViewModel.addUsuario(usuario);
                }
                numero++;

            }
        });


        final Observer<List<Usuario>> listObserver = new Observer<List<Usuario>>() {
            @Override
            public void onChanged(List<Usuario> usuarioList) {
                String texto = "";
                for(int i = 0; i < usuarioList.size(); i++){
                    texto +=    usuarioList.get(i).getNombre() + " " +
                                usuarioList.get(i).getEdad() + "\n";
                }
                tvTextoLV.setText(texto);
            }
        };

        liveDataUsuarioViewModel.getUsuarioList().observe(this, listObserver);
    }


}