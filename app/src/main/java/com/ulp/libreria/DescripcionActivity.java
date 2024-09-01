package com.ulp.libreria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DescripcionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tVTitulo;
    private TextView tVAutor;
    private TextView tVPagina;
    private TextView tVAnio;
    private TextView tVDescripcion;
    private TextView tVGenero;
    private TextView tVCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        // Inicialización de las vistas
        imageView = findViewById(R.id.imageView);
        tVTitulo = findViewById(R.id.tVTitulo);
        tVAutor = findViewById(R.id.tVAutor);
        tVPagina = findViewById(R.id.tVPagina);
        tVAnio = findViewById(R.id.tVAnio);
        tVDescripcion = findViewById(R.id.tVDescripcion);
        tVGenero = findViewById(R.id.tVGenero);
        tVCategoria = findViewById(R.id.tVCategoria);

        // Obtener el libro pasado a través del Intent
        Intent intent = getIntent();
        Libro libro = (Libro) intent.getSerializableExtra("libro");

        if (libro != null) {
            // Configura la vista con los datos del libro
            imageView.setImageResource(libro.getFoto()); // Usa el recurso de imagen del libro
            tVTitulo.setText(libro.getTitulo());
            tVAutor.setText(libro.getAutor());
            tVPagina.setText("Páginas: " + libro.getPaginas());
            tVAnio.setText("Año: " + libro.getAnio());
            tVDescripcion.setText(libro.getDescripcion());
            tVGenero.setText("Género: " + libro.getGenero());
            tVCategoria.setText("Categoría: " + libro.getCategoria());
        }

        // Configura el botón para regresar
        findViewById(R.id.iBRegresar).setOnClickListener(v -> finish());
    }
}
