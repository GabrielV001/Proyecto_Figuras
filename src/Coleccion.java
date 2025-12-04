import java.util.ArrayList;
import java.util.List;

// Clase Coleccion
public class Coleccion {
    private List<Figura> figuras;
    private List<Cuerpo> cuerpos;

    public Coleccion() {
        figuras = new ArrayList<>();
        cuerpos = new ArrayList<>();
    }

    public void agregarFigura(Figura figura) {
        figuras.add(figura);
    }

    public void agregarCuerpo(Cuerpo cuerpo) {
        cuerpos.add(cuerpo);
    }

    public double calcularAreaTotal() {
        double areaTotal = 0;
        for(Figura f : figuras) {
            areaTotal += f.calcularArea();
        }
        return areaTotal;
    }

    public double calcularPerimetroTotal() {
        double perimetroTotal = 0;
        for(Figura f : figuras) {
            perimetroTotal += f.calcularPerimetro();
        }
        return perimetroTotal;
    }
}
