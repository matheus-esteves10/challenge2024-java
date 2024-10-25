package org.example.service.pessoa;

import org.example.exceptions.PessoaNotFoundException;
import org.example.exceptions.PessoaNotSavedException;
import org.example.exceptions.UnsupportedServiceOperationException;
import org.example.model.informacoesPessoais.Pessoa;

import java.sql.SQLException;
import java.util.List;

public interface PessoaService {
    Pessoa create(Pessoa pessoa) throws UnsupportedServiceOperationException, SQLException, PessoaNotSavedException;

    List<Pessoa> findAll();

    Pessoa update(Pessoa pessoa) throws PessoaNotFoundException, SQLException;

    void deleteById(Long id) throws PessoaNotFoundException, SQLException;
}
