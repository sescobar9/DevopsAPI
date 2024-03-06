package com.example.DevopsAPI.Controller;

import com.example.DevopsAPI.Model.Profesor;
import com.example.DevopsAPI.Repository.ProfesorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.awt.util.PerformanceLogger.times;

@WebMvcTest(ProfesorController.class)
public class ProfesorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfesorRepository profesorRepository;

    @Test
    public void getProfesores() throws Exception{
        Profesor profesor = new Profesor();
        profesor.setNombre_profesor("Juan");
        profesor.setEmail("juan@hotmail.com");

        List<Profesor> allProfesores = Arrays.asList(profesor);

        when(profesorRepository.findAll()).thenReturn(allProfesores);

        mockMvc.perform(get("/profesores").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nombre_profesor", is("Juan")));

        verify(profesorRepository, times(1)).findAll();
    }

    @Test
    void guardarProfesor() {
    }

    @Test
    void actualizarProfesor() {
    }

    @Test
    void eliminarProfesor() {
    }

    @Test
    void asociarProfesorConCurso() {
    }
}