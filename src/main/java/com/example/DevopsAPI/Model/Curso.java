package com.example.DevopsAPI.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_curso;

    @Column
    private String nombre_curso;

    @ManyToMany(mappedBy = "cursos")
    @JsonIgnoreProperties("cursos")
    private Set<Profesor> profesores = new HashSet<>();

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

}
