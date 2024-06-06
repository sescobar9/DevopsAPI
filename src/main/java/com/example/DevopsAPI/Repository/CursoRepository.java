package com.example.DevopsAPI.Repository;

import com.example.DevopsAPI.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
