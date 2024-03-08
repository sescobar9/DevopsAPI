package com.example.DevopsAPI.Controller;

import com.example.DevopsAPI.Model.Curso;
import com.example.DevopsAPI.Model.Profesor;
import com.example.DevopsAPI.Repository.CursoRepository;
import com.example.DevopsAPI.Repository.ProfesorRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProfesorController.class)
public class ProfesorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfesorRepository profesorRepository;

    @MockBean
    private CursoRepository cursoRepository;

    @Test
    public void getProfesores_ShouldReturnAllProfesores() throws Exception {
        Profesor profesor1 = new Profesor();
        profesor1.setNombre_profesor("Juan Pérez");
        Profesor profesor2 = new Profesor();
        profesor2.setNombre_profesor("Ana Gómez");

        List<Profesor> allProfesores = Arrays.asList(profesor1, profesor2);

        when(profesorRepository.findAll()).thenReturn(allProfesores);

        mockMvc.perform(get("/profesores"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre_profesor", Matchers.is("Juan Pérez")))
                .andExpect(jsonPath("$[1].nombre_profesor", Matchers.is("Ana Gómez")));

        verify(profesorRepository, times(1)).findAll();
    }
}