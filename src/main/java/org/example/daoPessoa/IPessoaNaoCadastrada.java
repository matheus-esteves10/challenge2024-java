package org.example.daoPessoa;

import org.example.informacoesPessoais.Pessoa;

import java.sql.SQLException;
import java.util.List;

public interface IPessoaNaoCadastrada {
    //create
    void create (Pessoa pessoa) throws SQLException;

    //read
    List<Pessoa> readAll() throws SQLException;

    //update
    void update(Pessoa pessoa) throws SQLException;

    //delete
    void delete(Long id) throws SQLException;
}
