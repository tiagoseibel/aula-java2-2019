package br.com.empresa.biblioteca.dao;

import br.com.empresa.biblioteca.database.DbConnection;
import br.com.empresa.biblioteca.model.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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

    public List<Autor> listar() {
        List<Autor> list = new ArrayList<>();
        //
        String query = "select * from autor";

        try {
            cx1 = DbConnection.getConnection();

            PreparedStatement ps
                    = cx1.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Autor a = new Autor();
                a.setAutor_id(rs.getInt("autor_id"));
                a.setNome(rs.getString("nome"));
                list.add(a);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //
        return list;
    }

    public Autor buscar(int id) {
        Autor a = null;
        // Query
        String query = "select * from autor where autor_id = ?";
        try {
            cx1 = DbConnection.getConnection();
            PreparedStatement ps = cx1.prepareStatement(query);
            ps.setInt(1, id);
            // Resultado
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a = new Autor();
                a.setAutor_id(rs.getInt("autor_id"));
                a.setNome(rs.getString("nome"));
            }
        } catch (Exception se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        }
        return a;
    }

    public void delete(int id) {
        String query = "delete from autor where autor_id = ?";

        try {
            cx1 = DbConnection.getConnection();
            PreparedStatement ps = cx1.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        }
    }

}
