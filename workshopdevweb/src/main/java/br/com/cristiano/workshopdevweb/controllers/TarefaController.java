package br.com.cristiano.workshopdevweb.controllers;

import br.com.cristiano.workshopdevweb.domain.Tarefa;
import br.com.cristiano.workshopdevweb.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/criar")
    public String criar(){
        return "criar";
    }

    @PostMapping("/criar")
    public void cadastrarTarefa(Tarefa tarefa){
        this.tarefaService.criar(tarefa);
        System.out.println("Tarefa salva: " + tarefa.getTitulo());
    }

    @GetMapping("/listaTarefa")
    public String listaTarefa(Model model) {

        List<Tarefa> pendentes = tarefaService.listarTarefasPendentes();
        List<Tarefa> concluidas = tarefaService.listarTarefasConcluidas();

        model.addAttribute("tarefasPendentes", pendentes);
        model.addAttribute("tarefasConcluidas", concluidas);
        return "listaTarefa";
    }

    @PostMapping("/concluir/{id}")
    public String concluirTarefa(@PathVariable Long id) {
        tarefaService.concluirTarefa(id);
        return "redirect:/listaTarefa";
    }

    @PostMapping("/deletar/{id}")
    public String deletarTarefa(@PathVariable Long id) {
        tarefaService.deletaTarefa(id);
        return "redirect:/listaTarefa";
    }
}
