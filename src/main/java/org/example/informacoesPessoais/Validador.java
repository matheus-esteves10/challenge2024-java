package org.example.informacoesPessoais;

public interface Validador {
        boolean isCpfValid(String cpf);
        boolean isSenhaValid(String senha, String confirmarSenha);
    }
