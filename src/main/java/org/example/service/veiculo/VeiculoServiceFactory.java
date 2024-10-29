package org.example.service.veiculo;

import org.example.service.Service;

public class VeiculoServiceFactory {
    private VeiculoServiceFactory() {
    }

    public static Service create() {
        return new VeiculoServiceImpl();
    }
}
