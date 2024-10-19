import java.awt.*; // Importa as classes para manipulação de componentes gráficos (AWT).
import java.awt.event.*; // Importa as classes para manipulação de eventos (AWT).
import javax.swing.*; // Importa as classes para criar componentes gráficos (Swing).
import java.sql.*; // Importa as classes para manipulação de banco de dados (JDBC).

public class TelaDeLogin extends JFrame // Declara a classe TelaDeLogin que herda de JFrame (interface gráfica).
{
    // Declaração de componentes da interface gráfica e variáveis de instância.
    private final JLabel LblLogin; // Rótulo (label) para o campo de login.
    private final JTextField textLogin; // Campo de texto para inserir o login.
    private final JLabel LblSenha; // Rótulo (label) para o campo de senha.
    private final JPasswordField textSenha; // Campo de senha (password) para inserção de senha.
    private final JButton btnLogar; // Botão para efetuar o login.
    private final JLabel notificarUsuario; // Rótulo para exibir notificações ao usuário.

    // Construtor da classe TelaDeLogin.
    public TelaDeLogin()
    {
        super("Tela de Login"); // Define o título da janela como "Tela de Login".

        setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout (disposição linear dos componentes).

        LblLogin = new JLabel("Login"); // Inicializa o rótulo do campo de login.
        add(LblLogin); // Adiciona o rótulo à janela.

        textLogin = new JTextField(10); // Inicializa o campo de texto com largura de 10 caracteres.
        add(textLogin); // Adiciona o campo de texto à janela.

        LblSenha = new JLabel("Senha"); // Inicializa o rótulo do campo de senha.
        add(LblSenha); // Adiciona o rótulo à janela.

        textSenha = new JPasswordField(10); // Inicializa o campo de senha com largura de 10 caracteres.
        add(textSenha); // Adiciona o campo de senha à janela.

        btnLogar = new JButton("Logar"); // Inicializa o botão de login com o texto "Logar".
        add(btnLogar); // Adiciona o botão à janela.

        notificarUsuario = new JLabel("Notificações"); // Inicializa o rótulo para exibir notificações ao usuário.
        add(notificarUsuario); // Adiciona o rótulo à janela.

        ButtonHandler buttonHandler = new ButtonHandler(); // Cria um objeto da classe interna ButtonHandler para lidar com o evento do botão.
        btnLogar.addActionListener(buttonHandler); // Adiciona o manipulador de eventos ao botão de login.

        // Adiciona um KeyListener ao campo de senha para detectar a tecla "Enter".
        textSenha.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (String.valueOf(textSenha.getPassword()).trim().length() > 0) { // Verifica se a senha não está vazia.
                        if (e.getKeyCode() == 10) { // Verifica se a tecla "Enter" foi pressionada.
                            System.out.println("Você teclou Enter"); // Exibe uma mensagem no console.
                            logar(); // Chama o método logar().
                        }
                    }
                }
            }
        );
    }

    // Classe interna para manipular eventos de ação (como cliques de botão).
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            logar(); // Chama o método logar() quando o botão é clicado.
        }   
    }

    // Método que trata o processo de login.
    public void logar() {
        try {
            // Conecta ao banco de dados usando a classe MySQLConnector.
            Connection conexao = MySQLConnector.conectar();
            // Define a query SQL para buscar o login e senha correspondentes.
            String  strSqlLogin = "select * from `db_senac`.`tbl_senac` where email = '" + 
            textLogin.getText() + "' and senha = '" +  String.valueOf(textSenha.getPassword()) + "';";
            Statement stmSqlLogin = conexao.createStatement(); // Cria um Statement para executar a query SQL.
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin); // Executa a query e armazena o resultado.

            // Verifica se o resultado contém um registro (login e senha corretos).
            if (rstSqlLogin.next()) {
                notificarUsuario("Login realizado com sucesso"); // Notifica o usuário que o login foi bem-sucedido.
            } else {
                notificarUsuario("Não foi possivel encontrar o login e/ou senha digitados. Por favor, verifique e tente novamente."); 
                // Notifica o usuário que o login e senha não foram encontrados.
            }
        } catch (Exception e) {
            notificarUsuario.setText("Houve um problema e não sera possivel realizar o login neste momento. Por favor, tente novamente mais tarde.");
            // Notifica o usuário que houve um erro no processo de login.
            System.err.println("Ops! Deu ruim, se liga no erro: " + e); // Exibe a mensagem de erro no console.
        }
    }

    // Método para formatar o texto em HTML (usado nas notificações).
    public String setHtmlFormat(String txt) {
        return "<html><body>" + txt + "<body><html>"; // Retorna o texto formatado em HTML.
    }

    // Método que exibe uma notificação ao usuário no JLabel notificarUsuario.
    public void notificarUsuario(String strTexto) {
        notificarUsuario.setText(setHtmlFormat(strTexto)); // Define o texto de notificação com a formatação HTML.
    }

    // Método principal para iniciar a aplicação.
    public static void main (String[] args) 
    {
        TelaDeLogin appTelaDeLogin = new TelaDeLogin(); // Cria uma instância da tela de login.

        appTelaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação padrão ao fechar a janela.
        appTelaDeLogin.setSize(150, 200); // Define o tamanho da janela (largura 150px, altura 200px).
        appTelaDeLogin.setVisible(true); // Torna a janela visível na tela.
    }
}
