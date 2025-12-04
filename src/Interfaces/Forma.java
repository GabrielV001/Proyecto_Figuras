package Interfaces;

// Interfaz Interfaces.Forma
public interface Forma {
    int getId();
    void setId(int id);
    double calcularPerimetro();
    double calcularArea();
    void imprimirInformacion();

    String getTipo();

    String getColor();
}


