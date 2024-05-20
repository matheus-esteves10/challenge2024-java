package org.example.oficina;

public class Oficina {
    private String nomeOficina;
    private String cidadeOficina;
    private String enderecoOficina;
    private String cnpjOficina;
    private String mecanicos;


    public Oficina(String nomeOficina, String cidadeOficina, String enderecoOficina, String cnpjOficina) {
        this.nomeOficina = nomeOficina;
        this.cidadeOficina = cidadeOficina;
        this.enderecoOficina = enderecoOficina;
        this.cnpjOficina = cnpjOficina;
    }

    public Oficina() {

    }

    public String getNomeOficina() {
        return nomeOficina;
    }

    public void setNomeOficina(String nomeOficina) {
        this.nomeOficina = nomeOficina;
    }

    public String getCidadeOficina() {
        return cidadeOficina;
    }

    public void setCidadeOficina(String cidadeOficina) {
        this.cidadeOficina = cidadeOficina;
    }

    public String getEnderecoOficina() {
        return enderecoOficina;
    }

    public void setEnderecoOficina(String enderecoOficina) {
        this.enderecoOficina = enderecoOficina;
    }

    public String getCnpjOficina() {
        return cnpjOficina;
    }

    public void setCnpjOficina(String cnpjOficina) {
        this.cnpjOficina = cnpjOficina;
    }

    public String getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(String mecanicos) {
        this.mecanicos = mecanicos;
    }

    public void verificarCnpj(String cnpjOficina){
        //
    }
}
