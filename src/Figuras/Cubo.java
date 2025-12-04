package Figuras;

import Interfaces.Cuerpo;

// Clases de cuerpos
public class Cubo extends Cuerpo {
    private Cuadrado cara;

    public Cubo(double lado) {
        super("Figuras.Cubo");
        this.cara = new Cuadrado(lado);
    }

    @Override
    public double calcularVolumen() {
        return Math.pow(cara.base, 3);
    }

    @Override
    public double calcularArea() {
        return 6 * cara.calcularArea();
    }

    @Override
    public double calcularPerimetro() {
        return 12 * cara.base;
    }

    @Override
    public void imprimirInformacion() {
        System.out.println("Figuras.Cubo - Lado: " + cara.base);
        System.out.println("Volumen: " + calcularVolumen());
        System.out.println("Área superficial: " + calcularArea());
    }

    @Override
    public String getColor() {
        return "";
    }
}
