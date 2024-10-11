package org.example.informacoesPessoais;

import java.time.LocalDate;
import java.util.Date;

public class Veiculo extends Pessoa {

    private Long id;
    private String marca;
    private String ano;
    private String modelo;
    private String documentoVeiculo;
    private String placaVeiculo;

    public Veiculo(String nome, LocalDate dataNacimento, String cpf, String email, String senha, String confirmarSenha, String documentoVeiculo, String placaVeiculo) {
        super(nome, dataNacimento, cpf, email, senha);
        this.documentoVeiculo = documentoVeiculo;
        this.placaVeiculo = placaVeiculo;
    }

    public Veiculo(String documentoVeiculo, String placaVeiculo) {
        this.documentoVeiculo = documentoVeiculo;
        setPlacaVeiculo(placaVeiculo);

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
        if(isPlacaValida(placaVeiculo)) {
            this.placaVeiculo = placaVeiculo;
        } else {
            throw new RuntimeException("Placa inválida");
        }
    }

    public boolean isPlacaValida(String placaVeiculo) {
        if (placaVeiculo.matches("[A-Z]{3}-\\d{4}")) {
            return true;
        }
        return false;
    }
}
