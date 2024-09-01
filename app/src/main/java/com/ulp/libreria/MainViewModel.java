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
        // Inicializa la lista de libros. Aquí puedes agregar datos de ejemplo o cargar desde una fuente de datos.
        allLibros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 96, 1943, "Fábula", "Literatura infantil", R.drawable.principito, "El Principito es una obra clásica de Antoine de Saint-Exupéry que narra la historia de un joven príncipe que viaja de un planeta a otro. A través de sus encuentros con diversos personajes, el Principito explora temas profundos como la amistad, el amor y la búsqueda del significado de la vida. El libro es conocido por sus ilustraciones encantadoras y su mensaje atemporal, que resuena tanto en adultos como en niños."));
        allLibros.add(new Libro("Juego de Tronos", "George R.R. Martin", 694, 1996, "Fantasia épica", "Novela épica", R.drawable.got, "Juego de Tronos es la primera novela de la serie 'Canción de Hielo y Fuego' escrita por George R.R. Martin. Ambientada en los reinos ficticios de Westeros y Essos, la historia se centra en la lucha por el trono del continente. Con una intrincada trama de conspiraciones políticas, traiciones y batallas épicas, la novela presenta un elenco de personajes complejos y una narrativa rica en detalles. La serie es conocida por su atmósfera oscura, realismo brutal y la creación de un mundo fascinante y complejo."));
        allLibros.add(new Libro("El Hobbit", "J.R.R. Tolkien", 310, 1937, "Fantasía", "Aventura épica", R.drawable.hobbit, "El Hobbit es una novela de fantasía escrita por J.R.R. Tolkien. La historia sigue a Bilbo Baggins, un hobbit que disfruta de una vida tranquila en la Comarca. Su vida cambia drásticamente cuando el mago Gandalf y una compañía de enanos lo reclutan para una aventura épica para recuperar su hogar y tesoro robado por el dragón Smaug. A lo largo de su viaje, Bilbo enfrenta peligros, descubre nuevos mundos y encuentra coraje dentro de sí mismo. La novela es conocida por su narrativa encantadora, personajes memorables y la creación de un universo rico y detallado."));
        // Agrega más libros según sea necesario
        librosLiveData.setValue(new ArrayList<>(allLibros)); // Inicializa con todos los libros
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
