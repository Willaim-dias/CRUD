package view;

import controller.SearchControl;
/*
    Esta classe é responsável por exibir a tela de DbOperationsScreen e manipular os eventos relacionados a ela.
*/
import javax.swing.JOptionPane;

import javax.swing.JTable;

public class DbOperationsScreen extends javax.swing.JFrame {

    // Declaração de variável estática que armazena a instância de SearchControl
    private static SearchControl sc;

    // Construtor que inicializa os componentes da tela e instancia SearchControl
    public DbOperationsScreen() {
        initComponents();
        sc = new SearchControl(this);
        sc.addDataTable();
    }

    // Componentes visuais da tela
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeral = new javax.swing.JPanel();
        panelPesquiza = new javax.swing.JPanel();
        txtProduct = new javax.swing.JTextField();
        labelTitle1 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lableTitle2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnAlter = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Db Operaçoes");

        panelPesquiza.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelPesquiza.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelPesquiza.add(txtProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, 30));

        labelTitle1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTitle1.setText("Produto:");
        panelPesquiza.add(labelTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, -1));
        panelPesquiza.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 180, 30));

        lableTitle2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lableTitle2.setText("Quantidade:");
        panelPesquiza.add(lableTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 190, -1));

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        panelPesquiza.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 80, 90, 30));

        btnAlter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlter.setText("Alterar");
        btnAlter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterActionPerformed(evt);
            }
        });
        panelPesquiza.add(btnAlter, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 90, 30));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Deletar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panelPesquiza.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 90, 30));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setText("Atualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelPesquiza.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, 30));

        dataTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Produto", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(dataTable);

        javax.swing.GroupLayout panelGeralLayout = new javax.swing.GroupLayout(panelGeral);
        panelGeral.setLayout(panelGeralLayout);
        panelGeralLayout.setHorizontalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelPesquiza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGeralLayout.setVerticalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPesquiza, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Método para atualizar os dados da tabela
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        sc.addDataTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Método para salvar um novo produto
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtProduct.getText().equals("") || txtQuantity.getText().equals("")) {
            alert("Preencha ambos os campos");
        } else {
            sc.addProduct(txtProduct.getText(), txtQuantity.getText());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    // Método para alterar um produto existente
    private void btnAlterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterActionPerformed
        if (dataTable.getSelectedRow() > 0) {
            if (txtProduct.getText().equals("") || txtQuantity.getText().equals("")) {
                alert("Preencha ambos os campos");
            } else {
                sc.alterProduc(dataTable.getValueAt(dataTable.getSelectedRow(), 0).toString(), txtProduct.getText(), txtQuantity.getText());
            }
        } else {
            alert("Selecione uma linha");
        }
    }//GEN-LAST:event_btnAlterActionPerformed

    // Método para remover um produto
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (dataTable.getSelectedRow() > 0) {
            sc.removeProduct(dataTable.getValueAt(dataTable.getSelectedRow(), 0).toString());
        } else {
            alert("Selecione uma linha");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Método para exibir os dados do produto selecionado nos campos de texto
    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        txtProduct.setText(dataTable.getValueAt(dataTable.getSelectedRow(), 1).toString());
        txtQuantity.setText(dataTable.getValueAt(dataTable.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_dataTableMouseClicked

    // Método main
    public static void main(String args[]) {
        // Configura o visual da aplicação
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DbOperationsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // Inicializa a tela de pesquisa
        java.awt.EventQueue.invokeLater(() -> {
            new DbOperationsScreen().setVisible(true);
        });
    }

    // Método getter para obter a tabela de dados
    public JTable getDataTable() {
        return dataTable;
    }

    // Método para exibir uma mensagem de alerta
    public void alert(String message) {
        JOptionPane.showMessageDialog(this, message, "Alerta", JOptionPane.INFORMATION_MESSAGE);
    }

    // Componentes visuais
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlter;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTable dataTable;
    private javax.swing.JLabel labelTitle1;
    private javax.swing.JLabel lableTitle2;
    private javax.swing.JPanel panelGeral;
    private javax.swing.JPanel panelPesquiza;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField txtProduct;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
