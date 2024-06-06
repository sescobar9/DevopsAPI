package com.example.DevopsAPI.Controller;
import com.example.DevopsAPI.Model.Curso;
import com.example.DevopsAPI.Model.Profesor;
import com.example.DevopsAPI.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping(value = "/cursos")
    public List<Curso> cursos(){
        return cursoRepository.findAll();
    }

    @PostMapping(value = "/guardarcurso")
    public String guardarCurso(@RequestBody Curso curso){
        cursoRepository.save(curso);
        return "Curso Guardado";
    }

    @PutMapping(value = "/actualizarcurso/{id}")
    public String actualizarCurso(@PathVariable long id, @RequestBody Curso curso){
        Curso actualizaCurso = cursoRepository.findById(id).get();
        actualizaCurso.setNombre_curso(curso.getNombre_curso());
        actualizaCurso.setDecripcion(curso.getDecripcion());
        cursoRepository.save(actualizaCurso);
        return "el Curso actualizado";
    }
    @DeleteMapping(value= "eliminarcurso/{id}")
    public String eliminarCurso(@PathVariable long id){
        Curso eliminaCurso = cursoRepository.findById(id).get();
        cursoRepository.delete(eliminaCurso);
        return "el Curso eliminado";
    }


}
