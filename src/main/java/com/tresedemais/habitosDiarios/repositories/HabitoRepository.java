package com.tresedemais.habitosDiarios.repositories;
import com.tresedemais.habitosDiarios.models.Habito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitoRepository extends JpaRepository<Habito, Integer> {

}
