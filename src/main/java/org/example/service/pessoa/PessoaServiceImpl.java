package org.example.service.pessoa;

import org.example.config.DatabaseConnectionFactory;
import org.example.dao.daoPessoa.PessoaDao;
import org.example.dao.daoPessoa.PessoaDaoFactory;
import org.example.exceptions.PessoaNotFoundException;
import org.example.exceptions.PessoaNotSavedException;
import org.example.exceptions.UnsupportedServiceOperationException;
import org.example.model.informacoesPessoais.Pessoa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

final class PessoaServiceImpl implements PessoaService {

    private final PessoaDao dao = PessoaDaoFactory.create();

    @Override
    public Pessoa create(Pessoa pessoa) throws UnsupportedServiceOperationException, SQLException, PessoaNotSavedException {
        if (pessoa.getId() == null) {
            Connection connection = DatabaseConnectionFactory.create().get();
            try {
                pessoa = this.dao.save(pessoa, connection);
                connection.commit();
                return pessoa;
            } catch (SQLException | PessoaNotSavedException e) {
                connection.rollback();
                throw e;
            }
        } else {
            throw new UnsupportedServiceOperationException();
        }
    }

    @Override
    public List<Pessoa> findAll() {
        return this.dao.readAll();
    }


    @Override
    public Pessoa update(Pessoa pessoa) throws PessoaNotFoundException, SQLException {
        Connection connection = DatabaseConnectionFactory.create().get();
        pessoa = this.dao.update(pessoa, connection);
        connection.commit();
        return pessoa;
    }

    @Override
    public void deleteById(Long id) throws PessoaNotFoundException, SQLException {
        Connection connection = DatabaseConnectionFactory.create().get();
        this.dao.deleteById(id, connection);
        connection.commit();
    }
}
