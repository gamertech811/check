package com.tresedemais.habitosDiarios.models.response;

import com.tresedemais.habitosDiarios.models.db.Habito;

public class HabitoResponse {

    private Integer id;
    private String nome;
    private Integer concluidos;

    public HabitoResponse(Habito habito, Integer concluidos){
        this.id = habito.getId();
        this.nome = habito.getNome();
        this.concluidos = concluidos == null ? 0 : concluidos;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getConcluidos() {
        return concluidos;
    }

    public void setConcluidos(Integer concluidos) {
        this.concluidos = concluidos;
    }
}
