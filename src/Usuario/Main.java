package Usuario;

import DAO.CuerpoDAO;
import DAO.FormaDAO;
import Interfaces.Cuerpo;
import Interfaces.Forma;
import Utilidades.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

// Usuario.Main.java
public class Main {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Establecer la conexión a la base de datos
            conexion = ConexionDB.getConnection();

            // Crear instancias de DAO.FormaDAO y DAO.CuerpoDAO
            FormaDAO formaDAO = new FormaDAO() {
                @Override
                public void insertar(Forma entidad) throws SQLException {

                }

                @Override
                public void actualizar(Forma entidad) throws SQLException {

                }

                @Override
                public void eliminar(int id) throws SQLException {

                }

                @Override
                public Forma obtenerPorId(int id) throws SQLException {
                    return null;
                }

                @Override
                public List<Forma> obtenerTodos() throws SQLException {
                    return List.of();
                }

                @Override
                public void modificar(Forma forma) throws SQLException {

                }

                @Override
                public void eliminar(Forma forma) throws SQLException {

                }

                @Override
                public Forma obtener(int id) throws SQLException {
                    return null;
                }

                @Override
                public List<Forma> buscarPorTipo(String tipo) throws SQLException {
                    return List.of();
                }
            }; // Asegúrate de tener la implementación correcta
            CuerpoDAO cuerpoDAO = new CuerpoDAO() {
                @Override
                public void insertar(Cuerpo entidad) throws SQLException {

                }

                @Override
                public void actualizar(Cuerpo entidad) throws SQLException {

                }

                @Override
                public void eliminar(int id) throws SQLException {

                }

                @Override
                public Cuerpo obtenerPorId(int id) throws SQLException {
                    return null;
                }

                @Override
                public List<Cuerpo> obtenerTodos() throws SQLException {
                    return List.of();
                }

                @Override
                public void modificar(Cuerpo cuerpo) throws SQLException {

                }

                @Override
                public void eliminar(Cuerpo cuerpo) throws SQLException {

                }

                @Override
                public Cuerpo obtener(int id) throws SQLException {
                    return null;
                }

                @Override
                public List<Cuerpo> buscarPorTipo(String tipo) throws SQLException {
                    return List.of();
                }

                @Override
                public double obtenerVolumenTotal() throws SQLException {
                    return 0;
                }
            }; // Asegúrate de tener la implementación correcta

            // Inicializar el menú con las dependencias necesarias
            Menu menu = new Menu(formaDAO, cuerpoDAO);

            // Mostrar mensaje de bienvenida
            mostrarBienvenida();

            // Iniciar el menú principal
            menu.mostrarMenu();

        } catch (Exception e) {
            System.err.println("Error inesperado en la aplicación: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar la conexión a la base de datos de manera segura
            if (conexion != null) {
                try {
                    conexion.close();
                    System.out.println("\nConexión a la base de datos cerrada correctamente.");
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    private static void mostrarBienvenida() {
        System.out.println("\n=================================");
        System.out.println(" Bienvenido al Sistema de Formas");
        System.out.println("=================================\n");
    }
}