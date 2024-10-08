import java.awt.*; // Importa o layout que organiza os componentes em linha
import java.awt.event.*; // Importa o ouvinte para eventos de item
import javax.swing.*; // Importa a classe para criar a janela

public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; // Caixa de seleção para escolher imagens
   private final JLabel label; // Rótulo que exibirá o ícone selecionado

   private static final String[] names = // Array de nomes dos arquivos de imagem
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   private final Icon[] icons = { // Array que armazena os ícones carregados das imagens
      new ImageIcon(getClass().getResource(names[0])),
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3]))};

   public ComboBoxFrame() // Construtor da classe ComboBoxFrame
   {
      super("Testing JComboBox"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout

      imagesJComboBox = new JComboBox<String>(names); // Cria a JComboBox com os nomes das imagens
      imagesJComboBox.setMaximumRowCount(3); // Define o número máximo de itens visíveis na lista

      imagesJComboBox.addItemListener( // Adiciona um ouvinte de eventos para a JComboBox
         new ItemListener() 
         {
            @Override
            public void itemStateChanged(ItemEvent event) // Método que lida com mudanças de seleção
            {
               if (event.getStateChange() == ItemEvent.SELECTED) // Verifica se o item foi selecionado
                  label.setIcon(icons[ // Atualiza o ícone do JLabel com o ícone selecionado
                     imagesJComboBox.getSelectedIndex()]);
            } 
         } 
      ); 

      add(imagesJComboBox); // Adiciona a JComboBox à janela
      label = new JLabel(icons[0]); // Inicializa o JLabel com o primeiro ícone
      add(label); // Adiciona o JLabel à janela
   }
}
