import java.sql.*; // Importa todas as classes do pacote java.sql para manipulação de banco de dados (JDBC).

public class MySQLConnector // Declaração da classe MySQLConnector.
{
    // Método estático que estabelece a conexão com o banco de dados MySQL.
    public static Connection conectar()
    {
        // Declaração das variáveis que armazenam as informações de conexão com o banco de dados.
        String mysqlHost = "127.0.0.1"; // Endereço do servidor MySQL (localhost).
        String mysqlDb = "db_senac"; // Nome do banco de dados que será acessado.
        String mysqlUser = "root"; // Usuário do banco de dados MySQL.
        String mysqlPassowrd = "senac@02"; // Senha do usuário do banco de dados MySQL.
        String mysqlPort = "3306"; // Porta do servidor MySQL (padrão 3306).
        
        // Constrói a URL de conexão JDBC com as variáveis definidas.
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + 
        mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassowrd;
        
        Connection conn = null; // Declara um objeto do tipo Connection para armazenar a conexão com o banco.

        try {
            // Carrega a classe do driver JDBC do MySQL (necessária para a conexão).
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            
            // Estabelece a conexão com o banco de dados usando a URL construída.
            conn = DriverManager.getConnection(mysqlUrl);
        } catch(Exception e) {
            // Caso ocorra algum erro durante o processo de conexão, exibe uma mensagem de erro no console.
            System.err.println("Ops! Algo de errado não está certo com a conexão com o banco de dados MySQL! Mensagem do Servidor:" + e);
        }
        // Retorna o objeto Connection, que será usado para interagir com o banco de dados.
        return conn;
    }
}
