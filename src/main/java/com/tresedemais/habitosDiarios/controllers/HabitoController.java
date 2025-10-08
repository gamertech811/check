package com.tresedemais.habitosDiarios.controllers;

import com.tresedemais.habitosDiarios.models.Habito;
import com.tresedemais.habitosDiarios.services.ServiceHabito;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/habito"})






public class HabitoController {
    ServiceHabito habServ;

    @GetMapping
    public List<Habito> listarHabitos(){
        return habServ.pegar();
    }

    @GetMapping("/{id}")
    public Habito buscarHabito(@PathVariable int id) throws Exception{
        Habito habito = habServ.achar(id);
        if (habito==null){
            throw new Exception();
        }
        return habito;
    }

    @PostMapping
    public Habito criarHabito(@PathVariable Habito habito){
        return habServ.criar(habito);
    }

}
