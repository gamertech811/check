package com.tresedemais.habitosDiarios.services;


import com.tresedemais.habitosDiarios.models.HabitoDiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceHabDiario {
    @Autowired
    HabitoDiarioRepository habdiaRepo;
    public HabitoDiario criar(HabitoDiario habdia){
        return habdiaRepo.save(habdia);
    }

    public List<HabitoDiario> pegar(){
        return habdiaRepo.findAll();
    }

    public void excluir(Integer id){
        habdiaRepo.deleteById(id);
    }

    public HabitoDiario acharPorData(Date data){
        Optional<HabitoDiario> pordata = habdiaRepo.findByDate(data);
        if(pordata.ispresent()){
            return pordata.get();
        }else{
            return null;
        }
    }
}
