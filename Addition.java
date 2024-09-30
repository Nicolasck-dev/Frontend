import javax.swing.JOptionPane; // Importa a classe JOptionPane, que faz parte do pacote javax.swing. Essa classe permite a criação de caixas de diálogo para interação com o usuário.

public class Addition // Define uma classe pública chamada "Addition". Em Java, toda aplicação deve ter pelo menos uma classe. O nome da classe geralmente reflete o propósito do programa.
{
   public static void main(String[] args) // O método principal (main) onde a execução do programa começa. "public" significa que o método pode ser chamado de fora da classe. "static" significa que o método pertence à classe e não a uma instância da classe. "void" indica que o método não retorna nenhum valor. "String[] args" permite a passagem de argumentos pela linha de comando, embora não seja usado aqui.
   {
      
      String firstNumber = // Declara uma variável de tipo String chamada "firstNumber". As variáveis do tipo String armazenam cadeias de caracteres.
         JOptionPane.showInputDialog("Enter first integer"); // Exibe uma caixa de diálogo para o usuário, solicitando que ele insira o primeiro número inteiro. O valor inserido é retornado como uma String e atribuído à variável "firstNumber".

      String secondNumber = // Declara uma variável de tipo String chamada "secondNumber".
          JOptionPane.showInputDialog("Enter second integer"); // Exibe uma caixa de diálogo para o usuário, solicitando que ele insira o segundo número inteiro. O valor inserido é retornado como uma String e atribuído à variável "secondNumber".

      
      int number1 = Integer.parseInt(firstNumber); // Converte a String "firstNumber" para um número inteiro usando o método parseInt da classe Integer. O valor inteiro é armazenado na variável "number1".
      int number2 = Integer.parseInt(secondNumber); // Converte a String "secondNumber" para um número inteiro usando o método parseInt. O valor inteiro é armazenado na variável "number2".

      int sum = number1 + number2; // Declara uma variável inteira "sum" e atribui a ela a soma dos valores de "number1" e "number2".

      
      JOptionPane.showMessageDialog(null, "The sum is " + sum, // Exibe uma caixa de diálogo mostrando o resultado da soma. O "null" indica que a janela não tem um "pai" (janela ou componente pai). A mensagem exibida é "The sum is" seguida pelo valor de "sum".
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE); // Define o título da caixa de diálogo como "Sum of Two Integers". O terceiro argumento, JOptionPane.PLAIN_MESSAGE, indica que a caixa de diálogo não terá nenhum ícone especial (apenas texto).
   } 
} 
