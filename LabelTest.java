// A linha abaixo importara o componente JFrame no modulo swing da biblioteca (pacote) javax
import javax.swing.JFrame;

// A linha abaixo esta declarando a classe LabelTest
public class LabelTest 
// A linha abaixo esta iniciando os codigos da classe LabelTest
{
// A linha abaixo declarando o metodo main
   public static void main(String[] args)
// A linha abaixo esta declarando a variavel LabelFrame
   { 
      // linha abaixo variavel é do tipo LabelFrame, esta sendo criada a partir do mesmo construtor, labelFrame com "l" minusculo é uma variavel
      LabelFrame labelFrame = new LabelFrame(); 
      // A linha abaixo o ponto esta declarando um metodo que esta ddefinindo "set" uma operação "Operation" de fechamento "Close"  padrao "Defalut"
      // Dentro do componente (JFrame) esta invocando atraves do ponto a variavel (EXIT_ON_CLOSE)
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // A linha abaixo (setSize) ira definir o tamanho
      labelFrame.setSize(260, 180); 
      // A linha abaixo (setVisible) tornara visivel
      labelFrame.setVisible(true); 
   }  // encerrando o bloco de codigos do metodo (main)
} // encerrando o bloco de codigos da classe (LabelTest)