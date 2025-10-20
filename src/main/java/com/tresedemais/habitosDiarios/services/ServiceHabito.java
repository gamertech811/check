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
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ServiceHabito {
    @Autowired
    HabitoRepository habitoRepo;
    HabitoDiarioRepository habdiaRepo;
    public Habito criarHabito(Habito habito){
        return habitoRepo.save(habito);
    }


    // usar na função de pegar habitos diarios para comparar
    //usar no endpoint
    public List<Habito> getAllHabitos(){
        return habitoRepo.findAll();
    }


    public void excluirHabito(Integer id){
        habitoRepo.deleteById(id);
    }

//    public HabitoDiario criarHD(HabitoDiario habdia){
//        return habdiaRepo.save(habdia);
//    }

//    public List<HabitoDiario> pegarHD(){
//        return habdiaRepo.findAll();
//    }

    public void excluirHabitoDiario(Integer id){
        habdiaRepo.deleteById(id);
    }



    //endpoint -> pega habitos do banco e verifica:
    //habitos diarios se existem igual habitos, se nao existem criar e verificar status


    public Map<Integer, HabitoDiario> findAllByData(LocalDate data) {
        List<Habito> habitos = habitoRepo.findAll();

        //List<HabitoDiario> habitosDiarios = habdiaRepo.findAllByDate(data);


        Map<Integer, HabitoDiario> mapHabito = habdiaRepo.findAllByDate(data).stream()
                .collect(Collectors.toMap(HabitoDiario::getId_h, Function.identity()));
//        Map<Integer, HabitoDiario> mapHabito = new HashMap<>();
//
//        for(HabitoDiario habitoDiario : habitosDiarios){
//            mapHabito.put(habitoDiario.getId_h(), habitoDiario);
//        }

        for(Habito habito : habitos){
            HabitoDiario habitoDiario = mapHabito.get(habito.getId());
            if(habitoDiario == null){
                habitoDiario = new HabitoDiario();
                habitoDiario.setId_h(habito.getId());
                habitoDiario.setData(data);
                habitoDiario.setStatus(0);
                mapHabito.put(habito.getId(), habdiaRepo.save(habitoDiario));
            }
        }
        return mapHabito;
    }
}
