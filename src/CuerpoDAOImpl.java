import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuerpoDAOImpl implements CuerpoDAO {
    private Connection conexion;

    public CuerpoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Cuerpo cuerpo) throws SQLException {
        String sql = "INSERT INTO Cuerpo (tipo, volumen) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cuerpo.getTipo());
            stmt.setDouble(2, cuerpo.getVolumen());
            stmt.executeUpdate();
        }
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
    public void modificar(Cuerpo cuerpo) throws SQLException {
        String sql = "UPDATE Cuerpo SET tipo = ?, volumen = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cuerpo.getTipo());
            stmt.setDouble(2, cuerpo.getVolumen());
            stmt.setInt(3, cuerpo.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Cuerpo cuerpo) throws SQLException {
        String sql = "DELETE FROM Cuerpo WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cuerpo.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Cuerpo obtener(int id) throws SQLException {
        String sql = "SELECT * FROM Cuerpo WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cuerpo(
                            rs.getInt("id"),
                            rs.getString("tipo"),
                            rs.getDouble("volumen")
                    ) {
                        @Override
                        public double calcularVolumen() {
                            return 0;
                        }

                        @Override
                        public double calcularPerimetro() {
                            return 0;
                        }

                        @Override
                        public double calcularArea() {
                            return 0;
                        }

                        @Override
                        public void imprimirInformacion() {

                        }

                        @Override
                        public String getColor() {
                            return "";
                        }
                    };
                }
                return null;
            }
        }
    }

    @Override
    public List<Cuerpo> obtenerTodos() throws SQLException {
        List<Cuerpo> cuerpos = new ArrayList<>();
        String sql = "SELECT * FROM Cuerpo";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                cuerpos.add(new Cuerpo(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getDouble("volumen")
                ) {
                    @Override
                    public double calcularVolumen() {
                        return 0;
                    }

                    @Override
                    public double calcularPerimetro() {
                        return 0;
                    }

                    @Override
                    public double calcularArea() {
                        return 0;
                    }

                    @Override
                    public void imprimirInformacion() {

                    }

                    @Override
                    public String getColor() {
                        return "";
                    }
                });
            }
        }
        return cuerpos;
    }

    @Override
    public List<Cuerpo> buscarPorTipo(String tipo) throws SQLException {
        List<Cuerpo> cuerpos = new ArrayList<>();
        String sql = "SELECT * FROM Cuerpo WHERE tipo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    cuerpos.add(new Cuerpo(
                            rs.getInt("id"),
                            rs.getString("tipo"),
                            rs.getDouble("volumen")
                    ) {
                        @Override
                        public double calcularVolumen() {
                            return 0;
                        }

                        @Override
                        public double calcularPerimetro() {
                            return 0;
                        }

                        @Override
                        public double calcularArea() {
                            return 0;
                        }

                        @Override
                        public void imprimirInformacion() {

                        }

                        @Override
                        public String getColor() {
                            return "";
                        }
                    });
                }
            }
        }
        return cuerpos;
    }

    @Override
    public double obtenerVolumenTotal() throws SQLException {
        String sql = "SELECT SUM(volumen) as volumen_total FROM Cuerpo";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("volumen_total");
            }
            return 0.0;
        }
    }
}