package org.example.oficina;

public class Pecas extends Oficina{
    private String modeloPeca;
    private String marcaPeca;
    private double valorPeca;
    private double valorMaoDeObra;
    private String codigoPeca;



    public Pecas(String nomeOficina, String cidadeOficina, String enderecoOficina, String cnpjOficina) {
        super(nomeOficina, cidadeOficina, enderecoOficina, cnpjOficina);
    }

    public String getModeloPeca() {
        return modeloPeca;
    }

    public void setModeloPeca(String modeloPeca) {
        this.modeloPeca = modeloPeca;
    }

    public String getMarcaPeca() {
        return marcaPeca;
    }

    public void setMarcaPeca(String marcaPeca) {
        this.marcaPeca = marcaPeca;
    }

    public double getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(double valorPeca) {
        this.valorPeca = valorPeca;
    }

    public double getValorMaoDeObra() {
        return valorMaoDeObra;
    }

    public void setValorMaoDeObra(double valorMaoDeObra) {
        this.valorMaoDeObra = valorMaoDeObra;
    }

    public String getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(String codigoPeca) {
        this.codigoPeca = codigoPeca;
    }
}
