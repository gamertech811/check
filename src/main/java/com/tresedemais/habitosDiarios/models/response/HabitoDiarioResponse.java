package com.tresedemais.habitosDiarios.models.response;

import com.tresedemais.habitosDiarios.models.db.Habito;
import com.tresedemais.habitosDiarios.models.db.HabitoDiario;

public class HabitoDiarioResponse {
    private int id;
    private String nome;
    private int status;

    public HabitoDiarioResponse(HabitoDiario habitoDiario, Habito habito) {
        this.id = habitoDiario.getId();
        this.nome = habito.getNome();
        this.status = habitoDiario.getStatus();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
