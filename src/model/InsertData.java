/*
    Esta classe é responsável por inserir dados na tabela de produtos.
*/
package model;

import controller.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    
    // Declaração das variáveis, inicializando-as com null
    private Connection conn = null;
    private PreparedStatement st = null;
    
    // Método para inserir um produto na tabela
    public void insertProduct(String product, Integer quantity) {
        // Cria uma instância da classe DbConnection
        DbConnection db = new DbConnection();
        
        // Captura uma exceção caso ocorra
        try {
            // Comando SQL para inserir dados na tabela de produtos
            String query = "INSERT INTO products(product, quantity) VALUES(?, ?)";
            // Abre a conexão com o banco de dados
            conn = db.openConexao();
            // Prepara uma instrução SQL parametrizada
            st = conn.prepareStatement(query);
            // Define os parâmetros da consulta parametrizada
            st.setString(1,product);
            st.setInt(2, quantity);
            
            // Executa a consulta SQL e retorna o número de linhas modificadas
            int op = st.executeUpdate();
            // Caso a operação tenha sucesso, exibe uma mensagem informativa
            if (op > 0) {
                // Cria uma instância da classe Message
                Message message = new Message();
                // Chama a função para exibir uma mensagem informativa
                message.informationMessage("Dado Salvo!");
            }
            
        } catch (SQLException e) {
            // Pode adicionar um tratamento de exceção apropriado aqui
        } finally {
            // Finaliza o statement e conexão
            db.closeStatement(st);
            db.closeConnection();    
        }
    }
}
