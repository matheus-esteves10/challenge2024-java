package org.example.dao.daoVeiculo;

import org.example.dao.Dao;
import org.example.dao.daoPessoa.PessoaDaoImp;
import org.example.model.informacoesPessoais.Pessoa;
import org.example.model.informacoesPessoais.Veiculo;

public class VeiculoDaoFactory {

    private VeiculoDaoFactory() {
        // Construtor privado para evitar instanciação
    }

    public static Dao<Veiculo> create() {
        return new VeiculoDaoImp();
    }
}
