package com.tresedemais.habitosDiarios.models.response;

import com.tresedemais.habitosDiarios.models.db.Habito;

public class HabitoResponse {

    private Integer id;
    private String nome;
    private Integer quantidade;

    public HabitoResponse(Habito habito, Integer quantidade){
        this.id = habito.getId();
        this.nome = habito.getNome();
        this.quantidade = quantidade == null ? 0 : quantidade;
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
