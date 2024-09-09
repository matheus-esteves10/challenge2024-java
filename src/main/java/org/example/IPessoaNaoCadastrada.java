package org.example;

import org.example.informacoesPessoais.PessoaNaoCadastrada;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface IPessoaNaoCadastrada {
    //create
    void create (PessoaNaoCadastrada pessoa) throws SQLException;

    //read
    List<PessoaNaoCadastrada> readAll() throws SQLException;

    //update
    void update(PessoaNaoCadastrada pessoa) throws SQLException;

    //delete
    void delete(Long id) throws SQLException;
}
