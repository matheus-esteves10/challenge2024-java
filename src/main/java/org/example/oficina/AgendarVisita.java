package org.example.oficina;

import java.time.LocalTime;
import java.util.Date;

public class AgendarVisita extends Oficina {
    private Date dataAgendamento;
    private LocalTime horaDoAgendamento;
    private String mecanicoAgendado;
    private String descricaoServico;
    private Pecas estoque;




    public AgendarVisita(String nomeOficina, String cidadeOficina, String enderecoOficina, String cnpjOficina) {
        super(nomeOficina, cidadeOficina, enderecoOficina, cnpjOficina);
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalTime getHoraDoAgendamento() {
        return horaDoAgendamento;
    }

    public void setHoraDoAgendamento(LocalTime horaDoAgendamento) {
        this.horaDoAgendamento = horaDoAgendamento;
    }

    public String getMecanicoAgendado() {
        return mecanicoAgendado;
    }

    public void setMecanicoAgendado(String mecanicoAgendado) {
        this.mecanicoAgendado = mecanicoAgendado;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public Pecas getEstoque() {
        return estoque;
    }

    public void setEstoque(Pecas estoque) {
        this.estoque = estoque;
    }

    public boolean isHorarioDisponivel() { //metodo para ver se o horario esta disponivel no banco de dados
        //
        return false;
    }

    public boolean isPecaDisponivel(){ //metodo para ver se a peça está disponível no estoque (banco de dados)
        //
        return false;
    }

    public void valorVisita(){ //metodo para valor do serviço
        //
    }

}
