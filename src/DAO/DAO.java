package DAO;

import java.sql.SQLException;
import java.util.List;

// Interfaz genérica DAO.DAO
public interface DAO<T> {
    void insertar(T entidad) throws SQLException;
    void actualizar(T entidad) throws SQLException;
    void eliminar(int id) throws SQLException;
    T obtenerPorId(int id) throws SQLException;
    List<T> obtenerTodos() throws SQLException;
}
