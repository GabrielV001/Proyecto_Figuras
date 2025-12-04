package Figuras;

import Interfaces.Cuerpo;

public class Esfera extends Cuerpo {
    private double radio;

    public Esfera(double radio) {
        super("Figuras.Esfera");
        this.radio = radio;
    }

    @Override
    public double calcularVolumen() {
        return (4.0/3.0) * Math.PI * Math.pow(radio, 3);
    }

    @Override
    public double calcularArea() {
        return 4 * Math.PI * Math.pow(radio, 2);
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
        return 2 * Math.PI * radio;
    }
}