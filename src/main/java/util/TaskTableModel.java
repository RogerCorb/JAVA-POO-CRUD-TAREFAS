

package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

// Criamos uma class TaskTableModel, e ela é quem vai apresentar as nossas 
// tarefas listadas no banco de dados, ela vai herdar da classe AbstractTableModel 
// alguns métodos, métodos que estão com @Override foram heerdados e são obriga
// tórios... Vamos aqui ainda criar nosso métodos e funções para deixar o modo 
// de tabela de tarefas pronto. é a mesma coisa que fizemos com o modo tabela 
// de projetos.
public class TaskTableModel extends AbstractTableModel {
    
    String[] columns = {"Nome","Descrição","Prazo","Tarefa Concluida","Editar","Excluir"};
    // Criamos um Vetor tipo String nome columns e informamos as colunas que vamos 
    // exibir em nossa tabela
    List<Task> tasks = new ArrayList();
    //Criammos um Array
    

    @Override // métodos foram importados herdados da classe pai
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return tasks.get(rowIndex).getName();                
            case 1:
                return tasks.get(rowIndex).getDescription();                
            case 2:
                return tasks.get(rowIndex).getDeadline();                
            case 3:
                return tasks.get(rowIndex).isIsCompleted();                
            case 4:
                return "";
            case 5:
                return "";
            default:
                return "Dados não encontrados";                
        }
    }  

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
}
