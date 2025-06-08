public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.tipo = "Círculo";
        this.radio = radio;
    }

    @Override
    double calcularArea() throws IllegalArgumentException {
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser positivo");
        }
        area = Math.PI * Math.pow(radio, 2);
        return area;
    }
}
