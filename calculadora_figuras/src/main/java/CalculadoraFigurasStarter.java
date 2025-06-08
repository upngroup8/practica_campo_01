import java.util.ArrayList;
import java.util.Scanner;

public class CalculadoraFigurasStarter {

    static class Decorador {
        static void imprimirCabecera(String texto) {
            System.out.println("\n=== " + texto + " ===");
        }

        static void imprimirLinea() {
            System.out.println("-----------------------------");
        }
    }

    private static ArrayList<Figura> historial = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Método estático para mostrar estadísticas
    private static void mostrarEstadisticas() {
        if (historial.isEmpty()) {
            System.out.println("No hay cálculos realizados.");
            return;
        }

        Decorador.imprimirCabecera("Estadísticas");
        System.out.println("Total de figuras calculadas: " + historial.size());

        double sumaAreas = 0;
        for (Figura figura : historial) {
            sumaAreas += figura.getArea();
        }
        double promedio = sumaAreas / historial.size();
        System.out.printf("Promedio de áreas: %.2f\n", promedio);
    }

    // Método para mostrar historial
    private static void mostrarHistorial() {
        Decorador.imprimirCabecera("Historial de Cálculos");
        if (historial.isEmpty()) {
            System.out.println("No hay cálculos realizados.");
            return;
        }

        for (int i = 0; i < historial.size(); i++) {
            Figura figura = historial.get(i);
            System.out.printf("%d. %s - Área: %.2f\n",
                    i + 1, figura.getTipo(), figura.getArea());
        }
    }

    public static void main(String[] args) {
        while (true) {
            Decorador.imprimirCabecera("Calculadora de Figuras Geométricas");
            System.out.println("1. Círculo");
            System.out.println("2. Rectángulo");
            System.out.println("3. Triángulo");
            System.out.println("4. Mostrar historial");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1: // Círculo
                        System.out.print("Ingrese el radio: ");
                        double radio = Double.parseDouble(scanner.nextLine());
                        Figura circulo = new Circulo(radio);
                        circulo.calcularArea();
                        historial.add(circulo);
                        System.out.printf("Área del círculo: %.2f\n", circulo.getArea());
                        break;

                    case 2: // Rectángulo
                        System.out.print("Ingrese la base: ");
                        double baseRect = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese la altura: ");
                        double alturaRect = Double.parseDouble(scanner.nextLine());
                        Figura rectangulo = new Rectangulo(baseRect, alturaRect);
                        rectangulo.calcularArea();
                        historial.add(rectangulo);
                        System.out.printf("Área del rectángulo: %.2f\n", rectangulo.getArea());
                        break;

                    case 3: // Triángulo
                        System.out.print("Ingrese la base: ");
                        double baseTri = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese la altura: ");
                        double alturaTri = Double.parseDouble(scanner.nextLine());
                        Figura triangulo = new Triangulo(baseTri, alturaTri);
                        triangulo.calcularArea();
                        historial.add(triangulo);
                        System.out.printf("Área del triángulo: %.2f\n", triangulo.getArea());
                        break;

                    case 4: // Mostrar historial
                        mostrarHistorial();
                        break;

                    case 5: // Salir
                        mostrarEstadisticas();
                        System.out.println("¡Gracias por usar la calculadora!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            Decorador.imprimirLinea();
        }
    }

}
