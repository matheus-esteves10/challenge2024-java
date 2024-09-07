package org.example;

import org.example.config.DatabaseConfig;
import org.example.informacoesPessoais.PessoaNaoCadastrada;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        DatabaseConfig db = new DatabaseConfig(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "RM554769",
                "160805");


        PessoaNaoCadastrada pessoa = new PessoaNaoCadastrada("Caio", LocalDate.of(2005, 12, 28), "93480504000", "caio@fiap.com.br");

        IPessoaNaoCadastrada pessoaDao = new PessoaDaoImp(db.getConnection());

        //create
//        pessoaDao.create(pessoa);

        //read -OK
//        List<PessoaNaoCadastrada> pessoas = pessoaDao.readAll();
//        for (PessoaNaoCadastrada pessoaSalva : pessoas) {
//            System.out.println(pessoaSalva.toString());
//        }

        //update
        pessoa.setNome("Joao");
        pessoaDao.update(pessoa);

        //delete - OK
        //pessoaDao.delete(2l);
    }
}

