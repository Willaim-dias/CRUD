/*
    Esta classe é responsável por recuperar todos os dados da tabela de produtos.
*/
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetData {

    // Declaração das variáveis, inicializando-as com null
    private Connection conn = null;
    private Statement st = null;

    // Método para obter todos os produtos da tabela
    public List<Map<String, Object>> getProducts() {
        // Cria uma instância da classe DbConnection
        DbConnection db = new DbConnection();

        // Captura uma exceção caso ocorra
        try {
            // Abre a conexão com o banco de dados
            conn = db.openConexao();
            // Cria um statement para executar a consulta SQL
            st = conn.createStatement();

            // Comando SQL para selecionar todos os dados da tabela de produtos
            String query = "SELECT * FROM products";

            // Executa a consulta SQL e obtém o resultado
            ResultSet resultSet = st.executeQuery(query);

            // Cria uma lista para armazenar os resultados da consulta, onde cada resultado é representado por um mapa de coluna-valor
            List<Map<String, Object>> resultList = new ArrayList<>();

            // Obtém os metadados do resultado da consulta para obter informações sobre as colunas
            ResultSetMetaData metaData = resultSet.getMetaData();
            // Obtém o número de colunas no resultado da consulta
            int columnCount = metaData.getColumnCount();

            // Itera sobre cada linha do resultado da consulta
            while (resultSet.next()) {
                // Cria um mapa para armazenar os valores de cada coluna para a linha atual
                Map<String, Object> row = new HashMap<>();
                // Itera sobre cada coluna da linha atual
                for (int i = 1; i <= columnCount; i++) {
                    // Obtém o nome da coluna
                    String columnName = metaData.getColumnName(i);
                    // Obtém o valor da coluna
                    Object value = resultSet.getObject(i);
                    // Adiciona o par coluna-valor ao mapa
                    row.put(columnName, value);
                }
                // Adiciona o mapa representando a linha atual à lista de resultados
                resultList.add(row);
            }

            // Retorna a lista de resultados
            return resultList;
        } catch (SQLException e) {
            // Pode adicionar um tratamento de exceção apropriado aqui
        } finally {
            // Finaliza o statement e conexão
            db.closeStatement(st);
            db.closeConnection();
        }
        // Retorna null em caso de erro
        return null;
    }
}
