package br.com.cristiano.workshopdevweb.service;

import br.com.cristiano.workshopdevweb.domain.Tarefa;
import br.com.cristiano.workshopdevweb.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criar(Tarefa tarefa){
        return this.tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefasPendentes(){
        return this.tarefaRepository.findByDataFinalIsNull();
    }

    public List<Tarefa> listarTarefasConcluidas() {
        return tarefaRepository.findByDataFinalIsNotNull();
    }

    public void concluirTarefa(Long id){
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);

        if (tarefaOptional.isPresent()){
            Tarefa tarefa = tarefaOptional.get();

            if (tarefa.getDataFinal() == null){
                tarefa.setDataFinal(LocalDate.now());
                tarefaRepository.save(tarefa);
            }
        }
    }

    public void deletaTarefa(Long id){
        if(tarefaRepository.existsById(id)){
            tarefaRepository.deleteById(id);
        }
    }
}