package com.tresedemais.habitosDiarios.controllers;

import com.tresedemais.habitosDiarios.models.Habito;
import com.tresedemais.habitosDiarios.models.HabitoDiario;
import com.tresedemais.habitosDiarios.services.ServiceHabito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping({"/habito"})






public class HabitoController {
    @Autowired
    private ServiceHabito habServ;

    @GetMapping
    public List<Habito> listarHabitos() {
        return habServ.getAllHabitos();
    }

    @GetMapping("/{id}")
    public Habito buscarHabito(@PathVariable int id) throws Exception {
        Habito habito = habServ.findHabitoById(id);
        if (habito == null) throw new Exception("Habito não encontrado");
        return habito;
    }

    @PostMapping
    public Habito criarHabito(@RequestBody Habito habito) {
        return habServ.criarHabito(habito);
    }

    @GetMapping("/data/{data}")
    public List<HabitoDiario> findAllByDate(@PathVariable LocalDate data) {
        return habServ.findAllByData(data);
    }
}




