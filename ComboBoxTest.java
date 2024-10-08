import javax.swing.*; // Importa a classe JFrame para criar a janela

public class ComboBoxTest // Define a classe principal chamada ComboBoxTest

{ // Inicia o bloco de codigos da classe
   public static void main(String[] args) // Método principal que inicia a execução do programa
   { // Inicia o bloco de codigos do metodo
      ComboBoxFrame comboBoxFrame = new ComboBoxFrame(); // Instancia a janela personalizada
      comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra a aplicação ao fechar a janela
      comboBoxFrame.setSize(350, 150); // Define o tamanho da janela
      comboBoxFrame.setVisible(true); // Torna a janela visível
   } 
} 
