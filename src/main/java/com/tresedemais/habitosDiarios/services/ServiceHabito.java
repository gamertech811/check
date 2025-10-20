package com.tresedemais.habitosDiarios.services;

import com.tresedemais.habitosDiarios.models.Habito;
import com.tresedemais.habitosDiarios.models.HabitoDiario;
import com.tresedemais.habitosDiarios.repositories.HabitoDiarioRepository;
import com.tresedemais.habitosDiarios.repositories.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ServiceHabito {

    @Autowired
    private HabitoRepository habitoRepo;

    @Autowired
    private HabitoDiarioRepository habdiaRepo;

    public Habito criarHabito(Habito habito) {
        return habitoRepo.save(habito);
    }

    public List<Habito> getAllHabitos() {
        return habitoRepo.findAll();
    }

    public void excluirHabito(Integer id) {
        habitoRepo.deleteById(id);
    }

    public Habito findHabitoById(int id) {
        return habitoRepo.findById(id).orElse(null);
    }

    public List<HabitoDiario> findAllByData(LocalDate data) {
        List<Habito> habitos = habitoRepo.findAll();
        Map<Integer, HabitoDiario> mapHabito = habdiaRepo.findAllByData(data).stream()
                .collect(Collectors.toMap(HabitoDiario::getId_h, Function.identity()));

        for (Habito habito : habitos) {
            HabitoDiario habitoDiario = mapHabito.get(habito.getId());
            if (habitoDiario == null) {
                habitoDiario = new HabitoDiario();
                habitoDiario.setId_h(habito.getId());
                habitoDiario.setData(data);
                habitoDiario.setStatus(0);
                mapHabito.put(habito.getId(), habdiaRepo.save(habitoDiario));
            }
        }

        return new ArrayList<>(mapHabito.values());
    }
}

