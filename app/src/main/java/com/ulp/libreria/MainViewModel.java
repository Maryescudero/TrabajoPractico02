package com.ulp.libreria;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<List<Libro>> librosLiveData = new MutableLiveData<>();
    private List<Libro> allLibros = new ArrayList<>();

    public MainViewModel() {
        // Inicializa la lista con datos de ejemplo
        allLibros.add(new Libro("El Hobbit", "J.R.R. Tolkien", 310, 1937, "Fantasía", "Aventura", R.drawable.hobbit, "Una aventura épica en la Tierra Media, siguiendo al hobbit Bilbo Baggins mientras emprende una búsqueda para recuperar un tesoro custodiado por el dragón Smaug."));
        allLibros.add(new Libro("Juego de Tronos", "George R.R. Martin", 694, 1996, "Fantasía", "Épico", R.drawable.got, "Primer libro de la serie 'Canción de Hielo y Fuego', que introduce un complejo mundo de intrigas políticas, conflictos y luchas por el poder en los Siete Reinos de Westeros."));
        allLibros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 96, 1943, "Fábula", "Filosófica", R.drawable.principito, "Un cuento poético y filosófico que narra las aventuras de un pequeño príncipe que viaja a través de varios planetas y aprende lecciones sobre la vida, el amor y la amistad."));

        // Inicializa con todos los libros
        librosLiveData.setValue(new ArrayList<>(allLibros));
    }

    public LiveData<List<Libro>> getLibros() {
        return librosLiveData;
    }

    public void setLibros(List<Libro> libros) {
        librosLiveData.setValue(libros);
    }

    public void searchLibros(String query) {
        if (query == null || query.isEmpty()) {
            // Si la búsqueda está vacía, muestra todos los libros
            librosLiveData.setValue(new ArrayList<>(allLibros));
        } else {
            // Filtra los libros que contienen el texto de búsqueda en el título
            List<Libro> filteredList = allLibros.stream()
                    .filter(libro -> libro.getTitulo().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());
            librosLiveData.setValue(filteredList);
        }
    }
}
