package org.example.daoOficina;

import org.example.model.oficina.Oficina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OficinaDaoImpl implements IOficina{

    private final Connection connection;
    private PreparedStatement pstm;

    public OficinaDaoImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Oficina oficina) throws SQLException {
        String sql = "INSERT INTO t_atc_oficina (nm_oficina, nm_cidade, endereco, nr_cnpj) VALUES (?, ?, ?, ?)";
        pstm = connection.prepareStatement(sql);
        pstm.setString(1, oficina.getNomeOficina());
        pstm.setString(2, oficina.getCidadeOficina());
        pstm.setString(3, oficina.getEnderecoOficina());
        pstm.setString(4, oficina.getCnpjOficina());
        pstm.executeUpdate();
    }

    @Override
    public List<Oficina> readAll() throws SQLException {
        List<Oficina> resultado = new ArrayList<>();
        String sql = "SELECT * FROM T_ATC_OFICINA";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()){
           Long id = rs.getLong("id_oficina");
           String nomeOficina = rs.getString("nm_oficina");
           String cidadeOficina = rs.getString("nm_cidade");
           String enderecoOficina = rs.getString("endereco");
           String cnpj = rs.getString("nr_cnpj");

           resultado.add(new Oficina(id, nomeOficina, cidadeOficina, enderecoOficina, cnpj));
        }
        return resultado;
    }

    @Override
    public void update(Oficina oficina) throws SQLException {
        String sql = "UPDATE t_atc_oficina set nr_cnpj = ?, nm_cidade = ?, endereco = ?, nm_oficina = ? WHERE id_oficina = ?";
        pstm = connection.prepareStatement(sql);

        pstm.setString(1, oficina.getCnpjOficina());
        pstm.setString(2, oficina.getCidadeOficina());
        pstm.setString(3, oficina.getEnderecoOficina());
        pstm.setString(4, oficina.getNomeOficina());
        pstm.setLong(5, oficina.getId());
        pstm.executeUpdate();
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM t_atc_oficina WHERE id_oficina = ?";
        pstm = connection.prepareStatement(sql);
        pstm.setLong(1, id);
        pstm.executeUpdate();

    }
}
