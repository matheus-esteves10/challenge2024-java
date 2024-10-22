package org.example.daoPessoa;

import org.example.model.informacoesPessoais.Pessoa;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaDaoImp implements PessoaNaoCadastradaDao {
    private Connection connection;
    private PreparedStatement pstm;


    public PessoaDaoImp() {
    }

    public PessoaDaoImp(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO t_atc_usuario (NM_USUARIO, DT_NASC, NR_CPF, NM_EMAIL, NM_SENHA) VALUES (?, ?, ?, ?, ?)";

        pstm = connection.prepareStatement(sql);
        pstm.setString(1, pessoa.getNome());
        pstm.setDate(2, Date.valueOf(pessoa.getDataNacimento()));
        pstm.setString(3, pessoa.getCpf());
        pstm.setString(4, pessoa.getEmail());
        pstm.setString(5, pessoa.getSenha());
        pstm.executeUpdate();
    }

    @Override
    public List<Pessoa> readAll() throws SQLException {
        List<Pessoa> resultado = new ArrayList<>();
        String sql = "SELECT * FROM t_atc_usuario";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) { //metodo que verifica se tem um próximo item
            Long id = rs.getLong("ID_USUARIO");
            String nome = rs.getString("NM_USUARIO");
            LocalDate dataNasc = rs.getDate("DT_NASC").toLocalDate();
            String cpf = rs.getString("NR_CPF");
            String email = rs.getString("NM_EMAIL");
            String senha = rs.getString("NM_SENHA");
            resultado.add(new Pessoa(id, nome, dataNasc, cpf,email, senha));
        }
        return resultado;
    }

    @Override
    public void update(Pessoa pessoa) throws SQLException {
        String sql = "UPDATE t_atc_usuario set NM_USUARIO = ?, DT_NASC = ?, NR_CPF = ?, NM_EMAIL = ?, NM_SENHA = ? WHERE ID_USUARIO = ?";
        pstm = connection.prepareStatement(sql);
        pstm.setString(1, pessoa.getNome());
        pstm.setDate(2, Date.valueOf(pessoa.getDataNacimento()));
        pstm.setString(3, pessoa.getCpf());
        pstm.setString(4, pessoa.getEmail());
        pstm.setString(5, pessoa.getSenha());
        pstm.setLong(6, pessoa.getId());
        pstm.executeUpdate();

    }

    @Override
    public void delete(Long id) throws SQLException {
        String sql = "DELETE from t_atc_usuario WHERE ID_USUARIO=?";
        pstm = connection.prepareStatement(sql);
        pstm.setLong(1, id);
        pstm.executeUpdate();
    }
}
