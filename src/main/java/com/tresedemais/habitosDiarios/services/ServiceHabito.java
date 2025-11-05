package com.tresedemais.habitosDiarios.services;

import com.tresedemais.habitosDiarios.models.response.HabitoDiarioResponse;
import com.tresedemais.habitosDiarios.models.db.Habito;
import com.tresedemais.habitosDiarios.models.db.HabitoDiario;
import com.tresedemais.habitosDiarios.models.response.HabitoResponse;
import com.tresedemais.habitosDiarios.repositories.HabitoDiarioRepository;
import com.tresedemais.habitosDiarios.repositories.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ServiceHabito {

    @Autowired
    private HabitoRepository habitoRepository;

    @Autowired
    private HabitoDiarioRepository habitoDiarioRepository;

    public Habito criarHabito(Habito habito) {
        return habitoRepository.save(habito);
    }

    public List<Habito> getAllHabitos() {
        return habitoRepository.findAll();
    }

    public void excluirHabito(Integer id) {
        habitoRepository.deleteById(id);
    }

    public List<HabitoResponse> getHabitos(){
        Map<Integer, Long> contagemPorHabito = habitoDiarioRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        HabitoDiario::getId_h,      // agrupa pelo id_h
                        Collectors.counting()       // conta quantas vezes aparece
                ));

    return habitoRepository.findAll().stream().map(
            habito -> new HabitoResponse(habito, contagemPorHabito.get(habito.getId()).intValue()))
    .toList();

    }

    public Habito findHabitoById(int id) {
        return habitoRepository.findById(id).orElse(null);
    }

    public List<HabitoDiarioResponse> findAllByData(LocalDate data) {
        List<Habito> habitos = habitoRepository.findAll();
        Map<Integer, HabitoDiario> mapHabito = habitoDiarioRepository.findAllByData(data).stream()
                .collect(Collectors.toMap(HabitoDiario::getId_h, Function.identity()));

        List<HabitoDiarioResponse> resposta = new ArrayList<>();

        for (Habito habito : habitos) {
            HabitoDiario habitoDiario = mapHabito.get(habito.getId());
            if (habitoDiario == null) {
                habitoDiario = new HabitoDiario(habito.getId(), data);
                habitoDiarioRepository.save(habitoDiario);
            }
            resposta.add(new HabitoDiarioResponse(habitoDiario, habito));
        }

        return resposta;
    }
}

