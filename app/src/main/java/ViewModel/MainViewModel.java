package ViewModel;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.vm.Inicio;

import java.io.Serializable;

import Model.Usuario;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<String> mutableMensaje;

    private MutableLiveData<Usuario> mUsuario;
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMutableMensaje() {
        if(mutableMensaje == null){
            mutableMensaje = new MutableLiveData<>();
        }
        return mutableMensaje;
    }

    public LiveData<Usuario> getmUsuario() {
        if(mUsuario == null){
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }

    public void login(String usuario, String password){
        if(usuario.equals("pepito") && password.equals(("123") )){
            Usuario user = new Usuario(123,"namePepito", "pepe", "123", "Suares");
            //mutableMensaje.setValue("Logueado");

            mUsuario.setValue(user);

        }else {
            mutableMensaje.setValue("Usuario y/o Contraseña incorrecto");
        }
    }
}
