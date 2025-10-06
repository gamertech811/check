package com.tresedemais.habitosDiarios.models;

import java.util.Date;

public class HabitoDiario {
    Integer id;
    Integer id_h;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId_h() {
        return id_h;
    }

    public void setId_h(Integer id_h) {
        this.id_h = id_h;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Integer status;
    Date data;
}
