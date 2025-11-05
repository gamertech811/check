package com.tresedemais.habitosDiarios.controllers;

import com.tresedemais.habitosDiarios.models.response.HabitoDiarioResponse;
import com.tresedemais.habitosDiarios.models.db.Habito;
import com.tresedemais.habitosDiarios.models.response.HabitoResponse;
import com.tresedemais.habitosDiarios.services.ServiceHabito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/habito")
public class HabitoController {
    @Autowired
    private ServiceHabito habServ;

    @GetMapping
    public ResponseEntity<List<HabitoResponse>> listarHabitos() {
        return ResponseEntity.ok(habServ.getHabitos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habito> buscarHabito(@PathVariable int id) throws Exception {
        Habito habito = habServ.findHabitoById(id);
        if (habito == null) throw new Exception("Habito não encontrado");
        return ResponseEntity.ok(habito);
    }

    @PostMapping
    public ResponseEntity<String> criarHabito(@RequestBody Habito habito) {
        habServ.criarHabito(habito);
        return ResponseEntity.ok("Hábito salvo com sucesso!");
    }

    @GetMapping("/data/{data}")
    public ResponseEntity<List<HabitoDiarioResponse>> findAllByDate(@PathVariable LocalDate data) {
        return ResponseEntity.ok(habServ.findAllByData(data));
    }
}




