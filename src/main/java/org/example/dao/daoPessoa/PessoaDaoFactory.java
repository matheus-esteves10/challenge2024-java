package org.example.dao.daoPessoa;

public final class PessoaDaoFactory {
    private PessoaDaoFactory() {
    }

    public static PessoaDao create(){
        return new PessoaDaoImp();
    }
}
