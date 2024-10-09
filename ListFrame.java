import java.awt.*; // Importa o layout que organiza os componentes em linha
import javax.swing.*; // Importa a classe para criar a janela
import javax.swing.event.*; // Importa a interface para ouvir seleção de lista

public class ListFrame extends JFrame 
{
   private final JList<String> colorJList; // Lista de cores
   private static final String[] colorNames = // Array de nomes das cores
      {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", 
       "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
   private static final Color[] colors = { // Array de objetos Color correspondentes aos nomes
      Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, 
      Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, 
      Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

      private final JList<String> sizeJList;
      private static final String[] sizeNames =
         {"Small", "Medium", "Big"};

   public ListFrame() // Construtor da classe ListFrame
   {
      super("List Test"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout

      colorJList = new JList<String>(colorNames); // Cria a JList com os nomes das cores
      colorJList.setVisibleRowCount(5); // Define o número de linhas visíveis na lista

      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite selecionar apenas um item por vez

      add(new JScrollPane(colorJList)); // Adiciona a lista à janela com uma barra de rolagem

      colorJList.addListSelectionListener( // Adiciona um ouvinte para eventos de seleção de itens
         new ListSelectionListener() 
         {
            @Override
            public void valueChanged(ListSelectionEvent event) // Método chamado quando a seleção muda
            {
               getContentPane().setBackground( // Altera a cor de fundo com base na cor selecionada
                  colors[colorJList.getSelectedIndex()]); // Pega o índice selecionado e usa a cor correspondente
            } 
         } 
      );
      sizeJList = new JList<String>(sizeNames);
      sizeJList.setVisibleRowCount(3);
     
      sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      add(new JScrollPane(sizeJList));

      sizeJList.addListSelectionListener(
         new ListSelectionListener()
         {
            @Override
            public void valueChanged(ListSelectionEvent event)
            {
               switch (sizeJList.getSelectedIndex()) {
                  case 0:
                     setSize(350, 150);
                     break;

                  case 1:
                     setSize(550, 350);
                     break;

                  case 2:
                     setSize(750, 550);
                     break;

                  default:
                     setSize(350,150);
                     break;
               }
            } 
         } 
      ); 
   }  
   
}
