import javax.swing.JFrame; // Importa a classe JFrame da biblioteca Swing, que é usada para criar interfaces gráficas.

public class CheckBoxTest // Define a classe CheckBoxTest, que será o ponto de entrada da aplicação.
{
   
   public static void main(String[] args)  // Método main: ponto de entrada da aplicação.
   {
      CheckBoxFrame checkBoxFrame = new CheckBoxFrame(); // Cria uma nova instância da classe CheckBoxFrame, que deve estender JFrame.
      
      checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação de fechamento: encerra a aplicação ao fechar a janela.
      
      checkBoxFrame.setSize(275, 100); // Define o tamanho da janela (largura: 275px, altura: 100px).
      
      checkBoxFrame.setVisible(true); // Torna a janela visível na tela.
   } 
}
