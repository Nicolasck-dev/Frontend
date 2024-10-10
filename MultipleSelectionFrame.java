import java.awt.*; // Importa o layout que organiza os componentes em linha
import java.awt.event.*; // Importa a interface para ouvir ações (cliques, etc.)
import javax.swing.*; // Importa a classe JFrame para criar a janela

public class MultipleSelectionFrame extends JFrame // Define a classe MultipleSelectionFrame que herda de JFrame
{
   private final JList<String> colorJList; // Lista para selecionar cores
   private final JList<String> copyJList; // Lista onde as cores selecionadas serão copiadas
   private JButton copyJButton; // Botão para copiar as cores selecionadas
   private static final String[] colorNames = { // Array de nomes de cores
      "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", 
      "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};

      private final JList<String> fruitJList; // Lista para selecionar cores
   private final JList<String> cloneJList; // Lista onde as cores selecionadas serão copiadas
   private JButton cloneJButton; // Botão para copiar as cores selecionadas
   private static final String[] fruitNames = { 
      "Apple", "Banana", "Cherry","Fig", "Grape", 
      "Kiwi", "Lemon", "Mango", "Orange", "Peach", "Pineapple", "Strawberry"};


   public MultipleSelectionFrame() // Construtor da classe MultipleSelectionFrame
   {
      super("Multiple Selection Lists"); // Define o título da janela
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout

      colorJList = new JList<String>(colorNames); // Cria a JList com os nomes das cores
      colorJList.setVisibleRowCount(5); // Define o número de linhas visíveis na lista
      colorJList.setSelectionMode( // Permite múltiplas seleções de itens na lista
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(colorJList)); // Adiciona a lista com uma barra de rolagem à janela

      copyJButton = new JButton("Copy >>>"); // Cria o botão para copiar os itens selecionados
      copyJButton.addActionListener( // Adiciona um ouvinte de eventos para o botão
         new ActionListener() 
         {  
            @Override
            public void actionPerformed(ActionEvent event) // Método chamado ao clicar no botão
            {
               // Copia os itens selecionados de colorJList para copyJList
               copyJList.setListData(
                  colorJList.getSelectedValuesList().toArray( // Converte a lista selecionada em um array de Strings
                     new String[0]));
            }
         } 
      ); 

      add(copyJButton); // Adiciona o botão à janela

      copyJList = new JList<String>(); // Cria a lista vazia para copiar os itens selecionados
      copyJList.setVisibleRowCount(5); // Define o número de linhas visíveis na lista
      copyJList.setFixedCellWidth(100); // Define a largura fixa das células da lista
      copyJList.setFixedCellHeight(15); // Define a altura fixa das células da lista
      copyJList.setSelectionMode( // Permite selecionar apenas um intervalo contínuo de itens
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList)); // Adiciona a lista com uma barra de rolagem à janela

//-------////-------////-------////-------////-------////-------////-------////-------////-------////-------////-------////-------////-------////-------////-------////-------////-------////-------///-------//



      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout

      fruitJList = new JList<String>(fruitNames); // Cria a JList com os nomes das cores
      fruitJList.setVisibleRowCount(5); // Define o número de linhas visíveis na lista
      fruitJList.setSelectionMode( // Permite múltiplas seleções de itens na lista
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(fruitJList)); // Adiciona a lista com uma barra de rolagem à janela

      cloneJButton = new JButton("Copy >>>"); // Cria o botão para copiar os itens selecionados
      cloneJButton.addActionListener( // Adiciona um ouvinte de eventos para o botão
         new ActionListener() 
         {  
            @Override
            public void actionPerformed(ActionEvent event) // Método chamado ao clicar no botão
            {
               // Copia os itens selecionados de colorJList para cloneJList
               cloneJList.setListData(
                  fruitJList.getSelectedValuesList().toArray( // Converte a lista selecionada em um array de Strings
                     new String[0]));
            }
         } 
      ); 

      add(cloneJButton); // Adiciona o botão à janela

      cloneJList = new JList<String>(); // Cria a lista vazia para copiar os itens selecionados
      cloneJList.setVisibleRowCount(5); // Define o número de linhas visíveis na lista
      cloneJList.setFixedCellWidth(100); // Define a largura fixa das células da lista
      cloneJList.setFixedCellHeight(15); // Define a altura fixa das células da lista
      cloneJList.setSelectionMode( // Permite selecionar apenas um intervalo contínuo de itens
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(cloneJList)); // Adiciona a lista
   } 
}
