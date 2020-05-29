package cl.aquilotienes.ejemploviewmodel.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import cl.aquilotienes.ejemploviewmodel.Usuario;

public class LiveDataUsuarioViewModel extends ViewModel {

    private MutableLiveData<List<Usuario>> listMutableLiveData;
    private List<Usuario> usuarioList;

    public LiveData<List<Usuario>> getUsuarioList(){

        if(listMutableLiveData == null){
            listMutableLiveData = new MutableLiveData<List<Usuario>>();
            usuarioList = new ArrayList<>();
        }

        return listMutableLiveData;
    }

    public void addUsuario(Usuario usuario){

        usuarioList.add(usuario);
        listMutableLiveData.setValue(usuarioList);
    }


}
