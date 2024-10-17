import java.awt.*; // Importa todas as classes da biblioteca AWT, necessárias para a criação de interfaces gráficas e manipulação de eventos.
import java.awt.event.*; // Importa todas as classes relacionadas a eventos da biblioteca AWT.
import javax.swing.*; // Importa todas as classes da biblioteca Swing, usada para criar componentes de interface gráfica.

public class MenuFrame2 extends JFrame // Define a classe MenuFrame2 que herda de JFrame, criando assim uma janela gráfica.
{
   private final Color[] colorValues = // Cria um array de objetos do tipo Color, com as cores disponíveis.
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};  // As cores disponíveis no array: Preto, Azul, Vermelho, Verde.
     
   private final JRadioButtonMenuItem[] colorItems; // Declara um array de itens de menu do tipo botão de rádio para cores.
   private final JRadioButtonMenuItem[] fonts; // Declara um array de itens de menu do tipo botão de rádio para fontes.
   private final JRadioButtonMenuItem[] sizes; // Declara um array de itens de menu do tipo botão de rádio para tamanhos de fonte.

   private final JCheckBoxMenuItem[] styleItems; // Declara um array de itens de menu do tipo checkbox para estilos de fonte.

   private final JLabel displayJLabel; // Declara um rótulo que exibirá o texto de exemplo.

   private final ButtonGroup fontButtonGroup; // Declara um grupo de botões para gerenciar as opções de fontes.
   private final ButtonGroup colorButtonGroup; // Declara um grupo de botões para gerenciar as opções de cores.
   private final ButtonGroup sizeButtonGroup; // Declara um grupo de botões para gerenciar as opções de tamanhos.

   private int style; // Variável usada para armazenar o estilo da fonte.

   private final int[] fontSizes = {12, 24, 48, 72}; // Array que armazena os tamanhos de fonte disponíveis.

   // Construtor da classe MenuFrame2
   public MenuFrame2()
   {
      super("Using JMenus"); // Chama o construtor da classe JFrame, definindo o título da janela como "Using JMenus". 

      JMenu fileMenu = new JMenu("File"); // Cria o menu "File".
      fileMenu.setMnemonic('F'); // Define o atalho de teclado para o menu "File" como a tecla 'F'.

      JMenuItem aboutItem = new JMenuItem("About..."); // Cria um item de menu chamado "About...".
      aboutItem.setMnemonic('A'); // Define o atalho de teclado para "About..." como a tecla 'A'.
      fileMenu.add(aboutItem); // Adiciona o item "About..." ao menu "File".
      aboutItem.addActionListener( // Adiciona um ActionListener para o item "About...", para lidar com cliques.
         new ActionListener()
         {  
            @Override // Sobrescreve o método actionPerformed do ActionListener.
            public void actionPerformed(ActionEvent event)
            {
               JOptionPane.showMessageDialog(MenuFrame2.this,
                  "This is an example\nof using menus", // Exibe uma caixa de diálogo com a mensagem "This is an example of using menus".
                  "About", JOptionPane.PLAIN_MESSAGE); // Define o título da caixa de diálogo como "About" com uma mensagem simples (PLAIN).
            }
         }
      );
 
      JMenuItem exitItem = new JMenuItem("Exit"); // Cria um item de menu chamado "Exit".
      exitItem.setMnemonic('x'); // Define o atalho de teclado para "Exit" como a tecla 'x'.
      fileMenu.add(exitItem); // Adiciona o item "Exit" ao menu "File".
      exitItem.addActionListener( // Adiciona um ActionListener para o item "Exit".
         new ActionListener() // Define uma ação a ser executada quando o item "Exit" for clicado.
         {
            @Override
            public void actionPerformed(ActionEvent event) // O método será chamado quando o item "Exit" for acionado.
            {
               System.exit(0); // Encerra o aplicativo.
            }
         }
      );

      JMenuBar bar = new JMenuBar(); // Cria uma barra de menu.
      setJMenuBar(bar); // Adiciona a barra de menu à janela.
      bar.add(fileMenu); // Adiciona o menu "File" à barra de menu.

      JMenu formatMenu = new JMenu("Format"); // Cria o menu "Format".
      formatMenu.setMnemonic('r'); // Define o atalho de teclado para o menu "Format" como a tecla 'r'.

      String[] colors = {"Black", "Blue", "Red", "Green"}; // Cria um array de strings com os nomes das cores disponíveis.

      JMenu colorMenu = new JMenu("Color"); // Cria o menu "Color".
      colorMenu.setMnemonic('C'); // Define o atalho de teclado para o menu "Color" como a tecla 'C'.

      colorItems = new JRadioButtonMenuItem[colors.length]; // Inicializa o array de botões de rádio para as cores, com o mesmo tamanho do array de cores.
      colorButtonGroup = new ButtonGroup(); // Cria um grupo de botões para gerenciar a seleção de cores.
      ItemHandler itemHandler = new ItemHandler(); // Cria um manipulador de eventos para lidar com as seleções de cores.

      // Cria os itens de menu do tipo botão de rádio para cada cor no array colors.
      for (int count = 0; count < colors.length; count++)
      {
         colorItems[count] =
            new JRadioButtonMenuItem(colors[count]); // Cria um botão de rádio para a cor correspondente no array.
         colorMenu.add(colorItems[count]); // Adiciona o botão de rádio ao menu "Color".
         colorButtonGroup.add(colorItems[count]); // Adiciona o botão de rádio ao grupo de botões de cor.
         colorItems[count].addActionListener(itemHandler); // Adiciona o manipulador de eventos ao botão de rádio.
      }

      colorItems[0].setSelected(true); // Define o primeiro item de cor (Black) como selecionado por padrão.

      formatMenu.add(colorMenu); // Adiciona o menu "Color" ao menu "Format".
      formatMenu.addSeparator(); // Adiciona um separador visual ao menu "Format".

      // Array com os nomes das fontes disponíveis.
      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};
      JMenu fontMenu = new JMenu("Font"); // Cria o menu "Font".
      fontMenu.setMnemonic('n'); // Define o atalho de teclado para o menu "Font" como a tecla 'n'.

      fonts = new JRadioButtonMenuItem[fontNames.length]; // Inicializa o array de botões de rádio para fontes, com o mesmo tamanho do array de fontes.
      fontButtonGroup = new ButtonGroup(); // Cria um grupo de botões para gerenciar as seleções de fontes.

      // Cria os itens de menu do tipo botão de rádio para cada fonte no array fontNames.
      for (int count = 0; count < fonts.length; count++)
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]); // Cria um botão de rádio para a fonte correspondente no array.
         fontMenu.add(fonts[count]); // Adiciona o botão de rádio ao menu "Font".
         fontButtonGroup.add(fonts[count]); // Adiciona o botão de rádio ao grupo de botões de fonte.
         fonts[count].addActionListener(itemHandler); // Adiciona o manipulador de eventos ao botão de rádio.
      }

      fonts[0].setSelected(true); // Define a primeira fonte (Serif) como selecionada por padrão.
      fontMenu.addSeparator(); // Adiciona um separador visual ao menu "Font".

      // Array com os nomes dos estilos disponíveis (Bold e Italic).
      String[] styleNames = {"Bold", "Italic"};
      styleItems = new JCheckBoxMenuItem[styleNames.length]; // Inicializa o array de itens de checkbox para estilos.
      StyleHandler styleHandler = new StyleHandler(); // Cria um manipulador de eventos para lidar com a seleção de estilos.

      // Cria os itens de menu do tipo checkbox para cada estilo no array styleNames.
      for (int count = 0; count < styleNames.length; count++)
      {
         styleItems[count] =
            new JCheckBoxMenuItem(styleNames[count]); // Cria um item de checkbox para o estilo correspondente.
         fontMenu.add(styleItems[count]); // Adiciona o item de checkbox ao menu "Font".
         styleItems[count].addItemListener(styleHandler); // Adiciona o manipulador de eventos ao item de checkbox.
      }

      fontMenu.addSeparator(); // Adiciona um separador visual ao menu "Font".

      sizes = new JRadioButtonMenuItem[fontSizes.length]; // Inicializa o array de botões de rádio para tamanhos de fonte, com base no array de tamanhos.
      sizeButtonGroup = new ButtonGroup(); // Cria um grupo de botões para gerenciar as seleções de tamanhos de fonte.

      // Cria os itens de menu do tipo botão de rádio para cada tamanho de fonte no array fontSizes.
      for (int count = 0; count < fontSizes.length; count++)
      {
         sizes[count] =
            new JRadioButtonMenuItem(String.valueOf(fontSizes[count])); // Cria um botão de rádio para o tamanho de fonte correspondente.
         fontMenu.add(sizes[count]); // Adiciona o botão de rádio ao menu "Font".
         sizeButtonGroup.add(sizes[count]); // Adiciona o botão de rádio ao grupo de botões de tamanho de fonte.
         sizes[count].addActionListener(itemHandler); // Adiciona o manipulador de eventos ao botão de rádio.
      }

      sizes[3].setSelected(true); // Define o tamanho de fonte 72 como selecionado por padrão.

      formatMenu.add(fontMenu); // Adiciona o menu "Font" ao menu "Format".
      bar.add(formatMenu); // Adiciona o menu "Format" à barra de menu.
     
      displayJLabel = new JLabel("teste", SwingConstants.CENTER); // Cria um rótulo com o texto "teste", alinhado ao centro.
      displayJLabel.setForeground(colorValues[0]); // Define a cor inicial do texto como preto (primeira cor no array colorValues).
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, fontSizes[3])); // Define a fonte inicial como Serif, estilo normal (PLAIN), tamanho 72.

      getContentPane().setBackground(Color.DARK_GRAY); // Define a cor de fundo da janela como cinza escuro.
      add(displayJLabel, BorderLayout.CENTER); // Adiciona o rótulo à janela, no centro.
   } // Fim do construtor MenuFrame2.

   // Classe interna para lidar com eventos de ação dos itens de menu.
   private class ItemHandler implements ActionListener
   {
      // Processa as seleções de cor e fonte.
      @Override
      public void actionPerformed(ActionEvent event)
      {
         definirCor(); // Chama o método para definir a cor do texto.

         definirFonte(); // Chama o método para definir a fonte do texto.

         definirTamanho(); // Chama o método para definir o tamanho da fonte.

         repaint(); // Redesenha a aplicação para aplicar as mudanças.
      }
   } // Fim da classe ItemHandler.

   // Método para definir a cor do texto com base na seleção do menu.
   public void definirCor() {  
      for (int count = 0; count < colorItems.length; count++)
      {
         if (colorItems[count].isSelected())
         {
            displayJLabel.setForeground(colorValues[count]); // Define a cor do texto como a cor correspondente ao item selecionado.
            break;
         }
      }
   }  

   // Método para definir a fonte do texto com base na seleção do menu.
   public void definirFonte() {  
      for (int count = 0; count < fonts.length; count++)
      {
         if (fonts[count].isSelected())
         {
            displayJLabel.setFont(
               new Font(fonts[count].getText(), displayJLabel.getFont().getStyle(), displayJLabel.getFont().getSize())); // Define a fonte do texto.
         }
      }
   }
     
   // Método para definir o tamanho da fonte com base na seleção do menu.
   public void definirTamanho() {  
      for (int count = 0; count < sizes.length; count++)
      {
         if (sizes[count].isSelected())
         {
            displayJLabel.setFont(
               new Font(displayJLabel.getFont().getName(), displayJLabel.getFont().getStyle(),
               fontSizes[count])); // Define o tamanho da fonte do texto.
         }
      }
   }  

   // Classe interna para lidar com eventos de itens de checkbox para os estilos de fonte.
   private class StyleHandler implements ItemListener
   {
      // Processa as seleções de estilo de fonte.
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); // Obtém o nome da fonte atual.
         Font font; // Declara uma nova fonte baseada nas seleções do usuário.

         // Verifica quais estilos estão selecionados e define a fonte correspondente.
         if (styleItems[0].isSelected() && styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, displayJLabel.getFont().getSize()); // Se "Bold" e "Italic" estão selecionados.
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, displayJLabel.getFont().getSize()); // Se apenas "Bold" está selecionado.
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, displayJLabel.getFont().getSize()); // Se apenas "Italic" está selecionado.
         else
            font = new Font(name, Font.PLAIN, displayJLabel.getFont().getSize()); // Se nenhum estilo está selecionado (Plain).

         displayJLabel.setFont(font); // Aplica a nova fonte ao rótulo.

         definirCor(); // Chama o método para redefinir a cor do texto.
         definirFonte(); // Chama o método para redefinir a fonte.
         definirTamanho(); // Chama o método para redefinir o tamanho da fonte.

         repaint(); // Redesenha a aplicação para aplicar as mudanças.
      }
   } // Fim da classe StyleHandler.
} // Fim da classe MenuFrame2.
