package org.example.informacoesPessoais;

import java.util.Date;

public class Veiculo extends PessoaCadastrada {
    //informações do carro já estendida da classe PessoaCadastrada

    private String documentoVeiculo;
    private String placaVeiculo;

    public Veiculo(String nome, Date dataNacimento, String cpf, String email, String senha, String confirmarSenha, boolean asseguradoPorto, ModeloVeiculo modeloVeiculo, String documentoVeiculo, String placaVeiculo) {
        super(nome, dataNacimento, cpf, email, senha, confirmarSenha, asseguradoPorto, modeloVeiculo);
        this.documentoVeiculo = documentoVeiculo;
        this.placaVeiculo = placaVeiculo;
    }

    public Veiculo(String documentoVeiculo, String placaVeiculo) {
        this.documentoVeiculo = documentoVeiculo;
        if (isPlacaValida(placaVeiculo)) {
            this.placaVeiculo = placaVeiculo;
        } else {
            throw new RuntimeException("Placa inválida");
        }

    }

    public String getDocumentoVeiculo() {
        return documentoVeiculo;
    }

    public void setDocumentoVeiculo(String documentoVeiculo) {
        this.documentoVeiculo = documentoVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public boolean isPlacaValida(String placaVeiculo) {
        if (placaVeiculo.matches("[A-Z]{3}-\\d{4}")) {
            return true;
        }
        return false;
    }
}
