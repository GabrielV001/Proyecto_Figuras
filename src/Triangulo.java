public class Triangulo extends Figura {
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private double lado3;

    // Constructor
    public Triangulo(double base, double altura, double lado1, double lado2, double lado3) {
        super();
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public Triangulo(double l1, double l2, double l3) {
    }

    // Implementación del método abstracto para calcular área
    @Override
    public double calcularArea() {
        return (base * altura) / 2;
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

    // Implementación del método abstracto para calcular perímetro
    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    // Getters y Setters
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    // Sobreescritura del método toString
    @Override
    public String toString() {
        return "Triangulo{" +
                "base=" + base +
                ", altura=" + altura +
                ", lado1=" + lado1 +
                ", lado2=" + lado2 +
                ", lado3=" + lado3 +
                '}';
    }
}