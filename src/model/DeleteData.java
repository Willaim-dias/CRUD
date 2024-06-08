/*
    Esta classe é responsável por deletar um dado da tabela produtos.
*/
package model;

import controller.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    
    // Declaração das variáveis, inicializando-as com null
    private Connection conn = null;
    private PreparedStatement st = null;
    
    // Função responsável por deletar um dado no banco de dados
    public void deleteProduct(int id) {
        // Cria uma instância da classe DbConnection
        DbConnection db = new DbConnection();
        // Captura uma exceção caso ocorra
        try {
            // Comando SQL para deletar um dado
            String query = "DELETE FROM products WHERE Id = ?";
            // Recebe a conexão da classe DbConnection
            conn = db.openConexao();
            
            // Prepara uma instrução SQL parametrizada
            st = conn.prepareStatement(query);
            // Define o parâmetro da consulta parametrizada
            st.setInt(1,id);
            
            // Executa a consulta SQL e retorna o número de linhas modificadas
            int op = st.executeUpdate();
            
            // Caso a operação tenha sucesso, exibe uma mensagem
            if (op > 0) {
                // Cria uma instância da classe Message
                Message message = new Message();
                // Chama a função para exibir uma mensagem informativa
                message.informationMessage("Dado removido!");
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
