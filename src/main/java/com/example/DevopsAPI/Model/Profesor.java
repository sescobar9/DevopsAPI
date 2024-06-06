package com.example.DevopsAPI.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_profesor;

    @Column
    private String nombre_profesor;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "profesor_curso",
            joinColumns = @JoinColumn(name = "id_profesor"),
            inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    @JsonIgnoreProperties("profesores")

    private Set<Curso> cursos = new HashSet<>();

    // Getters y setters
    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
