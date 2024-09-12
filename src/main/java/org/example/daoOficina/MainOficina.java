package org.example.daoOficina;

import org.example.config.DatabaseConfig;
import org.example.oficina.Oficina;

import java.sql.SQLException;
import java.util.List;

public class MainOficina {
    public static void main(String[] args) throws SQLException {

        DatabaseConfig db = new DatabaseConfig(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "RM554769",
                "160805");

        Oficina oficina = new Oficina(2l, "Excluir", "SP", "Rua Conselheiro Carrão 139", "31950061000143");
        IOficina oficinaDao = new OficinaDaoImpl(db.getConnection());

        //create
        oficinaDao.create(oficina);

        //update
        oficina.setNomeOficina("Oficina do Betinho ");
        oficinaDao.update(oficina);

        //read
        List<Oficina> oficinas = oficinaDao.readAll();

        for (Oficina oficinaNova: oficinas){
            System.out.println(oficinaNova.toString());
        }

        //delete
        oficinaDao.delete(2l);

    }
}
