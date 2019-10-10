package br.com.empresa.biblioteca.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    private static Connection cx;

    public static Connection getConnection()
            throws Exception {
        if (cx == null) {
            try {
                // Carregar driver do banco de dados
                Class.forName("org.firebirdsql.jdbc.FBDriver");

                // Definir parametros
                String url
                        = "jdbc:firebirdsql:127.0.0.1/3050:c:/databases/biblioteca.fdb";
                String user = "SYSDBA";
                String password = "masterkey";

                // Estebelece conexao com o banco de dados
                cx = DriverManager.getConnection(url, user, password);

            } catch (ClassNotFoundException ex) {
                throw new Exception("Driver não encontrado!");
            }
        }
        return cx;
    }
}
