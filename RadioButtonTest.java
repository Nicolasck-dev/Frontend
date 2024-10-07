import javax.swing.*; // Importa a biblioteca JFrame para criar uma janela gráfica.

public class RadioButtonTest // Classe principal que inicia a aplicação gráfica.
{ // Inicio do bloco de codigos da classe
   public static void main(String[] args) // Ponto de entrada da aplicação; permite execução sem instância da classe e suporta argumentos de linha de comando.
   { // Inicio do bloco de codigos do metodo
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame(); // Cria "new" um novo objeto RadioButtonFrame, que contém a interface gráfica.
      
      radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que a operação será encerrada ao fechar a janela.
      radioButtonFrame.setSize(300, 100); // Define o tamanho da janela (300x100 pixels).
      radioButtonFrame.setVisible(true); // Torna a janela visível.
   } 
} 
