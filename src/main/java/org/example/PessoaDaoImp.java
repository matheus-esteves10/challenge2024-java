package org.example;

import org.example.informacoesPessoais.PessoaNaoCadastrada;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaDaoImp implements IPessoaNaoCadastrada{
    private final Connection connection;

    public PessoaDaoImp(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(PessoaNaoCadastrada pessoa) throws SQLException {
        String sql = "INSERT INTO t_atc_usuario (ID_USUARIO, NM_USUARIO, DT_NASCIMENTO, NR_CPF, NM_EMAIL) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setLong(1, pessoa.getId());
        pstm.setString(2, pessoa.getNome());
        pstm.setDate(3, Date.valueOf(pessoa.getDataNacimento()));
        pstm.setString(4, pessoa.getCpf());
        pstm.setString(5, pessoa.getEmail());
        pstm.executeUpdate();
    }

    @Override
    public List<PessoaNaoCadastrada> readAll() throws SQLException {
        List<PessoaNaoCadastrada> resultado = new ArrayList<>();
        String sql = "SELECT * FROM t_atc_usuario";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) { //metodo que verifica se tem um próximo item
            Long id = rs.getLong("ID_USUARIO");
            String nome = rs.getString("NM_USUARIO");
            LocalDate dataNasc = rs.getDate("DT_NASCIMENTO").toLocalDate();
            String cpf = rs.getString("NR_CPF");
            String email = rs.getString("NM_EMAIL");
            resultado.add(new PessoaNaoCadastrada(id, nome, dataNasc, cpf,email));
        }
        return resultado;
    }

    @Override
    public void update(PessoaNaoCadastrada pessoa) throws SQLException {
        String sql = "UPDATE t_atc_usuario set NM_USUARIO = ?, DT_NASCIMENTO = ?, NR_CPF = ?, NM_EMAIL = ? WHERE ID_USUARIO = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, pessoa.getNome());
        pstm.setDate(2, Date.valueOf(pessoa.getDataNacimento()));
        pstm.setString(3, pessoa.getCpf());
        pstm.setString(4, pessoa.getEmail());
        pstm.setLong(5, pessoa.getId());
        pstm.executeUpdate();

    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE from t_atc_usuario WHERE ID_USUARIO=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setLong(1, id);
        pstm.executeUpdate();
    }
}
