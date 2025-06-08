import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ControladorUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();
    private static Random random = new Random();

    public void registrarUsuario(Scanner scanner) {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        int edad = 0;
        boolean edadValida = false;
        while (!edadValida) {
            try {
                System.out.print("Ingrese edad: ");
                edad = Integer.parseInt(scanner.nextLine());
                if (edad <= 0) {
                    throw new IllegalArgumentException("La edad debe ser positiva.");
                }
                edadValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Intente nuevamente.");
            }
        }

        System.out.print("Ingrese ciudad: ");
        String ciudad = scanner.nextLine();

        usuarios.add(new Usuario(nombre, edad, ciudad));
    }

    public void mostrarEstadisticas() {
        System.out.println("Total de usuarios registrados: " + usuarios.size());
        System.out.println("Promedio de edad: " + calcularPromedioEdad());
        System.out.println("Nombre más largo: " + obtenerNombreMasLargo());
        System.out.println("Usuario destacado: " + elegirUsuarioDestacado());
    }

    public static double calcularPromedioEdad(List<Usuario> usuarios) {
        if (usuarios.isEmpty()) return 0;
        int suma = 0;
        for (Usuario u : usuarios) {
            suma += u.getEdad();
        }
        return (double) suma / usuarios.size();
    }

    public double calcularPromedioEdad() {
        return calcularPromedioEdad(usuarios);
    }

    public String obtenerNombreMasLargo() {
        String nombreMasLargo = "";
        for (Usuario u : usuarios) {
            if (u.getNombre().length() > nombreMasLargo.length()) {
                nombreMasLargo = u.getNombre();
            }
        }
        return nombreMasLargo;
    }

    public Usuario elegirUsuarioDestacado() {
        if (usuarios.isEmpty()) return null;
        int index = random.nextInt(usuarios.size());
        return usuarios.get(index);
    }

    // Método sobrecargado: búsqueda por nombre
    public Usuario buscarUsuario(String nombre) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }

    // Método sobrecargado: búsqueda por ciudad
    public List<Usuario> buscarUsuarioPorCiudad(String ciudad) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.getCiudad().equalsIgnoreCase(ciudad)) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    // Clase anidada estática para mostrar mensaje decorativo
    public static class MensajeDecorativo {
        public static void mostrar(String mensaje) {
            System.out.println("***************");
            System.out.println("*** " + mensaje + " ***");
            System.out.println("***************");
        }
    }
}
