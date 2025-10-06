package com.tresedemais.habitosDiarios.repositories;
import com.tresedemais.habitosDiarios.models.Habito;
import org.springframework.data.jpa.repository.JpaRepository;
public interface HabitoRepository extends JpaRepository<Habito, Integer> {

}
