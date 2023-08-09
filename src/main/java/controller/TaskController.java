
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {
    
    //Criamos a classe TaskCrontroller para o banco de dados
    //de tarefas - Task , Agora vamos criar os metodos de acesso 
    // Salvar<save> , deletar<removeById> , listar<list>, modificar<update>
    // Objetos/metodos retorno vazio<void> apenas list return null
    public void save(Task task){
        
        String sql = "INSERT INTO tasks(idProject, name"
                +"description,completed,"
                +"notes,deadline,"
                +"createdAt,updatedAt) VALUES (?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement= null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4,task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6,new Date(task.getDeadline().getTime()));
            statement.setDate(7,new Date(task.getCreatedAt().getTime()));
            statement.setDate(8,new Date(task.getUpdatedAt().getTime()));
            statement.execute();
            
        } catch (Exception ex) { 
            throw new RuntimeException("Erro ao salvar a tarefa"
            + ex.getMessage(),ex);
        } finally { 
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
   
    // Atualiza o banco de dados
    public void update(Task task){
        String sql = "UPDATE tasks SET"
                +"idProject = ?,"
                + "name= ?,"
                +"description=?,completed=?,"
                +"notes=?,deadline=?,"
                +"createdAt=?,updatedAt=? "
                +"WHERE id=?";
        // Declaramos e atribuimos as variaveis connection e statement = null
        Connection connection = null;
        PreparedStatement statement= null;
        
        try {
            // Agora a variavel connection estabelece conexão ao BD
            // atraves do getConnection e a variavel statement recebe
            // os valores dos campos de sql que serão setados ou atualizados
            // pelos set abaixo informados
            connection = ConnectionFactory.getConnection();
            
            // setando os valor em statement 
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4,task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6,new Date(task.getDeadline().getTime()));
            statement.setDate(7,new Date(task.getCreatedAt().getTime()));
            statement.setDate(8,new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            // Executando a query 
            statement.execute();
            
        } catch (Exception ex) { 
            throw new RuntimeException("Erro ao Atualizar a tarefa"
            + ex.getMessage(),ex);
        } finally { 
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void removeById(int taskId) throws SQLException{
        
        String sql = "DELETE FROM tasks WHERE id = ?"; // Montamos o comando
        // SQL  responsável por deletar uma tarefa
        Connection connection = null; // Criamos a variavel conn para ser a conexão
        PreparedStatement statement=null;
        try {
            // Criação da conexão com o banco de dados 
            connection = ConnectionFactory.getConnection(); // pegando a conexão
            //Preparando a query 
            statement = connection.prepareStatement(sql); // preparando o comando SQL
            
            // setando os valores 
            statement.setInt(1,taskId); // setar o parametro do ID = ?
            
            // executando a query ou comando 
            statement.execute();  
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a tarefa"+
                    ex.getMessage(),ex);            
        } finally { 
            ConnectionFactory.closeConnection(connection,statement);//fechamos a conexão com BD             
        }        
    }
    
    public List<Task> getAll(int idProject){
        
        String sql = "SELECT * FROM  tasks WHERE idProject = ?,";
        Connection connection = null;
        PreparedStatement statement= null;        
        ResultSet  resultSet = null;
        //Lista de tarefas que será devolvida quando a 
        // chamada do método acontecer
        List<Task> tasks = new ArrayList<Task>();
        
        try{
         connection = ConnectionFactory.getConnection();
         statement = connection.prepareStatement(sql);
         statement.setInt(1, idProject);
         resultSet = statement.executeQuery();
         
         while(resultSet.next()){
             Task task=new Task();
             task.setId(resultSet.getInt("id"));
             task.setIdProject(resultSet.getInt("idProject"));
             task.setName(resultSet.getString("name"));
             task.setDescription(resultSet.getString("description"));
             task.setNotes(resultSet.getString("notes"));
             task.setIsCompleted(resultSet.getBoolean("completed"));
             task.setDeadline(resultSet.getDate("deadline"));
             task.setCreatedAt(resultSet.getDate("createdAt"));
             task.setUpdatedAt(resultSet.getDate("updatedAt"));
             tasks.add(task);             
          }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir a tarefa"+
                    ex.getMessage(),ex);
        } finally {
          ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        // lista de tarefas que foi criada e carregada do banco de dados 
        return tasks;        
        }
    }
