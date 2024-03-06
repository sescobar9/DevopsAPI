package com.example.DevopsAPI.Controller;

import com.example.DevopsAPI.Repository.CursoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*
        ;
@WebMvcTest(CursoController.class)
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoRepository cursoRepository;

    @Test
    void cursos() {
    }

    @Test
    void guardarCurso() {
    }

    @Test
    void actualizarCurso() {
    }

    @Test
    void eliminarCurso() {
    }
}