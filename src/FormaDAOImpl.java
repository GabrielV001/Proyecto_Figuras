import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// FormaDAOImpl.java


public class FormaDAOImpl implements FormaDAO {
    private Connection conexion;

    public FormaDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Forma forma) throws SQLException {
        String sql = "INSERT INTO Forma (tipo, color) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, forma.getTipo());
            stmt.setString(2, forma.getColor());
            stmt.executeUpdate();
        }
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
    public void modificar(Forma forma) throws SQLException {
        String sql = "UPDATE Forma SET tipo = ?, color = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, forma.getTipo());
            stmt.setString(2, forma.getColor());
            stmt.setInt(3, forma.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Forma forma) throws SQLException {
        String sql = "DELETE FROM Forma WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, forma.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Forma obtener(int id) throws SQLException {
        String sql = "SELECT * FROM Forma WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Forma(
                    ) {
                        @Override
                        public int getId() {
                            return 0;
                        }

                        @Override
                        public void setId(int id) {

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
                        public String getTipo() {
                            return "";
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
    public List<Forma> obtenerTodos() throws SQLException {
        List<Forma> formas = new ArrayList<>();
        String sql = "SELECT * FROM Forma";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                formas.add(new Forma(
                ) {
                    @Override
                    public int getId() {
                        return 0;
                    }

                    @Override
                    public void setId(int id) {

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
                    public String getTipo() {
                        return "";
                    }

                    @Override
                    public String getColor() {
                        return "";
                    }
                });
            }
        }
        return formas;
    }

    @Override
    public List<Forma> buscarPorTipo(String tipo) throws SQLException {
        List<Forma> formas = new ArrayList<>();
        String sql = "SELECT * FROM Forma WHERE tipo = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    formas.add(new Forma(
                    ) {
                        @Override
                        public int getId() {
                            return 0;
                        }

                        @Override
                        public void setId(int id) {

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
                        public String getTipo() {
                            return "";
                        }

                        @Override
                        public String getColor() {
                            return "";
                        }
                    });
                }
            }
        }
        return formas;
    }
}
