package org.example.dao.daoVeiculo;

import org.example.config.DatabaseConnectionFactory;
import org.example.dao.Dao;
import org.example.exceptions.NotFoundException;
import org.example.exceptions.NotSavedException;
import org.example.model.informacoesPessoais.Pessoa;
import org.example.model.informacoesPessoais.Veiculo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VeiculoDaoImp implements Dao<Veiculo> {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public VeiculoDaoImp() {
    }

    public VeiculoDaoImp(Connection connection) {}

    @Override
    public Veiculo save(Veiculo veiculo, Connection connection) throws SQLException, NotSavedException {
        String sql = "INSERT INTO T_ATC_VEICULO (nm_marca, nm_modelo, nr_ano, nr_documento, nr_placa, t_atc_usuario_id_usuario) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Definindo os parâmetros de entrada
            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getAno());
            stmt.setString(4, veiculo.getDocumentoVeiculo());
            stmt.setString(5, veiculo.getPlacaVeiculo());
            stmt.setLong(6, veiculo.getIdPessoa());

            // Executando a inserção
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new NotSavedException();
            }

            // Recuperando o ID gerado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    veiculo.setId(id);
                } else {
                    throw new NotSavedException();
                }
            }
        }

        return veiculo;
    }


    @Override
    public List<Veiculo> readAll() {
        List<Veiculo> resultado = new ArrayList<>();
        final String sql = "SELECT * FROM t_atc_veiculo";
        try (Connection connection = DatabaseConnectionFactory.create().get();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Long id = rs.getLong("ID_VEICULO");
                String marca = rs.getString("NM_MARCA");
                String modelo = rs.getString("NM_MODELO");
                String ano = rs.getString("NR_ANO");
                String documento = rs.getString("Nr_DOCUMENTO");
                String placa = rs.getString("NR_PLACA");
                Long idPessoa = rs.getLong("t_atc_usuario_id_usuario");
                resultado.add(new Veiculo(id, marca, modelo, ano, documento, placa, idPessoa));
            }
        }catch (SQLException e){
            logger.warning("não foi possível localizar nenhum registro de pessoa: "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public Veiculo readById(Long idPessoa) throws NotFoundException {
        final String sql = "SELECT * FROM t_atc_veiculo WHERE t_atc_usuario_id_usuario = ?";

        try (Connection connection = DatabaseConnectionFactory.create().get()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idPessoa);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Long id = rs.getLong("ID_VEICULO");
                String marca = rs.getString("NM_MARCA");
                String modelo = rs.getString("NM_MODELO");
                String ano = rs.getString("NR_ANO");
                String documento = rs.getString("NR_DOCUMENTO");
                String placa = rs.getString("NR_PLACA");


                // Retorna o veículo encontrado
                return new Veiculo(id, marca, modelo, ano, documento, placa, idPessoa);
            } else {
                // Caso não encontre o veículo, lança exceção
                throw new NotFoundException();
            }
        } catch (SQLException e) {
            logger.warning("Erro ao buscar veículo pelo ID: " + e.getMessage());
            throw new RuntimeException("Erro ao buscar veículo pelo ID", e);
        }
    }


    @Override
    public Veiculo update(Veiculo veiculo, Connection connection) throws NotFoundException, SQLException {
        final String sql = "UPDATE t_atc_veiculo SET nm_marca = ?, nm_modelo = ?, nr_ano = ?, nr_documento = ?, nr_placa = ? WHERE t_atc_usuario_id_usuario = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, veiculo.getMarca());
        stmt.setString(2, veiculo.getModelo());
        stmt.setString(3, veiculo.getAno());
        stmt.setString(4, veiculo.getDocumentoVeiculo());
        stmt.setString(5, veiculo.getPlacaVeiculo());
        stmt.setLong(6, veiculo.getIdPessoa());
        int linhasAlteradas = stmt.executeUpdate();
        if(linhasAlteradas == 0 ) {
            throw new NotFoundException();
        }
        return veiculo;
    }

    @Override
    public void deleteById(Long id, Connection connection) throws SQLException, NotFoundException {
        final String sql = "DELETE FROM t_atc_veiculo WHERE id_veiculo = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        int linhasAlteradas = stmt.executeUpdate();
        if(linhasAlteradas == 0) {
            throw new NotFoundException();
        }
    }
}
