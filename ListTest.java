import javax.swing.JFrame; // Importa a classe JFrame para criar a janela

public class ListTest 
{
   public static void main(String[] args)
   { 
      ListFrame listFrame = new ListFrame(); // Cria uma instância da classe ListFrame (janela personalizada)
      listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento de fechar o programa ao fechar a janela
      listFrame.setSize(350, 150); // Define o tamanho da janela (largura 350, altura 150)
      listFrame.setVisible(true); // Torna a janela visível
   } 
}
