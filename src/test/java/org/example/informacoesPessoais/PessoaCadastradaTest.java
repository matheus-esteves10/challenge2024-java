package org.example.informacoesPessoais;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PessoaCadastradaTest {

PessoaCadastrada pessoaCadastrada = new PessoaCadastrada("11111111111", "1234",  ModeloVeiculo.CARRO1);


    @Test
    void verifica_se_quando_cpf_igual_cpf_informado_retorna_true() {
        pessoaCadastrada.setCpf("687.207.980-08");
        Assertions.assertTrue(pessoaCadastrada.isCpfValid("687.207.980-08"));
    }

   @Test
    void verifica_se_quando_cpf_diferente_cpf_informado_retorna_false(){
        pessoaCadastrada.setCpf("687.207.980-08");
        Assertions.assertFalse(pessoaCadastrada.isCpfValid("111111111111"));

    }

    @Test
    void verifica_se_quando_senha_1234_e_senha_informada_1234_retorna_true(){
        pessoaCadastrada.setSenha("1234");
        pessoaCadastrada.setSenhaInformada("1234");
        Assertions.assertTrue(pessoaCadastrada.isSenhaValid());
    }

}