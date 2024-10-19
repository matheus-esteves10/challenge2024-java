package org.example.daoPessoa;

import org.example.config.DatabaseConfig;
import org.example.model.informacoesPessoais.Pessoa;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        DatabaseConfig db = new DatabaseConfig(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "RM554769",
                "160805");

        Pessoa pessoa = new Pessoa(3L, "Excluido", LocalDate.of(2005, 10, 20), "53154691820", "gabriel@fiap.com");
        IPessoaNaoCadastrada pessoaDao = new PessoaDaoImp(db.getConnection());

        //create
        pessoaDao.create(pessoa);

        //read
        List<Pessoa> cadastrados= pessoaDao.readAll();

        for(Pessoa user : cadastrados){
            System.out.println(user.toString());
        }

        //update
        pessoa.setNome("Gabriel Falanga");
        pessoaDao.update(pessoa);

        //delete
        pessoaDao.delete(3l);

    }
}
