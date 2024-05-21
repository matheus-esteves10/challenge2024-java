package org.example.informacoesPessoais;

import java.util.Date;

public class PessoaCadastrada extends PessoaNaoCadastrada implements Validador {
    private String cpfInformado;
    private String senhaInformada;
    private ModeloVeiculo modeloVeiculo;

    public PessoaCadastrada(String nome, Date dataNacimento, String cpf, String email, String senha, String confirmarSenha, boolean asseguradoPorto, ModeloVeiculo modeloVeiculo) {
        super(nome, dataNacimento, cpf, email, senha, confirmarSenha, asseguradoPorto);
        this.modeloVeiculo = modeloVeiculo;
    }

    public PessoaCadastrada(String cpfInformado, String senhaInformada, ModeloVeiculo modeloVeiculo) {
        this.cpfInformado = cpfInformado;
        this.senhaInformada = senhaInformada;
        this.modeloVeiculo = modeloVeiculo;
    }

    public PessoaCadastrada(){


    }

    public String getCpfInformado() {
        return cpfInformado;
    }

    public void setCpfInformado(String cpfInformado) {
        this.cpfInformado = cpfInformado;
    }

    public String getSenhaInformada() {
        return senhaInformada;
    }

    public void setSenhaInformada(String senhaInformada) {
        this.senhaInformada = senhaInformada;
    }

    public ModeloVeiculo getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(ModeloVeiculo modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    @Override
    public boolean isCpfValid(String cpfInformado){ //metodo criado para verificar se o cpf fornecido pelo usuario é igual o cpf cadastrado
        if (cpfInformado.equals(getCpf())){
            return true;
        } else {
            return false;
        }


    }
   @Override
    public boolean isSenhaValid(){ //metodo criado para verificar se a senha fornecida pelo usuario é igual a senha cadastrada
        if (senhaInformada.equals(getSenha())) {
            return true;
        } else {
            return false;
        }




    }
}
