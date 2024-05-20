package org.example.informacoesPessoais;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PessoaNaoCadastradaTest {

    Date dataNascimento = new Date();
    PessoaNaoCadastrada pessoa = new PessoaNaoCadastrada("Carlos", dataNascimento, "044.464.790-24", "carlos@gmail.com", "1234", "1234", true);

    @Test
    void verifica_se_quando_senha_igual_retorna_true() {
        Assertions.assertTrue(pessoa.isSenhaIgual("1234", "1234"));
    }

    @Test
    void verifica_se_quando_senha_diferente_retorna_false() {
        Assertions.assertFalse(pessoa.isSenhaIgual("1234", "4321"));
    }

    @Test
    void verifica_se_quando_true_associado_porto_retorna_true(){
        Assertions.assertTrue(pessoa.isAsseguradoPorto(true));
    }

    @Test
    void verifica_se_quando_false_associado_porto_retorna_false(){
        pessoa.setAsseguradoPorto(false);
        Assertions.assertFalse(pessoa.isAsseguradoPorto(false));
    }
}