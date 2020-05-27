package cl.aquilotienes.ejemploviewmodel.viewmodel;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

import cl.aquilotienes.ejemploviewmodel.Usuario;

public class UsusarioViewModel extends ViewModel {

    private List<Usuario> usuarioList;

    public UsusarioViewModel(){

        usuarioList = new ArrayList<>();
    }

    public UsusarioViewModel(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public void addUsuario(Usuario usuario){
        usuarioList.add(usuario);
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
}
