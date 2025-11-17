package com.tresedemais.habitosDiarios.controllers;

import com.tresedemais.habitosDiarios.models.request.IdRequest;
import com.tresedemais.habitosDiarios.models.response.HabitoDiarioResponse;
import com.tresedemais.habitosDiarios.models.db.Habito;
import com.tresedemais.habitosDiarios.models.response.HabitoResponse;
import com.tresedemais.habitosDiarios.models.response.MessageResponse;
import com.tresedemais.habitosDiarios.services.ServiceHabito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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


    @PostMapping("/concluir")
    public ResponseEntity<MessageResponse> concluirHabitoDiario(@RequestBody IdRequest idRequest){
//        IdRequest idRequest = new IdRequest(id);
        Integer resposta = habServ.concluirHabitoDiario(idRequest);
        switch (resposta){
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Hábito concluído com sucesso!"));
//                break;
            case 2:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Hábito não encontrado!"));
//                break;
            case 3:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Não é possível concluir este hábito depois do dia agendado"));
//                break;
            case 4:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Não é possível concluir este hábito antes do dia agendado"));
//                break;
            default:
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new MessageResponse("Requisição com erro"));
//                break; // ja tem return
        }
//        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new MessageResponse("Requisição com erro"));
    }


    @PostMapping
    public ResponseEntity<MessageResponse> criarHabito(@RequestBody Habito habito) {
        habServ.criarHabito(habito);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Hábito salvo com sucesso!"));
    }

    @GetMapping("/data/{data}")
    public ResponseEntity<List<HabitoDiarioResponse>> findAllByDate(@PathVariable LocalDate data) {
        return ResponseEntity.ok(habServ.findAllByData(data));
    }
}




