package br.com.cristiano.workshopdevweb.service;

import br.com.cristiano.workshopdevweb.domain.Tarefa;
import br.com.cristiano.workshopdevweb.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> buscarTodas() {
        List<Tarefa> listaTarefa = (List<Tarefa>) this.tarefaRepository.findAll();
        return listaTarefa;
    }

    public Tarefa criar(Tarefa tarefa){
        return this.tarefaRepository.save(tarefa);
    }
}