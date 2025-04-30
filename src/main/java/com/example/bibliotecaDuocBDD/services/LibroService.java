package com.example.bibliotecaDuocBDD.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaDuocBDD.model.Libro;
import com.example.bibliotecaDuocBDD.repository.LibroRepository;
import com.example.bibliotecaDuocBDD.repository.LibroRepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LibroService {
    
    @Autowired
    private LibroRepositoryJPA libroRepository;

    public List<Libro> getLibros(){
       return libroRepository.findAll();
    }

    public Libro getLibroById(int id){
        return libroRepository.findById(id);
    } 

    public Libro saveLibro(Libro lib){
        return libroRepository.save(lib);
    }

    public Libro updateLibro(Libro lib){
        return libroRepository.save(lib);
    }

    public String deleteLibro(int id){
        libroRepository.deleteById(id);
        return "Libro eliminado";
    }
}
