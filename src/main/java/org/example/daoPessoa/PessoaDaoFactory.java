package org.example.daoPessoa;

import java.sql.Connection;

public class PessoaDaoFactory {

    private PessoaDaoFactory() {
    }

    public static PessoaNaoCadastradaDao create(){
        return new PessoaDaoImp();
    }
}
