package com.example.vm;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vm.databinding.ActivityInicioBinding;
import com.example.vm.databinding.ActivityMainBinding;

import ViewModel.InicioVM;

public class Inicio extends AppCompatActivity {
    private ActivityInicioBinding binding;
    private InicioVM viewModel;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        binding = ActivityInicioBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewModel.getmUsuario().observe(this, usuario ->{
            binding.tvApellido.setText(usuario.getApellido());
            binding.tvNombre.setText(usuario.getNombre());
            binding.tvDni.setText(usuario.getDni());
            binding.tvUsuario.setText(usuario.getUsuario());
        });

        viewModel.cargarDatos(getIntent());

    }
}
