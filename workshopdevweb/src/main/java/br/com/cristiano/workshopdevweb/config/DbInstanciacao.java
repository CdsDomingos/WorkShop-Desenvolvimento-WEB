package br.com.cristiano.workshopdevweb.config;

import br.com.cristiano.workshopdevweb.domain.Tarefa;
import br.com.cristiano.workshopdevweb.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;


@Configuration
public class DbInstanciacao implements CommandLineRunner {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Override
    public void run(String... args) throws Exception {
        this.tarefaRepository.deleteAll();

        Tarefa tarefa1 = new Tarefa();
        tarefa1.setTitulo("Estudar Spring Boot");
        tarefa1.setDataDeEntrega(LocalDate.of(2025, 10, 15));

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setTitulo("Fazer exercícios do Workshop Desenvolvimento Web");
        tarefa2.setDataDeEntrega(LocalDate.of(2025, 10, 20));

        this.tarefaRepository.saveAll(Arrays.asList(tarefa1, tarefa2));
    }
}
