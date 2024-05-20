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
        pessoaCadastrada.setCpfInformado("687.207.980-08");
        Assertions.assertEquals(pessoaCadastrada.getCpf(), pessoaCadastrada.getCpfInformado());
    }

   @Test
    void verifica_se_quando_cpf_diferente_cpf_informado_retorna_false(){
        pessoaCadastrada.setCpf("687.207.980-08");
        pessoaCadastrada.setCpfInformado("111111111111");
        Assertions.assertFalse(pessoaCadastrada.getCpf().equals(pessoaCadastrada.getCpfInformado()));

    }

}