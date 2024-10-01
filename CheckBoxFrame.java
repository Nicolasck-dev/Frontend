import java.awt.FlowLayout; // Importa a classe FlowLayout para gerenciar o layout dos componentes na janela.
import java.awt.Font; // Importa a classe Font para definir fontes de texto.
import java.awt.event.ItemListener; // Importa a interface ItemListener para executar eventos de item.
import java.awt.event.ItemEvent; // Importa a classe ItemEvent para lidar com eventos de item.
import javax.swing.JFrame; // Importa a classe JFrame para criar a janela da aplicação.
import javax.swing.JTextField; // Importa a classe JTextField para permitir a entrada de texto.
import javax.swing.JCheckBox; // Importa a classe JCheckBox para criar caixas de seleção.
import java.awt.font.*;
import java.util.*;

public class CheckBoxFrame extends JFrame  // Define a classe CheckBoxFrame, que esta herdando JFrame.
{
   private final JTextField textField; // Campo de texto que exibirá a mensagem com o estilo de fonte alterado.
   private final JCheckBox boldJCheckBox; // Checkbox para ativar o estilo de fonte em negrito.
   private final JCheckBox italicJCheckBox; // Checkbox para ativar o estilo de fonte itálico.
   private final JCheckBox underlineJCheckBox; // Checkbox para ativar o underline
   
   public CheckBoxFrame()  // Construtor da classe CheckBoxFrame.
   {
      super("JCheckBox Test"); // Chama o construtor da classe pai (JFrame) com o título da janela.
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout (componentes organizados em linha).
      
      // Cria um campo de texto com uma mensagem padrão e com largura de 20 colunas.
      textField = new JTextField("Watch the font style change", 20); 
      textField.setFont(new Font("Serif", Font.PLAIN, 14)); // Define a fonte do texto como "Serif", estilo normal, tamanho 14.
      add(textField); // Adiciona o campo de texto à janela.

      // Cria as checkboxes para estilos de fonte.
      boldJCheckBox = new JCheckBox("Bold"); // Checkbox para o estilo negrito.
      italicJCheckBox = new JCheckBox("Italic"); // Checkbox para o estilo itálico.
      underlineJCheckBox = new JCheckBox("Underline");
      add(boldJCheckBox); // Adiciona a checkbox de negrito à janela.
      add(italicJCheckBox); // Adiciona a checkbox de itálico à janela.
      add(underlineJCheckBox); // Adiciona a checkboc de underline à janela.

      // Cria uma instância do manipulador de eventos de checkbox.
      CheckBoxHandler handler = new CheckBoxHandler(); 
      // Adiciona o manipulador de eventos às checkboxes.
      boldJCheckBox.addItemListener(handler); 
      italicJCheckBox.addItemListener(handler); 
      underlineJCheckBox.addItemListener(handler);
   } 

   // Classe interna que implementa ItemListener para tratar eventos de checkbox.
   private class CheckBoxHandler implements ItemListener
   { 
      @Override // Indica que este método sobrescreve o método da interface ItemListener.
      public void itemStateChanged(ItemEvent event) // Método chamado quando o estado do item muda.
      {
         Font font = null; // Variável para armazenar a fonte a ser aplicada.
         
         // Verifica o estado das checkboxes para definir a fonte apropriada.
         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected()) // Se ambas as checkboxes estão selecionadas.
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // Define a fonte como negrito e itálico.
         else if (boldJCheckBox.isSelected()) // Se apenas a checkbox de negrito está selecionada.
            font = new Font("Serif", Font.BOLD, 14); // Define a fonte como negrito.
         else if (italicJCheckBox.isSelected()) // Se apenas a checkbox de itálico está selecionada.
            font = new Font("Serif", Font.ITALIC, 14); // Define a fonte como itálico.
         else // Se nenhuma checkbox está selecionada.
            font = new Font("Serif", Font.PLAIN, 14); // Define a fonte como normal.
         if (underlineJCheckBox.isSelected()) {
            font = textField.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            textField.setFont(font.deriveFont(attributes));
            font = new Font(attributes);

         }  

         textField.setFont(font); // Aplica a fonte selecionada ao campo de texto.
      } // fim do metodo
   } // fim da classe
} // fim da classe
