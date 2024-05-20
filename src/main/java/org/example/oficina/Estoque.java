package org.example.oficina;

import java.util.ArrayList;
import java.util.List;

public class Estoque extends Oficina{
    private boolean isDisponivel;
    List <String> pecas = new ArrayList<>(); //peças irão ser adicionadas futuramente



    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(boolean disponivel) {
        isDisponivel = disponivel;
    }

    public List<String> getPecas() {
        return pecas;
    }

    public void setPecas(List<String> pecas) {
        this.pecas = pecas;
    }
}
