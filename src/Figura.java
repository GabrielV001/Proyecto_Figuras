import java.util.Objects;

// Clase abstracta Figura
public abstract class Figura implements Forma {
    protected int id;
    protected String nombre;

    // Constructor
    public Figura() {
        this.nombre = nombre;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Implementación del método getId de la interfaz
    @Override
    public int getId() {
        return id;
    }

    // Implementación del método setId de la interfaz
    @Override
    public void setId(int id) {
        this.id = id;
    }

    // Métodos abstractos que deben ser implementados por las clases hijas
    @Override
    public abstract double calcularPerimetro();

    @Override
    public abstract double calcularArea();

    @Override
    public abstract void imprimirInformacion();

    // Método toString sobreescrito
    @Override
    public String toString() {
        return "Figura: " + nombre +
                "\nÁrea: " + String.format("%.2f", calcularArea()) +
                "\nPerímetro: " + String.format("%.2f", calcularPerimetro());
    }

    // Método equals sobreescrito
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Figura figura = (Figura) obj;
        return id == figura.id &&
                Objects.equals(nombre, figura.nombre);
    }

    // Método hashCode sobreescrito
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}