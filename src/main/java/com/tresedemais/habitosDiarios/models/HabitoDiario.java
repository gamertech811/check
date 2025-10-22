package com.tresedemais.habitosDiarios.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "habito_diario")
public class HabitoDiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_habito")
    private Integer id_h;
    private Integer status;
    private LocalDate data;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_h() {
        return id_h;
    }

    public void setId_h(Integer id_h) {
        this.id_h = id_h;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
