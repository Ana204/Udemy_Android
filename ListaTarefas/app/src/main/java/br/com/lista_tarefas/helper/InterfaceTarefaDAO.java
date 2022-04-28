package br.com.lista_tarefas.helper;

import java.util.List;

import br.com.lista_tarefas.model.Tarefa;

public interface InterfaceTarefaDAO {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();
}
