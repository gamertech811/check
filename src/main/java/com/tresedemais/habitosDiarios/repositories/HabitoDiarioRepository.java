package com.tresedemais.habitosDiarios.repositories;

import com.tresedemais.habitosDiarios.models.db.HabitoDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface HabitoDiarioRepository extends JpaRepository<HabitoDiario, Integer> {
    List<HabitoDiario> findAllByData(LocalDate data);
}
