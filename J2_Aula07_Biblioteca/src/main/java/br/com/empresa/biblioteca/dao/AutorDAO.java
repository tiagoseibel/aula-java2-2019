package br.com.empresa.biblioteca.dao;

import br.com.empresa.biblioteca.database.DbConnection;
import br.com.empresa.biblioteca.model.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class AutorDAO {

    private Connection cx1;

    public void insert(Autor a) {
        String query
                = "insert into autor (autor_id, nome) values (?,?)";

        try {
            cx1 = DbConnection.getConnection();

            PreparedStatement ps = cx1.prepareStatement(query);
            ps.setInt(1, a.getAutor_id());
            ps.setString(2, a.getNome());
            ps.execute();
            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void update(Autor a) {
        String query
                = "update autor set nome = ? where autor_id = ?";

        try {
            cx1 = DbConnection.getConnection();

            PreparedStatement ps = cx1.prepareStatement(query);
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getAutor_id());
            ps.execute();
            ps.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
