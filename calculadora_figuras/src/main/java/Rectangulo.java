public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.tipo = "Rectángulo";
        this.base = base;
        this.altura = altura;
    }

    @Override
    double calcularArea() throws IllegalArgumentException {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Base y altura deben ser positivos");
        }
        area = base * altura;
        return area;
    }
}


