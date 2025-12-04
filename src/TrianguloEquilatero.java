public class TrianguloEquilatero extends Triangulo {
    public TrianguloEquilatero(double lado) {
        super(lado, lado, lado);
    }

    @Override
    public double calcularPerimetro() {
        return 0;
    }

    @Override
    public double calcularArea() {
        double s = calcularPerimetro() / 2;
        double lado1 = 0;
        return Math.sqrt(s * (s - lado1) * (s - lado1) * (s - lado1));
    }

}