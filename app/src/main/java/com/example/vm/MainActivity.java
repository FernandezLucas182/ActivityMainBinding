package com.example.vm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.vm.databinding.ActivityMainBinding;

import ViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewModel.getMutableMensaje().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.txMensaje.setText(s);
            }
        });

         //estructura lamda para hacerlo mas resumido
        /*viewModel.getMutableMensaje().observe(this, mensaje->{
            binding.txMensaje.setText(mensaje);
        });*/

        //cuando se logee correctamente se dispara este observador
        viewModel.getmUsuario().observe(this, usuario->{
            Intent intent = new Intent(this, Inicio.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.login(binding.etUsuario.getText().toString(), binding.etPassword.getText().toString());
            }
        });


    }
}
