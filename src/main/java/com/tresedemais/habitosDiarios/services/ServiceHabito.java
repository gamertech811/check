package com.tresedemais.habitosDiarios.services;

import com.tresedemais.habitosDiarios.models.Habito;
import com.tresedemais.habitosDiarios.repositories.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceHabito {
    @Autowired
    HabitoRepository habitoRepo;
    public Habito criar(Habito habito){
        return habitoRepo.save(habito);
    }

    public List<Habito> pegar(){
        return habitoRepo.findAll();
    }


    public void excluir(Integer id){
        habitoRepo.deleteById(id);
    }




    public Habito achar(Integer id){
        Optional<Habito> achar = habitoRepo.findById(id);
        if (achar.isPresent()){
            return achar.get();
        }else{
            return null;
        }
    }

}
