public class Cilindro extends Cuerpo {
    private Circulo base;
    private Rectangulo cuerpo;

    public Cilindro(double radio, double altura) {
        super("Cilindro");
        this.base = new Circulo(radio);
        this.cuerpo = new Rectangulo(2 * Math.PI * radio, altura);
    }

    @Override
    public double calcularVolumen() {
        return base.calcularArea() * cuerpo.altura;
    }

    @Override
    public double calcularArea() {
        return 2 * base.calcularArea() + cuerpo.calcularArea();
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
        return 2 * base.calcularPerimetro() + 4 * cuerpo.altura;
    }
}

