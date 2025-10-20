package br.com.cristiano.workshopdevweb.repositories;

import br.com.cristiano.workshopdevweb.domain.Tarefa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Long> {

    List<Tarefa> findByDataFinalIsNull();
    List<Tarefa> findByDataFinalIsNotNull();

}
