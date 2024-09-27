import java.awt.FlowLayout; // saida das camadas "renderização"
import java.awt.event.ActionListener; // exibição de telas ao clicar nos botoes
import java.awt.event.ActionEvent; // exibição de telas ao clicar nos botoes
import javax.swing.JFrame; // fornecer toda a extrutura ja pronta
import javax.swing.JButton; // componente JButton 'botao'
import javax.swing.Icon; // icone responsavel pelo 'fancy button'
import javax.swing.ImageIcon; // carregar a imagen
import javax.swing.JOptionPane; // mensagem que ira aparacer ao clicar nos botões

public class ButtonFrame extends JFrame // declaração da classe 'ButtonFrame' herdando 'JFrame'
{ // inicio do bloco de codigos da classe 'ButtonFrame'
   private final JButton plainJButton; // declaraçoes de variaveis
   private final JButton fancyJButton; // 'private' uso exclusivo da classe 'final' não pode ser alterado

   
   public ButtonFrame() // construtor com o mesmo nome da classe/arquivo
   {
      super("Testing Buttons"); // definidor do titulo
      setLayout(new FlowLayout()); // ira definir o layout

      plainJButton = new JButton("Plain Button"); // atribuindo o objeto 'Plain Button'
      add(plainJButton); // adicionando o 'plain button' 

      Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif")); // declarando uma variavel, atribuindo um novo objeto 'ImageIcon', onde esta sendo atribuido um parametro '()', invocando a umagem '.getResource'
      Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif")); 
      fancyJButton = new JButton("Fancy Button", bug1); // 'fancyJButton' esta sendo atribuido ao 'JBtutton' 
      fancyJButton.setRolloverIcon(bug2); // estando sendo invocado o metodo 'setRolloverIcon' interação com o icon, trocando os icons entre eles ao rolar o mouse por cima
      add(fancyJButton); 

      ButtonHandler handler = new ButtonHandler(); // manipulador 'handler', declarando a variavel 'handler' do tipo 'ButtonHandler' 
      fancyJButton.addActionListener(handler); // declarando a variavel 'fancyJButton', atribuindo 'addActionListener' para enviar dentro dele 'handler'
      plainJButton.addActionListener(handler); // declarando a variavel 'plainJButton', atribuindo 'addActionListener' para enviar dentro dele 'handler'
   }

   private class ButtonHandler implements ActionListener // declarando a classe 'ButtonHandler', importando 'ActionListener' como objeto
   { //new ActionListener(
      @Override
      public void actionPerformed(ActionEvent event) // declaração do metodo 
      {
         JOptionPane.showMessageDialog(ButtonFrame.this, String.format( // Exibe uma caixa de diálogo com uma mensagem informando qual botão foi pressionado
            "You pressed: %s", event.getActionCommand())); // Formata a mensagem para incluir o comando de ação do evento
      }
   } // fim do metodo
} // fim da classe
