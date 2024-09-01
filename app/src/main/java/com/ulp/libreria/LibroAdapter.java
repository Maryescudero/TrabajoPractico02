package com.ulp.libreria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.LibroViewHolder> {
    private List<Libro> libros;
    private final OnLibroClickListener onLibroClickListener;

    public interface OnLibroClickListener {
        void onLibroClick(Libro libro);
    }

    public LibroAdapter(Context context, List<Libro> libros, OnLibroClickListener onLibroClickListener) {
        this.libros = libros;
        this.onLibroClickListener = onLibroClickListener;
    }

    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el layout del item y crear ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro, parent, false);
        return new LibroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder holder, int position) {
        Libro libro = libros.get(position);
        holder.bind(libro);
    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    public void updateLibros(List<Libro> nuevosLibros) {
        this.libros = nuevosLibros;
        notifyDataSetChanged();
    }

    class LibroViewHolder extends RecyclerView.ViewHolder {
        private final TextView tVTitulo;
        private final TextView tVAutor;
        private final ImageView iVPortada;

        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
            tVTitulo = itemView.findViewById(R.id.tVTitulo);
            tVAutor = itemView.findViewById(R.id.tVAutor);
            iVPortada = itemView.findViewById(R.id.iVPortada);

            itemView.setOnClickListener(v -> {
                if (onLibroClickListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        onLibroClickListener.onLibroClick(libros.get(position));
                    }
                }
            });
        }

        public void bind(Libro libro) {
            tVTitulo.setText(libro.getTitulo());
            tVAutor.setText(libro.getAutor());
            iVPortada.setImageResource(libro.getFoto()); // Ajusta esto si usas un ImageLoader
        }
    }
}
