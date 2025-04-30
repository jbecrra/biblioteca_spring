package com.example.bibliotecaDuocBDD.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaDuocBDD.model.Libro;
import com.example.bibliotecaDuocBDD.services.LibroService;

import jakarta.websocket.server.PathParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listaLibros() {
        List<Libro> libros = libroService.getLibros();
        if (libros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(libros);
    }

    @PostMapping
    public ResponseEntity<Libro> agregarLibro(@RequestBody Libro lib) {
        Libro libro = libroService.saveLibro(lib);
        return ResponseEntity.status(HttpStatus.CREATED).body(libro);
    }

    @GetMapping("{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable int id) {
        try{
            Libro lib = libroService.getLibroById(id);
            return ResponseEntity.ok(lib);
        }catch(Exception ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable int id, @RequestBody Libro lib) {
       try{
            Libro libro = libroService.getLibroById(id);
            libro.setAutor(lib.getAutor());
            libro.setEditorial(lib.getEditorial());
            libro.setFechaPublicacion(lib.getFechaPublicacion());
            libro.setIsbn(lib.getIsbn());
            libro.setTitulo(lib.getTitulo());

            libroService.saveLibro(libro);

            return ResponseEntity.ok(libro);
       }catch(Exception ex){
            return ResponseEntity.notFound().build();
       }
    }    

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarLibro(@PathVariable int id){
        try{
            libroService.deleteLibro(id);
            return ResponseEntity.noContent().build();
        }catch(Exception ex){
            return ResponseEntity.notFound().build();
        }
    }
}
