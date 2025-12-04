package DAO;

import Interfaces.Forma;

import java.sql.*;
import java.util.List;

public interface FormaDAO extends DAO<Forma> {
    void modificar(Forma forma) throws SQLException;

    void eliminar(Forma forma) throws SQLException;

    Forma obtener(int id) throws SQLException;

    List<Forma> buscarPorTipo(String tipo) throws SQLException;
}

