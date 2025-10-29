package com.tresedemais.habitosDiarios.models.response;

public class HabitoResponse {

    Integer id;
    String nome;
    Integer concluidos;

    public HabitoResponse(Integer id, String nome, Integer concluidos){
        this.id = id;
        this.nome = nome;
        this.concluidos = concluidos;
    }
}
