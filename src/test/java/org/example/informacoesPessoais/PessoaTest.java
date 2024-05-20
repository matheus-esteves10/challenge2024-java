package org.example.informacoesPessoais;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    Date dataNascimento = new Date();
    Pessoa pessoa1 = new Pessoa("Carlos", dataNascimento, "044.464.790-24");
    // SUGESTÕES DE CPF para teste:   687.207.980-08   /   178.116.460-64   /   044.464.790-24

    @Test
    void teste_se_o_cpf_valido_retorna_true() {
        Assertions.assertTrue(pessoa1.isCpfValido("044.464.790-24"));
    }

    @Test
    void teste_se_o_cpf_invalido_retorna_false(){
        Assertions.assertFalse(pessoa1.isCpfValido("12543253242"));
    }
}