package model;

import controller.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    
    private Connection conn = null;
    private PreparedStatement st = null;
    
    public void UpdateData(int id, String product, int quantity) {
        DbConnection db = new DbConnection();
        
        try {
            String query = "UPDATE products SET product = ?, quantity = ? WHERE Id = ?";
            conn = db.openConexao();
            
            st = conn.prepareStatement(query);
            
            st.setString(1, product);
            st.setInt(2, quantity);
            st.setInt(3,id);
            
            int op = st.executeUpdate();
            
            if (op > 0) {
                Message message = new Message();
                message.informationMessage("Dado Atualizado!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeStatement(st);
            db.closeConnection();    
        }
    }
}
