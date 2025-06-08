import java.util.List;
import java.util.Scanner;

public class CalculoEstadisticasStarter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorUsuarios controlador = new ControladorUsuarios();

        ControladorUsuarios.MensajeDecorativo.mostrar("Bienvenido al Sistema de Registro de Usuarios");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Registrar usuario");
            System.out.println("2. Mostrar estadísticas");
            System.out.println("3. Buscar usuario por nombre");
            System.out.println("4. Buscar usuarios por ciudad");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    controlador.registrarUsuario(scanner);
                    break;
                case "2":
                    controlador.mostrarEstadisticas();
                    break;
                case "3":
                    System.out.print("Ingrese nombre a buscar: ");
                    String nombre = scanner.nextLine();
                    Usuario usuario = controlador.buscarUsuario(nombre);
                    if (usuario != null) {
                        System.out.println("Usuario encontrado: " + usuario);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case "4":
                    System.out.print("Ingrese ciudad a buscar: ");
                    String ciudad = scanner.nextLine();
                    List<Usuario> usuariosPorCiudad = controlador.buscarUsuarioPorCiudad(ciudad);
                    if (!usuariosPorCiudad.isEmpty()) {
                        System.out.println("Usuarios en la ciudad " + ciudad + ":");
                        for (Usuario u : usuariosPorCiudad) {
                            System.out.println(u);
                        }
                    } else {
                        System.out.println("No se encontraron usuarios en esa ciudad.");
                    }
                    break;
                case "5":
                    salir = true;
                    ControladorUsuarios.MensajeDecorativo.mostrar("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
