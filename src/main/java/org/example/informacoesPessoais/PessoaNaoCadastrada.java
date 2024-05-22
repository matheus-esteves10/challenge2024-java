package org.example.informacoesPessoais;

import java.util.Date;

public class PessoaNaoCadastrada implements Validador{

    private String nome;
    private Date dataNacimento;
    private String cpf;
    private String email;
    private String senha;
    private String confirmarSenha;
    private boolean asseguradoPorto;

    public PessoaNaoCadastrada(String nome, Date dataNacimento, String cpf, String email, String senha, String confirmarSenha, boolean asseguradoPorto) {
        this.nome = nome;
        this.dataNacimento = dataNacimento;
        if (isCpfValid(cpf)) {
            this.cpf = cpf;
        } else {
            throw new RuntimeException("O cpf é inválido");
        }
        this.email = email;
        if (isSenhaValid(senha, confirmarSenha)) {
            this.senha = senha;
        }
        this.asseguradoPorto = asseguradoPorto;
    }

    public PessoaNaoCadastrada() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(Date dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAsseguradoPorto(boolean asseguradoPorto) {
        this.asseguradoPorto = asseguradoPorto;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    @Override
    public boolean isCpfValid(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // Remover caracteres não numéricos

        if (cpf.length() != 11)
            return false;

        if (cpf.matches("(\\d)\\1*")) // Verificar se todos os dígitos são iguais (caso contrário, não é um CPF válido)
            return false;

        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (10 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);

        // Verificando o primeiro dígito verificador
        if (Character.getNumericValue(cpf.charAt(9)) != digitoVerificador1)
            return false;

        // Calculando o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (11 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        // Verificando o segundo dígito verificador
        if (Character.getNumericValue(cpf.charAt(10)) != digitoVerificador2)
            return false;

        // CPF válido
        return true;
    }

    @Override
    public boolean isSenhaValid(String senha, String confirmarSenha) {
        if (senha.equals(confirmarSenha))
            return true;
        else {
            return false;
        }
    }

    public boolean isAsseguradoPorto(boolean asseguradoPorto){ //verificar se o usuario é assegurado Porto
        if (asseguradoPorto){
            return true;
        }
        return false;
    }

}
