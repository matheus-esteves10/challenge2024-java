package org.example.daoOficina;

import org.example.model.oficina.Oficina;

import java.sql.SQLException;
import java.util.List;

public interface IOficina {
    //create
    void create (Oficina oficina) throws SQLException;

    //read
    List<Oficina> readAll() throws SQLException;

    //update
    void update(Oficina oficina) throws SQLException;

    //delete
    void delete(Long id) throws SQLException;
}