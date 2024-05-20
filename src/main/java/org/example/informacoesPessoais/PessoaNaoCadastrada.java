package org.example.informacoesPessoais;

import java.util.Date;

public class PessoaNaoCadastrada extends Pessoa {

    private String email;
    private String senha;
    private String confirmarSenha;
    private boolean asseguradoPorto;

    public PessoaNaoCadastrada(String nome, Date dataNacimento, String cpf, String email, String senha, String confirmarSenha, boolean asseguradoPorto) {
        super(nome, dataNacimento, cpf);
        this.email = email;
        if (isSenhaIgual(senha, confirmarSenha)) {
            this.senha = senha;
        } else {
            throw new RuntimeException("Senha inválida");
        }
        this.asseguradoPorto = asseguradoPorto;
    }

    public PessoaNaoCadastrada(String email, String senha, String confirmarSenha, boolean asseguradoPorto) {
        this.email = email;
        if (isSenhaIgual(senha, confirmarSenha)) {
            this.senha = senha;
        } else {
            throw new RuntimeException("Senha inválida");
        }
        this.confirmarSenha = confirmarSenha;
        this.asseguradoPorto = asseguradoPorto;
    }

    public PessoaNaoCadastrada() {

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

    public void setSenha(String senha, String confirmarSenha) {
        if (isSenhaIgual(senha, confirmarSenha)) {
            this.senha = senha;
        } else {
            throw new RuntimeException("Senha inválida");
        }
    }


    public boolean isAsseguradoPorto() {
        return asseguradoPorto;
    }

    public void setAsseguradoPorto(boolean asseguradoPorto) {
        this.asseguradoPorto = asseguradoPorto;
    }

    public boolean isSenhaIgual(String senha, String confirmarSenha) { //metodo para verificar se senhas são identicas
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
