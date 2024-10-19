package org.example.model.oficina;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Agendamentos extends Oficina {
    private Oficina oficina;
    private LocalDate dataAgendamento;
    private LocalTime horaDoAgendamento;
    private String descricaoServico;




    public Agendamentos(Long id, String nomeOficina, String cidadeOficina, String enderecoOficina, String cnpjOficina) {
        super(id, nomeOficina, cidadeOficina, enderecoOficina, cnpjOficina);
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalTime getHoraDoAgendamento() {
        return horaDoAgendamento;
    }

    public void setHoraDoAgendamento(LocalTime horaDoAgendamento) {
        this.horaDoAgendamento = horaDoAgendamento;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public boolean isHorarioDisponivel() { //metodo para ver se o horario esta disponivel no banco de dados
        //
        return false;
    }

    public boolean isPecaDisponivel(){ //metodo para ver se a peça está disponível no estoque (banco de dados)
        //
        return false;
    }


}
