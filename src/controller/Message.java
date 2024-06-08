/*
    Esta classe é responsável por exibir mensagens de alerta ou informativas
*/
package controller;

import javax.swing.JOptionPane;

public class Message {
    // Construtor sem parâmetros
    public Message() {
    }
    
    // Função para exibir mensagens de alerta
    public void alertMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Alerta", JOptionPane.WARNING_MESSAGE);     
    }
    // Função para exibir mensagens informativas
    public void informationMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Mensagem", JOptionPane.INFORMATION_MESSAGE); 
    }
}
