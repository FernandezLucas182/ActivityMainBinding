package ViewModel;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Model.Usuario;

public class InicioVM extends AndroidViewModel {
    private MutableLiveData <Usuario> mUsuario;
    public InicioVM(@NonNull Application application) {
        super(application);
    }

    public LiveData<Usuario> getmUsuario() {
        if(mUsuario == null){
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }

    public void cargarDatos(Intent intent){
        Usuario u = (Usuario) intent.getSerializableExtra("usuario");

        if (u != null) {
            mUsuario.setValue(u);
        }
        }
    }

