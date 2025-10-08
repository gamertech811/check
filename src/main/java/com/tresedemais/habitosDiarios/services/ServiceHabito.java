package com.tresedemais.habitosDiarios.services;

import com.tresedemais.habitosDiarios.models.Habito;
import com.tresedemais.habitosDiarios.models.HabitoDiario;
import com.tresedemais.habitosDiarios.repositories.HabitoDiarioRepository;
import com.tresedemais.habitosDiarios.repositories.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServiceHabito {
    @Autowired
    HabitoRepository habitoRepo;
    HabitoDiarioRepository habdiaRepo;
    public Habito criar(Habito habito){
        return habitoRepo.save(habito);
    }


    //TODO usar na função de pegar habitos diarios para comparar
    //TODO usar no endpoint
    public List<Habito> getAllHabitos(){
        return habitoRepo.findAll();
    }


    public void excluir(Integer id){
        habitoRepo.deleteById(id);
    }

    public HabitoDiario criarHabDiario(HabitoDiario habdia){
        return habdiaRepo.save(habdia);
    }

    public List<HabitoDiario> pegarHabitosDiarios(){
        return habdiaRepo.findAll();
    }

    public void excluirHabitoDiario(Integer id){
        habdiaRepo.deleteById(id);
    }



    //TODO endpoint -> pega dados do banco e verifica os
    //TODO habitos diarios se existem, se nao existem criar e verificar status


    //TODO verifica se ta certo, code do gpt
    public Map<Integer, HabitoDiario> verificarOuCriarHabitosDiarios() {
        LocalDate hoje = LocalDate.now();

        List<Habito> habitos = habitoRepo.findAll();
        List<HabitoDiario> habitosDiarios = habdiaRepo.findAll();

        Map<Integer, HabitoDiario> mapa = new java.util.HashMap<>();

        for (Habito habito : habitos) {
            Optional<HabitoDiario> existente = habitosDiarios.stream()
                    .filter(hd -> hd.getHabito().getId().equals(habito.getId())
                            && hd.getData().equals(hoje))
                    .findFirst();

            HabitoDiario habitoDiario;

            if (existente.isPresent()) {
                habitoDiario = existente.get();
            } else {
                habitoDiario = new HabitoDiario();
                habitoDiario.setHabito(habito);
                habitoDiario.setData(hoje);
                habitoDiario.setStatus(0); // novo com status 0
                habitoDiario = habdiaRepo.save(habitoDiario);
            }

            mapa.put(habito.getId(), habitoDiario);
        }

        return mapa;
    }





    }

}
