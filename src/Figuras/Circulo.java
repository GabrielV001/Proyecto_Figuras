package Figuras;

import Interfaces.Figura;

public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        super();
        this.radio = radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public void imprimirInformacion() {
        System.out.println("Círculo - Radio: " + radio);
        System.out.println("Perímetro: " + calcularPerimetro());
        System.out.println("Área: " + calcularArea());
    }

    @Override
    public String getTipo() {
        return "";
    }

    @Override
    public String getColor() {
        return "";
    }
}
