package com.example.bibliotecaDuocBDD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bibliotecaDuocBDD.model.Libro;
import java.util.List;


public interface LibroRepositoryJPA extends JpaRepository<Libro, Long> {

    Libro findById(int id);
    String deleteById(int id);
}
