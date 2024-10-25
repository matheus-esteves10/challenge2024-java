package org.example.dao.daoPessoa;

import org.example.config.DatabaseConnectionFactory;
import org.example.exceptions.PessoaNotFoundException;
import org.example.exceptions.PessoaNotSavedException;
import org.example.model.informacoesPessoais.Pessoa;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PessoaDaoImp implements PessoaDao {
    private Connection connection;

    private final Logger logger = Logger.getLogger(this.getClass().getName());


    public PessoaDaoImp() {
    }

    public PessoaDaoImp(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Pessoa save(Pessoa pessoa, Connection connection) throws SQLException, PessoaNotSavedException {
        String sql = "BEGIN INSERT INTO t_atc_usuario (NM_USUARIO, DT_NASC, NR_CPF, NM_EMAIL, NM_SENHA) VALUES (?, ?, ?, ?, ?) RETURNING ID INTO ?; END;";
        CallableStatement call = connection.prepareCall(sql);

        call.setString(1, pessoa.getNome());
        call.setDate(2, Date.valueOf(pessoa.getDataNacimento()));
        call.setString(3, pessoa.getCpf());
        call.setString(4, pessoa.getEmail());
        call.setString(5, pessoa.getSenha());
        int linhasAlteradas = call.executeUpdate();
        long id = call.getLong(6);
        if(linhasAlteradas == 0 || id == 0){
            throw new PessoaNotSavedException();
        }
        pessoa.setId(id);
        return pessoa;
    }

    @Override
    public List<Pessoa> readAll() {
        List<Pessoa> resultado = new ArrayList<>();
        final String sql = "SELECT * FROM t_atc_usuario";
        try (Connection connection = DatabaseConnectionFactory.create().get()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) { //metodo que verifica se tem um próximo item
                Long id = rs.getLong("ID_USUARIO");
                String nome = rs.getString("NM_USUARIO");
                LocalDate dataNasc = rs.getDate("DT_NASC").toLocalDate();
                String cpf = rs.getString("NR_CPF");
                String email = rs.getString("NM_EMAIL");
                String senha = rs.getString("NM_SENHA");
                resultado.add(new Pessoa(id, nome, dataNasc, cpf,email, senha));
            }
        }catch (SQLException e){
            logger.warning("não foi possível localizar nenhum registro de pessoa: "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public Pessoa update(Pessoa pessoa, Connection connection) throws PessoaNotFoundException, SQLException {
        final String sql = "UPDATE t_atc_usuario set NM_USUARIO = ?, DT_NASC = ?, NR_CPF = ?, NM_EMAIL = ?, NM_SENHA = ? WHERE ID_USUARIO = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, pessoa.getNome());
        stmt.setDate(2, Date.valueOf(pessoa.getDataNacimento()));
        stmt.setString(3, pessoa.getCpf());
        stmt.setString(4, pessoa.getEmail());
        stmt.setString(5, pessoa.getSenha());
        stmt.setLong(6, pessoa.getId());
        int linhasAlteradas = stmt.executeUpdate();
        if(linhasAlteradas == 0 ) {
            throw new PessoaNotFoundException();
        }
        return pessoa;
    }

    @Override
    public void deleteById(Long id, Connection connection) throws SQLException, PessoaNotFoundException {
        final String sql = "DELETE from t_atc_usuario WHERE ID_USUARIO=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        int linhasAlteradas = stmt.executeUpdate();
        if(linhasAlteradas == 0) {
            throw new PessoaNotFoundException();
        }
    }



}
