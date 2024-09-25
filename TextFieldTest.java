
import javax.swing.JFrame; //importando o pacote javax

public class TextFieldTest // declaração da classe 'TextFieldTest'
{ // inicio do bloco de codigos da classe 'TextFieldTest'
   public static void main(String[] args) // declaração do metodo 'main' (principal) metodo executor
   { // inicio do bloco de codigos do metodo 'main'
      TextFieldFrame textFieldFrame = new TextFieldFrame(); // declaração da variavel 'textFieldFrame' depois atibuição de um novo 'new' objeto 'TextFieldFrame' 
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ira buscar a variavel 'ECIT_ON_CLOSE' que esta dentro do JFrame
      textFieldFrame.setSize(350, 100); // definir o tamanho
      textFieldFrame.setVisible(true);  // ira definir a visibilidade
   } // fim do bloco de codigos do metodo 'main'
}  // fim do bloco de codigos da classe

