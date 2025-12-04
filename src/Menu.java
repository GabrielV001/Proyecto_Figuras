import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private FormaDAO formaDAO;
    private CuerpoDAO cuerpoDAO;

    // Constructor principal
    public Menu(FormaDAO formaDAO, CuerpoDAO cuerpoDAO) {
        this.scanner = new Scanner(System.in);
        this.formaDAO = formaDAO;
        this.cuerpoDAO = cuerpoDAO;
    }

    public <GestorFormas> Menu(GestorFormas gestorFormas) {
    }

    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            try {
                System.out.println("\n=== Menú Principal ===");
                System.out.println("1. Agregar figura");
                System.out.println("2. Agregar cuerpo");
                System.out.println("3. Modificar figura");
                System.out.println("4. Modificar cuerpo");
                System.out.println("5. Eliminar figura");
                System.out.println("6. Eliminar cuerpo");
                System.out.println("7. Listar figuras");
                System.out.println("8. Listar cuerpos");
                System.out.println("9. Calcular área total");
                System.out.println("10. Calcular perímetro total");
                System.out.println("11. Calcular volumen total");
                System.out.println("12. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        agregarFigura();
                        break;
                    case 2:
                        agregarCuerpo();
                        break;
                    case 3:
                        modificarFigura();
                        break;
                    case 4:
                        modificarCuerpo();
                        break;
                    case 5:
                        eliminarFigura();
                        break;
                    case 6:
                        eliminarCuerpo();
                        break;
                    case 7:
                        listarFiguras();
                        break;
                    case 8:
                        listarCuerpos();
                        break;
                    case 9:
                        calcularAreaTotal();
                        break;
                    case 10:
                        calcularPerimetroTotal();
                        break;
                    case 11:
                        calcularVolumenTotal();
                        break;
                    case 12:
                        salir = true;
                        cerrarRecursos();
                        System.out.println("¡Gracias por usar el sistema!");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido");
                scanner.nextLine();
            } catch (SQLException e) {
                System.out.println("Error en la base de datos: " + e.getMessage());
            }
        }
    }

    private void agregarCuerpo() throws SQLException {
        System.out.println("\n=== Agregar Cuerpo ===");
        System.out.println("1. Esfera");
        System.out.println("2. Cubo");
        System.out.println("3. Cilindro");
        System.out.print("Seleccione el tipo de cuerpo: ");

        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Cuerpo nuevoCuerpo = null;

        switch (tipo) {
            case 1: // Esfera
                System.out.print("Ingrese el radio: ");
                double radio = scanner.nextDouble();
                nuevoCuerpo = new Esfera(radio);
                break;

            case 2: // Cubo
                System.out.print("Ingrese el lado: ");
                double lado = scanner.nextDouble();
                nuevoCuerpo = new Cubo(lado);
                break;

            case 3: // Cilindro
                System.out.print("Ingrese el radio: ");
                double radioCilindro = scanner.nextDouble();
                System.out.print("Ingrese la altura: ");
                double altura = scanner.nextDouble();
                nuevoCuerpo = new Cilindro(radioCilindro, altura);
                break;

            default:
                System.out.println("Tipo de cuerpo no válido");
                return;
        }

        cuerpoDAO.insertar(nuevoCuerpo);
        System.out.println("Cuerpo agregado exitosamente");
    }

    private void agregarFigura() throws SQLException {
        System.out.println("\n=== Agregar Figura ===");
        System.out.println("1. Círculo");
        System.out.println("2. Rectángulo");
        System.out.println("3. Triángulo");
        System.out.print("Seleccione el tipo de figura: ");

        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Forma nuevaFigura = null;

        switch (tipo) {
            case 1: // Círculo
                System.out.print("Ingrese el radio: ");
                double radio = scanner.nextDouble();
                nuevaFigura = new Circulo(radio);
                break;

            case 2: // Rectángulo
                System.out.print("Ingrese el ancho: ");
                double ancho = scanner.nextDouble();
                System.out.print("Ingrese el alto: ");
                double alto = scanner.nextDouble();
                nuevaFigura = new Rectangulo(ancho, alto);
                break;

            case 3: // Triángulo
                System.out.print("Ingrese el lado 1: ");
                double lado1 = scanner.nextDouble();
                System.out.print("Ingrese el lado 2: ");
                double lado2 = scanner.nextDouble();
                System.out.print("Ingrese el lado 3: ");
                double lado3 = scanner.nextDouble();
                nuevaFigura = new Triangulo(lado1, lado2, lado3);
                break;

            default:
                System.out.println("Tipo de figura no válido");
                return;
        }

        formaDAO.insertar(nuevaFigura);
        System.out.println("Figura agregada exitosamente");
    }


    private void calcularVolumenTotal() throws SQLException {
        List<Cuerpo> cuerpos = cuerpoDAO.obtenerTodos();
        double volumenTotal = 0;
        for (Cuerpo cuerpo : cuerpos) {
            volumenTotal += cuerpo.calcularVolumen();
        }
        System.out.println("Volumen total de todos los cuerpos: " + volumenTotal);
    }

    private void calcularPerimetroTotal() throws SQLException {
        List<Forma> figuras = formaDAO.obtenerTodos();
        double perimetroTotal = 0;
        for (Forma figura : figuras) {
            perimetroTotal += figura.calcularPerimetro();
        }
        System.out.println("Perímetro total de todas las figuras: " + perimetroTotal);
    }

    private void calcularAreaTotal() throws SQLException {
        List<Forma> figuras = formaDAO.obtenerTodos();
        double areaTotal = 0;
        for (Forma figura : figuras) {
            areaTotal += figura.calcularArea();
        }
        System.out.println("Área total de todas las figuras: " + areaTotal);
    }

    private void listarCuerpos() throws SQLException {
        List<Cuerpo> cuerpos = cuerpoDAO.obtenerTodos();
        if (cuerpos.isEmpty()) {
            System.out.println("No hay cuerpos registrados");
            return;
        }
        for (Cuerpo cuerpo : cuerpos) {
            cuerpo.imprimirInformacion();
            System.out.println("--------------------");
        }
    }

    private void listarFiguras() throws SQLException {
        List<Forma> figuras = formaDAO.obtenerTodos();
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras registradas");
            return;
        }
        for (Forma figura : figuras) {
            figura.imprimirInformacion();
            System.out.println("--------------------");
        }
    }

private void modificarFigura() throws SQLException {
    System.out.println("\n=== Modificar Figura ===");
    List<Forma> figuras = formaDAO.obtenerTodos();

    if (figuras.isEmpty()) {
        System.out.println("No hay figuras para modificar");
        return;
    }

    // Mostrar lista de figuras con ID
    for (int i = 0; i < figuras.size(); i++) {
        System.out.println("ID: " + (i + 1));
        figuras.get(i).imprimirInformacion();
        System.out.println("--------------------");
    }

    System.out.print("Ingrese el ID de la figura a modificar: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    if (id < 1 || id > figuras.size()) {
        System.out.println("ID no válido");
        return;
    }

    Forma figuraExistente = figuras.get(id - 1);
    // Aquí agregarías la lógica para modificar la figura según su tipo
    // Similar a agregarFigura() pero actualizando en lugar de crear nueva
}

private void modificarCuerpo() throws SQLException {
    System.out.println("\n=== Modificar Cuerpo ===");
    List<Cuerpo> cuerpos = cuerpoDAO.obtenerTodos();

    if (cuerpos.isEmpty()) {
        System.out.println("No hay cuerpos para modificar");
        return;
    }

    // Mostrar lista de cuerpos con ID
    for (int i = 0; i < cuerpos.size(); i++) {
        System.out.println("ID: " + (i + 1));
        cuerpos.get(i).imprimirInformacion();
        System.out.println("--------------------");
    }

    System.out.print("Ingrese el ID del cuerpo a modificar: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    if (id < 1 || id > cuerpos.size()) {
        System.out.println("ID no válido");
        return;
    }

    Cuerpo cuerpoExistente = cuerpos.get(id - 1);
    // Aquí agregarías la lógica para modificar el cuerpo según su tipo
    // Similar a agregarCuerpo() pero actualizando en lugar de crear nuevo
}

private void eliminarFigura() throws SQLException {
    System.out.println("\n=== Eliminar Figura ===");
    List<Forma> figuras = formaDAO.obtenerTodos();

    if (figuras.isEmpty()) {
        System.out.println("No hay figuras para eliminar");
        return;
    }

    // Mostrar lista de figuras con ID
    for (int i = 0; i < figuras.size(); i++) {
        System.out.println("ID: " + (i + 1));
        figuras.get(i).imprimirInformacion();
        System.out.println("--------------------");
    }

    System.out.print("Ingrese el ID de la figura a eliminar: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    if (id < 1 || id > figuras.size()) {
        System.out.println("ID no válido");
        return;
    }

    Forma figuraAEliminar = figuras.get(id - 1);
    formaDAO.eliminar(figuraAEliminar);
    System.out.println("Figura eliminada exitosamente");
}

private void eliminarCuerpo() throws SQLException {
    System.out.println("\n=== Eliminar Cuerpo ===");
    List<Cuerpo> cuerpos = cuerpoDAO.obtenerTodos();

    if (cuerpos.isEmpty()) {
        System.out.println("No hay cuerpos para eliminar");
        return;
    }

    // Mostrar lista de cuerpos con ID
    for (int i = 0; i < cuerpos.size(); i++) {
        System.out.println("ID: " + (i + 1));
        cuerpos.get(i).imprimirInformacion();
        System.out.println("--------------------");
    }

    System.out.print("Ingrese el ID del cuerpo a eliminar: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    if (id < 1 || id > cuerpos.size()) {
        System.out.println("ID no válido");
        return;
    }

    Cuerpo cuerpoAEliminar = cuerpos.get(id - 1);
    cuerpoDAO.eliminar(cuerpoAEliminar);
    System.out.println("Cuerpo eliminado exitosamente");
}

    private void cerrarRecursos() {
        if (scanner != null) {
            scanner.close();
        }
    }

    public static void main(String[] args) {
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
        }; // Asume que tienes implementada la clase FormaDAO
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
        }; // Asume que tienes implementada la clase CuerpoDAO
        Menu menu = new Menu(formaDAO, cuerpoDAO);
        menu.mostrarMenu();
    }
}