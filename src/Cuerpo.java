import java.util.Objects;

// Clase abstracta Cuerpo
public abstract class Cuerpo implements Forma {
    protected int id;
    protected String nombre;

    public Cuerpo(String nombre) {
        this.nombre = nombre;
    }

    public Cuerpo(int id, String tipo, double volumen) {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public abstract double calcularVolumen();

    @Override
    public abstract double calcularPerimetro();

    @Override
    public abstract double calcularArea();

    @Override
    public abstract void imprimirInformacion();

    @Override
    public String toString() {
        return "Cuerpo: " + nombre +
                "\nVolumen: " + calcularVolumen() +
                "\nÁrea superficial: " + calcularArea();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cuerpo cuerpo = (Cuerpo) obj;
        return id == cuerpo.id &&
                Objects.equals(nombre, cuerpo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    public String getTipo() {
        return "";
    }

    public double getVolumen() {
        return 0;
    }
}