public abstract  class Figura {

    protected String tipo;
    protected double area;

    abstract double calcularArea() throws IllegalArgumentException;

    public String getTipo() {
        return tipo;
    }

    public double getArea() {
        return area;
    }

}
