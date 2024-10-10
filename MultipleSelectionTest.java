import javax.swing.JFrame; // Importa a classe JFrame para criar a janela

public class MultipleSelectionTest // Define a classe principal chamada MultipleSelectionTest
{
   public static void main(String[] args) // Método principal que inicia a execução do programa
   { 
      MultipleSelectionFrame multipleSelectionFrame = // Cria uma instância de MultipleSelectionFrame (janela personalizada)
         new MultipleSelectionFrame(); 
      multipleSelectionFrame.setDefaultCloseOperation( // Define o comportamento de fechar o programa ao fechar a janela
         JFrame.EXIT_ON_CLOSE);
      multipleSelectionFrame.setSize(700, 150); // Define o tamanho da janela (700x150 pixels)
      multipleSelectionFrame.setVisible(true); // Torna a janela visível
   } 
}
