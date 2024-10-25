package org.example.dao.daoPessoa;

import org.example.exceptions.PessoaNotFoundException;
import org.example.exceptions.PessoaNotSavedException;
import org.example.model.informacoesPessoais.Pessoa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PessoaDao {
    //create
    Pessoa save (Pessoa pessoa, Connection connection) throws SQLException, PessoaNotSavedException;

    //read
    List<Pessoa> readAll();

    //update
    Pessoa update(Pessoa pessoa, Connection connection) throws PessoaNotFoundException, SQLException;

    //delete
    void deleteById(Long id, Connection connection) throws SQLException, PessoaNotFoundException;
}
