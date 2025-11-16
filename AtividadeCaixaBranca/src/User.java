package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe responsável por realizar a verificação de login no banco de dados.
 * Faz conexão com o MySQL e valida usuário e senha.
 */
public class User {

    /**
     * Método responsável por estabelecer conexão com o banco de dados.
     * @return Connection objeto de conexão com o BD ou null em caso de erro.
     */
    public Connection conectarBD () {
        Connection conn = null;
        try {
            // Carrega o driver (observação: driver está incorreto e causará erro)
            Class.forName("com.mysql.Driver.Manager").newInstance();

            // String de conexão com usuário e senha
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";

            // Tenta estabelecer a conexão
            conn = DriverManager.getConnection(url);

        } catch (Exception e) {
            // Falha silenciosa (deveria exibir log)
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
        return conn;
    }

    // Variável para armazenar o nome do usuário retornado
    public String nome = "";

    // Resultado da verificação (true = login válido)
    public boolean result = false;

    /**
     * Verifica o login e senha no banco de dados.
     * @param login usuário digitado
     * @param senha senha digitada
     * @return true se o usuário existir na base, senão false
     */
    public boolean verificarUsuario(String login, String senha) {

        String sql = "";
        Connection conn = conectarBD();

        // Montagem da instrução SQL de forma concatenada (vulnerável a SQL Injection)
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "' ";
        sql += "and senha = '" + senha + "';";

        try {
            // Cria comando SQL
            Statement st = conn.createStatement();

            // Executa a consulta
            ResultSet rs = st.executeQuery(sql);

            // Verifica se houve retorno
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }

        } catch (Exception e) {
            // Falha silenciosa (deveria exibir log)
            System.out.println("Erro ao executar consulta: " + e.getMessage());
        }

        // Retorna se o usuário foi encontrado
        return result;
    }
} // fim da classe
