package Figuras;

import Interfaces.Cuerpo;

public class Tetraedro extends Cuerpo {
    private TrianguloEquilatero cara;

    public Tetraedro(double lado) {
        super("Figuras.Tetraedro");
        this.cara = new TrianguloEquilatero(lado);
    }

    @Override
    public double calcularVolumen() {
        double lado = cara.getLado1();
        return Math.pow(lado, 3) / (6 * Math.sqrt(2));
    }

    @Override
    public double calcularArea() {
        return 4 * cara.calcularArea();
    }

    @Override
    public void imprimirInformacion() {

    }

    @Override
    public String getColor() {
        return "";
    }

    @Override
    public double calcularPerimetro() {
        return 6 * cara.getLado1();
    }
}
