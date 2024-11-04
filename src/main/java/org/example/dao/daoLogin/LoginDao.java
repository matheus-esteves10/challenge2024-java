package org.example.dao.daoLogin;

import org.example.model.informacoesPessoais.Pessoa;

import java.util.List;

public interface LoginDao {

    List<Pessoa> checkLogin(String email, String cpf, String senha);
}
