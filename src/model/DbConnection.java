/*
 Esta classe é responsável por abrir e fechar a conexão com o banco de dados.
*/
package model;

import controller.Message;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

    // Cria uma instância da classe Message
    Message message = new Message();

    // Cria uma variável iniciada com null
    private Connection connection = null;

    // Construtor sem parâmetros
    public DbConnection() {
    }

    // Função responsável por criar a conexão com o banco de dados
    public Connection openConexao() throws SQLException {
        // Procura o banco de dados no diretório principal
        File file = new File("stock.db");
        
        // Verifica a resposta
        if (file.exists()) {
            // Verifica se a variável connection já possui uma conexão
            if (connection == null) {
                // Cria a conexão com o banco de dados
                return connection = DriverManager.getConnection("jdbc:sqlite:stock.db");
            } else {
                // Retorna a conexão caso já tenha sido aberta
                return connection;
            }
        } else {
            // Se o banco de dados não for encontrado, retorna uma mensagem de alerta
            message.alertMessage("Banco de Dados não encontrado!");
            // Finaliza a execução do programa
            System.exit(0);
            return null;
        }
    }

    // Função para fechar a conexão
    public void closeConnection() {
        // Captura uma exceção caso ocorra
        try {
            // Fecha a conexão
            connection.close();
        } catch (SQLException ex) {
            // Pode adicionar um tratamento de exceção apropriado aqui
        }
    }

    // Função para finalizar o statement
    public static void closeStatement(Statement st) {
        // Verifica se o statement é diferente de null
        if (st != null) {
            // Captura uma exceção caso ocorra
            try {
                // Finaliza o statement
                st.close();
            } catch (SQLException e) {
                // Pode adicionar um tratamento de exceção apropriado aqui
            }
        }
    }
}
