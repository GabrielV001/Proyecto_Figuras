package DAO;

import Interfaces.Cuerpo;

import java.sql.*;
import java.util.List;

// Interface DAO.CuerpoDAO
public interface CuerpoDAO extends DAO<Cuerpo> {
    void modificar(Cuerpo cuerpo) throws SQLException;

    void eliminar(Cuerpo cuerpo) throws SQLException;

    Cuerpo obtener(int id) throws SQLException;

    List<Cuerpo> buscarPorTipo(String tipo) throws SQLException;
    double obtenerVolumenTotal() throws SQLException;
}

