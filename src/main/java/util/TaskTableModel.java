

package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

// Criamos uma class TaskTableModel, e ela � quem vai apresentar as nossas 
// tarefas listadas no banco de dados, ela vai herdar da classe AbstractTableModel 
// alguns m�todos, m�todos que est�o com @Override foram heerdados e s�o obriga
// t�rios... Vamos aqui ainda criar nosso m�todos e fun��es para deixar o modo 
// de tabela de tarefas pronto. � a mesma coisa que fizemos com o modo tabela 
// de projetos.
public class TaskTableModel extends AbstractTableModel {
    
    String[] columns = {"Nome","Descri��o","Prazo","Tarefa Concluida","Editar","Excluir"};
    // Criamos um Vetor tipo String nome columns e informamos as colunas que vamos 
    // exibir em nossa tabela
    List<Task> tasks = new ArrayList();
    //Criammos um Array
    

    @Override // m�todos foram importados herdados da classe pai
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
                return "Dados n�o encontrados";                
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
