
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;


public class ProjectController {
    
     public void save(Project project){
        
        String sql="INSERT INTO projects(name,description,createdAt,updatedAt)"+
                "VALUES (?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement= null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            // Para Visualizar o valor de statement e de connection
            //System.out.println(statement);
            //System.out.println(connection);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescripition());
            statement.setDate(3,new Date(project.getCreatedAt().getTime()));
            statement.setDate(4,new Date(project.getUpdatedAt().getTime()));
            
            statement.execute();
            
        } catch (SQLException ex) { 
            throw new RuntimeException("Erro ao salvar a tarefa",ex);
        } finally { 
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
   
    // Atualiza o banco de dados
    public void update(Project project){
        String sql = "UPDATE projects SET "                
                +"name= ?,"
                +"description=?,"                
                +"createdAt=?,"
                +"updatedAt=? "
                + "WHERE id=?";
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
            statement.setString(1, project.getName());                        
            statement.setString(2, project.getDescripition());            
            statement.setDate(3,new Date(project.getCreatedAt().getTime()));
            statement.setDate(4,new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5,project.getId());
            
            // Executando a query                   
            statement.execute();
            
        } catch (SQLException ex) { 
            throw new RuntimeException("Erro ao Atualizar a tarefa",ex);
        } finally { 
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void removeById(int idProject){
        
        String sql = "DELETE FROM projects WHERE id = ?"; // Montamos o comando
        // Comando SQL  responsável por deletar uma tarefa
        Connection connection = null; // Criamos a variavel conn para ser a conexão
        PreparedStatement statement=null;
        try {
            // Criação da conexão com o banco de dados 
            connection = ConnectionFactory.getConnection(); // pegando a conexão
            //Preparando a query 
            statement = connection.prepareStatement(sql); // preparando o comando SQL
            
            // setando os valores 
            statement.setInt(1,idProject); // setar o parametro do ID = ?
            
            // executando a query ou comando 
            statement.execute();  
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa",ex);            
        } finally { 
            ConnectionFactory.closeConnection(connection,statement);//fechamos a conexão com BD             
        }        
    }
    
    public List<Project> getAll(){
        
        String sql = "SELECT * FROM  projects";
        Connection connection = null;
        PreparedStatement statement= null;        
        ResultSet  resultSet = null; // quando faço um SELECT pego o resultado aqui
        //Lista de tarefas que será devolvida quando a 
        // chamada do método acontecer
        List<Project> projects = new ArrayList<>();
        
        
        try{
         connection = ConnectionFactory.getConnection();
         statement = connection.prepareStatement(sql);
         
         resultSet = statement.executeQuery();
         
         while(resultSet.next()){
             Project project=new Project();
             project.setId(resultSet.getInt("id"));             
             project.setName(resultSet.getString("name"));
             project.setDescripition(resultSet.getString("description"));             
             project.setCreatedAt(resultSet.getDate("createdAt"));
             project.setUpdatedAt(resultSet.getDate("updatedAt"));
             projects.add(project);             
          }          
         
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao Listar tarefa",ex);
        } finally {
          ConnectionFactory.closeConnection(connection, statement, resultSet);
        }        
        // lista de tarefas que foi criada e carregada do banco de dados 
        return projects;        
        }
    }   
