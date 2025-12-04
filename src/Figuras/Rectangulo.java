package Figuras;

import Interfaces.Figura;

// Clase Figuras.Rectangulo
public class Rectangulo extends Figura {
    protected double base;
    protected double altura;

    public Rectangulo(double base, double altura) {
        super();
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public double calcularArea() {
        return base * altura;
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
}

