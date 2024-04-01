package com.example.DevopsAPI.Controller;


import com.example.DevopsAPI.Model.Curso;
import com.example.DevopsAPI.Repository.CursoRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CursoController.class)
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoRepository cursoRepository;

    @Test
    public void getCursos_ShouldReturnAllCursos() throws Exception {
        Curso curso1 = new Curso();
        curso1.setNombre_curso("Matemáticas");
        Curso curso2 = new Curso();
        curso2.setNombre_curso("Literatura");

        List<Curso> allCursos = Arrays.asList(curso1, curso2);

        when(cursoRepository.findAll()).thenReturn(allCursos);

        mockMvc.perform(get("/cursos"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre_curso", Matchers.is("Matemáticas")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nombre_curso", Matchers.is("Literatura")));

        verify(cursoRepository, times(1)).findAll();
    }
    @Test
    public void guardarCurso_ShouldReturnSavedMessage() throws Exception {
        Curso newCurso = new Curso();
        newCurso.setNombre_curso("Ciencias");

        mockMvc.perform(post("/guardarcurso")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre_curso\":\"Ciencias\",\"decripcion\":\"Curso de ciencias básicas\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Curso Guardado"));

        verify(cursoRepository).save(any(Curso.class));
    }
    @Test
    public void actualizarCurso_ShouldReturnUpdatedMessage() throws Exception {
        Curso existingCurso = new Curso();
        existingCurso.setId_curso(1L);
        existingCurso.setNombre_curso("Matemáticas");
        existingCurso.setDecripcion("Curso de matemáticas básicas");

        when(cursoRepository.findById(1L)).thenReturn(Optional.of(existingCurso));

        mockMvc.perform(put("/actualizarcurso/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre_curso\":\"Matemáticas Avanzadas\",\"decripcion\":\"Curso avanzado de matemáticas\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Curso actualizado"));

        verify(cursoRepository).save(any(Curso.class));
    }
    @Test
    public void eliminarCurso_ShouldReturnDeletedMessage() throws Exception {
        Curso cursoToDelete = new Curso();
        cursoToDelete.setId_curso(1L);

        when(cursoRepository.findById(1L)).thenReturn(Optional.of(cursoToDelete));

        mockMvc.perform(delete("/eliminarcurso/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string("el Curso eliminado"));

        verify(cursoRepository).delete(cursoToDelete);
    }


}