package com.example.bibliotecaDuocBDD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    @Id
    public int id;
    @Column(nullable = false)
    public String isbn;
    @Column(nullable = false, length = 50)
    public String titulo;
    @Column(nullable = false)
    public Double precio;
    @Column(nullable = false)
    public String editorial;
    @Column(nullable = false)
    public int fechaPublicacion;
    @Column(nullable = false)
    public String autor;
}
