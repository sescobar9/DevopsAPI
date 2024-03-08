package com.example.DevopsAPI.Controller;

import com.example.DevopsAPI.Model.Curso;
import com.example.DevopsAPI.Model.Profesor;
import com.example.DevopsAPI.Repository.CursoRepository;
import com.example.DevopsAPI.Repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ProfesorController {
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping(value = "/profesores")
    public List<Profesor> getProfesores(){
        return profesorRepository.findAll();
    }

    @PostMapping(value = "/guardarprofesor")
    public String guardarProfesor(@RequestBody Profesor profesor){
        profesorRepository.save(profesor);
        return "profesor guardado";
    }

    @PutMapping(value = "/actualizarprofesor/{id}")
    public String actualizarProfesor(@PathVariable long id, @RequestBody Profesor profesor){
        Profesor actualizaProfesor = profesorRepository.findById(id).get();
        actualizaProfesor.setNombre_profesor(profesor.getNombre_profesor());
        actualizaProfesor.setEmail(profesor.getEmail());
        profesorRepository.save(actualizaProfesor);
        return "Profesor actalizado";
    }
    @DeleteMapping(value= "eliminarprofesor/{id}")
    public String eliminarProfesor(@PathVariable long id){
        Profesor eliminaProfesor = profesorRepository.findById(id).get();
        profesorRepository.delete(eliminaProfesor);
        return "Profesor eliminado";
    }
    @PostMapping(value = "/asociarProfesorConCurso/{profesorId}/{cursoId}")
    public String asociarProfesorConCurso(@PathVariable long profesorId, @PathVariable long cursoId) {
        Profesor profesor = profesorRepository.findById(profesorId).get();
        Curso curso = cursoRepository.findById(cursoId).get();
        profesor.getCursos().add(curso);
        profesorRepository.save(profesor);
        return "Profesor asociado con Curso";
    }
}
