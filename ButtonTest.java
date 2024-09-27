import javax.swing.JFrame; // importando o componente 

public class ButtonTest 
{ // inicio do bloco de codigos da classe
   public static void main(String[] args) // declaração do metodo main, metodo executor
   { // inicio do bloco de codigos do metodo principal
      ButtonFrame buttonFrame = new ButtonFrame(); // declaração da variavel 'ButtonFrame' 
      buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // definindo a operação de fechamento padrao
      buttonFrame.setSize(275, 150); // definindo tamanho e largura
      buttonFrame.setVisible(true); //definindo a visibilidade
   } 
}