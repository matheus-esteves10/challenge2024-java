package org.example.dao.daoLogin;

import org.example.config.DatabaseConnectionFactory;
import org.example.model.informacoesPessoais.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LoginDaoImpl implements LoginDao{

    private Connection connection;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public LoginDaoImpl() {
    }


    public List<Pessoa> checkLogin(String email, String cpf, String senha) {
        List<Pessoa> resultado = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM t_atc_usuario WHERE ");
        boolean hasEmail = email != null;
        boolean hasCpf = cpf != null;

        if (hasEmail) {
            sql.append("NM_EMAIL = ?");
        }
        if (hasCpf) {
            if (hasEmail) {
                sql.append(" OR ");
            }
            sql.append("NR_CPF = ?");
        }
        sql.append(" AND NM_SENHA = ?");

        try (Connection connection = DatabaseConnectionFactory.create().get()) {
            PreparedStatement stmt = connection.prepareStatement(sql.toString());
            int index = 1;

            if (hasEmail) {
                stmt.setString(index++, email);
            }
            if (hasCpf) {
                stmt.setString(index++, cpf);
            }
            stmt.setString(index, senha);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("ID_USUARIO");
                String nome = rs.getString("NM_USUARIO");
                LocalDate dataNasc = rs.getDate("DT_NASC").toLocalDate();
                String cpfDb = rs.getString("NR_CPF");
                String emailDb = rs.getString("NM_EMAIL");
                String senhaDb = rs.getString("NM_SENHA");
                resultado.add(new Pessoa(id, nome, dataNasc, cpfDb, emailDb, senhaDb));
            }
        } catch (SQLException e) {
            logger.warning("Não foi possível localizar nenhum registro de pessoa: " + e.getMessage());
        }
        return resultado;
    }


}
