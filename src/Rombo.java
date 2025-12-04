// Clases de figuras faltantes
public class Rombo extends Figura {
    private double diagonal1;
    private double diagonal2;
    private double lado;

    public Rombo(double diagonal1, double diagonal2, double lado) {
        super();
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return (diagonal1 * diagonal2) / 2;
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

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}

