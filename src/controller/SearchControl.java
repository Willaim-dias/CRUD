/*
    Esta classe é responsável por controlar a classe SearchScreen.
*/
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DeleteData;
import model.GetData;
import model.InsertData;
import model.UpdateData;
import view.DbOperationsScreen;

public class SearchControl {

    // Declaração de variável estática que armazena a instância de SearchScreen
    private static DbOperationsScreen dps;

    // Construtor que recebe uma instância de SearchScreen e a atribui à variável ss
    public SearchControl(DbOperationsScreen dps) {
        this.dps = dps;
    }

    // Método para adicionar os dados na tabela da interface gráfica
    public void addDataTable() {
        DefaultTableModel dtm = (DefaultTableModel) dps.getDataTable().getModel();
        GetData gd = new GetData();
        List<Map<String, Object>> dadosList = gd.getProducts();

        dtm.setRowCount(0);

        if (dadosList != null && !dadosList.isEmpty()) {
            for (Map<String, Object> dados : dadosList) {
                Object[] obj = {dados.get("Id"), dados.get("product"), dados.get("quantity")};
                dtm.addRow(obj);
            }
        } else {
            dps.alert("Nenhum dado encontrado");
        }
    }

    // Método para pesquisar dados na tabela da interface gráfica
    public void searchData(String data) {
        DefaultTableModel dtm = (DefaultTableModel) dps.getDataTable().getModel();
        JTable table = dps.getDataTable();

        ArrayList<Object[]> temp = new ArrayList<>();

        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getValueAt(i, 1).equals(data) || table.getValueAt(i, 2).toString().equals(data)) {
                Object[] obj = {table.getValueAt(i, 0), table.getValueAt(i, 1), table.getValueAt(i, 2)};
                temp.add(obj);
            }
        }

        if (!temp.isEmpty()) {
            dtm.setRowCount(0);
            for (Object obj : temp) {
                dtm.addRow((Object[]) obj);
            }
        } else {
            dps.alert("Nome ou idade não encontrado!");
        }
    }

    // Método para adicionar um produto à tabela
    public void addProduct(String product, String quantity){
        // Cria uma instância da classe InsertData
        InsertData insertData = new InsertData();
        // Chama a função para inserir um dado
        insertData.insertProduct(product, Integer.valueOf(quantity));
    }
    
    // Método para alterar um produto na tabela
    public void alterProduc(String id, String product, String quantity) {
        // Cria uma instância da classe UpdateData
        UpdateData updateData = new UpdateData();
        // Chama a função para alterar um dado
        updateData.UpdateData(Integer.parseInt(id), product, Integer.parseInt(quantity));
    }
    
    // Método para remover um produto da tabela
    public void removeProduct(String id) {
        // Cria uma instância da classe DeleteData
        DeleteData  deleteData = new DeleteData();
        // Chama a função para deletar um dado
        deleteData.deleteProduct(Integer.parseInt(id));
    }
}
