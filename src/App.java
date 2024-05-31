import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TorreControl torreControl = new TorreControl();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n7. Inicializar Colas - Revisar Aproximación");
            System.out.println("8. Ejecutar Acción sobre Pista");
            System.out.println("9. Calcular Espera");
            System.out.println("10. Mostrar Colas");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: \n");
            opcion = scanner.nextInt();
            scanner.nextLine(); // consumir el salto de línea

            switch (opcion) {
                case 7:
                    torreControl.inicializarColas();
                    torreControl.revisarAproximacion();
                    break;
                case 8:
                    torreControl.ejecutarAccionPista();
                    break;
                case 9:
                    System.out.print("Ingrese ID del avión: ");
                    String idAvion = scanner.nextLine();
                    torreControl.calcularEspera(idAvion);
                    break;
                case 10:
                    torreControl.mostrarColas();
                    break;
                case 11:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 11);

        scanner.close();
    }
}
