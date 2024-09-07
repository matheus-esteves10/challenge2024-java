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
        String sql = "insert into T_ATC_USUARIO (NM_USUARIO, DT_NASCIMENTO, NM_EMAIL, NR_CPF)" +
                "values (?, ?, ?, ?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, pessoa.getNome());
        pstm.setDate(2, Date.valueOf(pessoa.getDataNacimento()));
        pstm.setString(3, pessoa.getEmail());
        pstm.setString(4, pessoa.getCpf());
    }

    @Override
    public List<PessoaNaoCadastrada> readAll() throws SQLException {
        List<PessoaNaoCadastrada> result = new ArrayList<>();
        String sql = "SELECT * FROM T_ATC_USUARIO";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) { //metodo que verifica se tem um próximo item
            String nome = rs.getString("NM_USUARIO");
            LocalDate dataNasc = rs.getDate("DT_NASCIMENTO").toLocalDate();
            String email = rs.getString("NM_EMAIL");
            String cpf = rs.getString("NR_CPF");
            result.add(new PessoaNaoCadastrada(nome, dataNasc, cpf, email));
        }
        return result;
    }

    @Override
    public void update(PessoaNaoCadastrada pessoa) throws SQLException {
        String sql = "UPDATE T_ATC_USUARIO set NM_USUARIO = ?, DT_NASCIMENTO = ?, NM_EMAIL = ?, NR_CPF = ? WHERE ID_USUARIO = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, pessoa.getNome());
        pstm.setDate(2, Date.valueOf(pessoa.getDataNacimento()));
        pstm.setString(3, pessoa.getEmail());
        pstm.setString(4, pessoa.getCpf());
        pstm.executeUpdate();
    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM T_ATC_USUARIO WHERE ID_USUARIO = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setLong(1, id);
        pstm.executeUpdate();
    }

}
