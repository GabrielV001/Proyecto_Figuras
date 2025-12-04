public class Validador {
    public static boolean validarMedidasPositivas(double... medidas) {
        for (double medida : medidas) {
            if (medida <= 0) return false;
        }
        return true;
    }

    public static boolean validarTriangulo(double lado1, double lado2, double lado3) {
        return (lado1 + lado2 > lado3) &&
                (lado2 + lado3 > lado1) &&
                (lado1 + lado3 > lado2);
    }
}

