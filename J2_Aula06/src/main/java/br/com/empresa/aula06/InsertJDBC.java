package br.com.empresa.aula06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertJDBC {

    public static void main(String[] args) {
        try {
            // Carrega do driver JDBC do FirebirdSQL
            Class.forName("org.firebirdsql.jdbc.FBDriver");

            // Especifica parametros de conexão
            String url = "jdbc:firebirdsql:127.0.0.1/3050:C:/databases/aula06.fdb";
            String user = "sysdba";
            String password = "masterkey";

            // Estabelece conexão com o servidor de banco de dados
            Connection cx = DriverManager.getConnection(url, user, password);

            // Prepara uma consulta SQL para o banco de dados
            String query = "insert into estudante (id, nome, telefone) values (?, ?, ?)";
            PreparedStatement ps = cx.prepareStatement(query);

            // Informa os parametros e executa a query
            ps.setInt(1, 2);
            ps.setString(2, "Tiger");
            ps.setString(3, "95858-8989");
            ps.execute();
            
            ps.close();
            cx.close();

        } catch (SQLException se) {
            System.out.println("Erro ao conectar com o banco de dados: Detalhes: " + se.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível carregar o driver JDBC.");
        }

    }
}
