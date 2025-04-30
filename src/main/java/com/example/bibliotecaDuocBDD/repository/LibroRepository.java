package com.example.bibliotecaDuocBDD.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaDuocBDD.model.Libro;

@Repository
public class LibroRepository {

    private List<Libro> listaLibros= new ArrayList<>();

    public List<Libro> obteneLibros(){
        return listaLibros;
    }

    public Libro buscarPorId(int id){
        for (Libro libro : listaLibros) {
            if(libro.getId()== id){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn){
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }


    public Libro actualizar(Libro lib){
        int id=0;
        int posicion =0;
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId()==lib.getId()) {
                id=lib.getId();
                posicion=i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setAutor(lib.getAutor());
        libro1.setEditorial(lib.getEditorial());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setId(id);
        libro1.setIsbn(lib.getIsbn());
        libro1.setTitulo(lib.getTitulo());

        listaLibros.set(posicion, libro1);
        return libro1;
    }

    public void eliminar(int id){
        Libro lib = buscarPorId(id);
        if(lib!=null){
            listaLibros.remove(lib);
        }
    }


}
