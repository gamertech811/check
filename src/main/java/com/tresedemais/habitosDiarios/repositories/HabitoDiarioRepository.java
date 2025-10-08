package com.tresedemais.habitosDiarios.repositories;

import com.tresedemais.habitosDiarios.models.HabitoDiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HabitoDiarioRepository extends JpaRepository<HabitoDiario, Integer> {
    public List<HabitoDiario> findByDate(LocalDate data);
}
