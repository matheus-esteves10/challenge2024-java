package org.example.daoOficina;

import org.example.config.DatabaseConfig;
import org.example.model.oficina.Oficina;

import java.sql.SQLException;

public class MainOficina {
    public static void main(String[] args) throws SQLException {

        DatabaseConfig db = new DatabaseConfig(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "RM554769",
                "160805");

        Oficina oficina = new Oficina("Oficina do Joao", "SP", "Rua Conselheiro Carrão 139","31950061000143");
        OficinaDao oficinaDao = new OficinaDaoImpl(db.getConnection());

        //create
//        oficinaDao.create(oficina);

        //update
//        oficina.setId(1l);
//        oficina.setNomeOficina("Oficina do Betinho ");
//        oficinaDao.update(oficina);

        //read
//        List<Oficina> oficinas = oficinaDao.readAll();
//
//        for (Oficina oficinaNova: oficinas){
//            System.out.println(oficinaNova.toString());
//        }

        //delete
       oficinaDao.delete(1l);

    }
}
