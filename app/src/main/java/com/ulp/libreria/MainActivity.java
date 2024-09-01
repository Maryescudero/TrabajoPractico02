package com.ulp.libreria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ulp.libreria.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private LibroAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new LibroAdapter(this, new ArrayList<>(), libro -> {
            Intent intent = new Intent(MainActivity.this, DescripcionActivity.class);
            intent.putExtra("libro", libro); // Usa Serializable
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);

        viewModel.getLibros().observe(this, libros -> {
            adapter.updateLibros(libros);
        });

        binding.iBBuscar.setOnClickListener(v -> {
            String query = binding.eTlibro.getText().toString();
            viewModel.searchLibros(query);
        });
    }
}
