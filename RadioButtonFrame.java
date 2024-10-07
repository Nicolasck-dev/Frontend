import java.awt.Color;
import java.awt.FlowLayout; // Importa FlowLayout para definir o layout da janela.
import java.awt.Font; // Importa a classe Font para manipular estilos de fonte.
import java.awt.event.ItemListener; // Importa a interface ItemListener para escutar eventos dos botões de rádio.
import java.awt.event.ItemEvent; // Importa a classe ItemEvent para representar eventos de seleção de itens.
import javax.swing.JFrame; // Importa JFrame para criar a janela principal.
import javax.swing.JTextField; // Importa JTextField para exibir texto editável.
import javax.swing.JRadioButton; // Importa JRadioButton para criar botões de rádio.
import javax.swing.ButtonGroup; // Importa ButtonGroup para agrupar botões de rádio, permitindo seleção única.

public class RadioButtonFrame extends JFrame // Declarando a classe que herda de JFrame para criar a janela.
{
   private JTextField textField; // Campo de texto que exibirá a frase com diferentes estilos de fonte.
   private Font plainFont, boldFont, italicFont, boldItalicFont; // Declaração de fontes para diferentes estilos.
   private Color blackColor, redColor, blueColor, yellowColor;
   private JRadioButton plainJRadioButton, boldJRadioButton, italicJRadioButton, boldItalicJRadioButton;  // Botões de rádio para selecionar os estilos de fonte.
   private ButtonGroup radioGroup;
   private ButtonGroup colorRadioGroup;
   private JRadioButton blackJRadioButton, redJRadioButton, blueJRadioButton, yellowJRadioButton; // Grupo de botões que garante seleção única entre os botões de rádio.

   public RadioButtonFrame() // Construtor da classe.
   {
      super("RadioButton Test"); // Define o título da janela.
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout.

      textField = new JTextField("Watch the font style change", 25); // Cria o campo de texto com tamanho de 25 colunas.
      add(textField); // Adiciona o campo de texto à janela.

      // Cria os botões de rádio com diferentes estilos de fonte.
      plainJRadioButton = new JRadioButton("Plain", true); // "Plain" será o botão de rádio selecionado por padrão.
      boldJRadioButton = new JRadioButton("Bold", false);
      italicJRadioButton = new JRadioButton("Italic", false);
      boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
      // Adiciona os botões de rádio à janela.
      add(plainJRadioButton); 
      add(boldJRadioButton); 
      add(italicJRadioButton); 
      add(boldItalicJRadioButton); 

      // Agrupa os botões de rádio para garantir que apenas um seja selecionado por vez.
      radioGroup = new ButtonGroup(); 
      radioGroup.add(plainJRadioButton); 
      radioGroup.add(boldJRadioButton); 
      radioGroup.add(italicJRadioButton); 
      radioGroup.add(boldItalicJRadioButton); 

      // Define as fontes que serão usadas ao selecionar os botões de rádio.
      plainFont = new Font("Serif", Font.PLAIN, 14); // Fonte normal.
      boldFont = new Font("Serif", Font.BOLD, 14); // Fonte negrito.
      italicFont = new Font("Serif", Font.ITALIC, 14); // Fonte itálica.
      boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // Fonte negrito e itálica.
      textField.setFont(plainFont); // Define a fonte inicial do campo de texto como "Plain".

      // Adiciona ouvintes de eventos aos botões de rádio, alterando a fonte conforme a seleção.
   plainJRadioButton.addItemListener(
      new RadioButtonHandler(plainFont));
   boldJRadioButton.addItemListener(
      new RadioButtonHandler(boldFont));
   italicJRadioButton.addItemListener(
      new RadioButtonHandler(italicFont));
   boldItalicJRadioButton.addItemListener(
      new RadioButtonHandler(boldItalicFont));

      blackJRadioButton = new JRadioButton("Black", true); // "Plain" será o botão de rádio selecionado por padrão.
      redJRadioButton = new JRadioButton("Red", false);
      blueJRadioButton = new JRadioButton("Blue", false);
      yellowJRadioButton = new JRadioButton("Yellow", false);
      // Adiciona os botões de rádio à janela.
      add(blackJRadioButton); 
      add(redJRadioButton); 
      add(blueJRadioButton); 
      add(yellowJRadioButton); 

      // Agrupa os botões de rádio para garantir que apenas um seja selecionado por vez.
      colorRadioGroup = new ButtonGroup(); 
      colorRadioGroup.add(blackJRadioButton); 
      colorRadioGroup.add(redJRadioButton); 
      colorRadioGroup.add(blueJRadioButton); 
      colorRadioGroup.add(yellowJRadioButton); 

      // Define as fontes que serão usadas ao selecionar os botões de rádio.
      blackColor = Color.BLACK;
      redColor = Color.RED; // Colore negrito.
      blueColor = Color.BLUE; 
      yellowColor = Color.YELLOW;
      textField.setForeground(blackColor); // Define a fonte inicial do campo de texto como "Plain".

      // Adiciona ouvintes de eventos aos botões de rádio, alterando a fonte conforme a seleção.
      blackJRadioButton.addItemListener(
         new ColorRadioButtonHandler(blackColor));
      redJRadioButton.addItemListener(
         new ColorRadioButtonHandler(redColor));
      blueJRadioButton.addItemListener(
         new ColorRadioButtonHandler(blueColor));
      yellowJRadioButton.addItemListener(
         new ColorRadioButtonHandler(yellowColor));
   } 

   // Classe interna para manipular os eventos dos botões de rádio.
   private class RadioButtonHandler implements ItemListener 
   {
      private Font font; // Armazena a fonte a ser aplicada.

      public RadioButtonHandler(Font f) // Construtor que inicializa a fonte.
      {
         font = f; 
      } 
   
      @Override
      public void itemStateChanged(ItemEvent event) // Método que será chamado quando o estado do botão mudar.
      {
         textField.setFont(font); // Altera a fonte do campo de texto com base no botão selecionado.
      } 
   } 
   private class ColorRadioButtonHandler implements ItemListener 
   {
      private Color color; // Armazena a fonte a ser aplicada.

      public ColorRadioButtonHandler(Color c) // Construtor que inicializa a fonte.
      {
         color = c; 
      } 
   
      @Override
      public void itemStateChanged(ItemEvent event) // Método que será chamado quando o estado do botão mudar.
      {
         textField.setForeground(color); // Altera a fonte do campo de texto com base no botão selecionado.
      } 
   } 
}
