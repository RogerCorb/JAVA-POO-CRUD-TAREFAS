
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConnectionFactory {
    // Criamos a class ConnectionFactory e setamos os 4 principais
    // atributos para a conexão do banco de dados
    public static final String DRIVER="com.mysql.jdbc.Driver";
    public static final String URL="jdbc:mysql://localhost:3306/todoapp";
    public static final String USER="root";
    public static final String PASS="";
    
    public static Connection getConnection(){
        try {
            // aqui as linhas de código que vão de fato 
            // conectar ao banco de dados
            Class.forName(DRIVER); // carrega o driver            
            
            return DriverManager.getConnection(URL,USER,PASS); // faz a conexão
        }catch (Exception ex) {
          throw new RuntimeException("Erro na conexão com o banco de dados",ex);
        }
    }
    public static void closeConnection(Connection connection){
        
            // Try trata pontos criticos que PODEM dar erro no programa
            // e trata o que fazer , se der tudo certo TRY executa o IF
            // e fecha a conexão
            // se der errado CATCH trata a rotina de exceção enviando
            // uma mensagem de erro.
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao fechar a conexão com"
                        +"o banco de dados",ex);
            }
    }
    
    public static void closeConnection(Connection connection,
            PreparedStatement statement){
        
            // Try trata pontos criticos que PODEM dar erro no programa
            // e trata o que fazer , se der tudo certo TRY executa o IF
            // e fecha a conexão e outro if fecha o statement 
            // se der errado CATCH trata a rotina de exceção enviando
            // uma mensagem de erro.
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao fechar a conexão com"
                        +"o banco de dados",ex);
            }
    }
    public static void closeConnection(Connection connection,
            PreparedStatement statement, ResultSet  resultSet){
        
            // Try trata pontos criticos que PODEM dar erro no programa
            // e trata o que fazer , se der tudo certo TRY executa o IF
            // e fecha a conexão e outro if fecha o statement 
            // se der errado CATCH trata a rotina de exceção enviando
            // uma mensagem de erro.
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao fechar a conexão com"
                        +"o banco de dados",ex);
            }
    }
}
