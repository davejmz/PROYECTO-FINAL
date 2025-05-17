// Main.java
// Clase principal para interactuar con el usuario y el Árbol AVL.
import java.util.Scanner;
// import java.util.InputMismatchException; // No se usa directamente InputMismatchException aquí

public class Main {
    public static void main(String[] args) {
        AVLTree arbol = new AVLTree(); // Usando AVLTree
        Scanner scanner = new Scanner(System.in); // Usando 'scanner' como en tu original
        String entradaUsuario;

        System.out.println("Bienvenido al Gestor de Árbol AVL.");
        // El PDF especifica terminar con "exit" o -1. Tu código original usa un menú numérico.
        // Mantendré un enfoque similar al de tu código original, pero añadiendo la opción de "salir" del PDF.
        // Y la impresión del árbol tras cada inserción.

        int opcion = 0;

        do {
            // Mostrar árbol antes del menú, si no está vacío. Requisito del PDF es después de cada inserción.
            // En el caso de inserción, se llamará explícitamente.
            // Aquí se puede mostrar como estado actual antes de pedir nueva acción.
            if (opcion != 4 && opcion !=5 ) { // No volver a imprimir si se acaba de mostrar o se va a salir
                 System.out.println("\n--- Árbol Actual ---");
                 arbol.printTree();
            }


            System.out.println("\nMenú de Árbol AVL:");
            System.out.println("1. Insertar número");
            System.out.println("2. Eliminar número");
            System.out.println("3. Vaciar árbol");
            System.out.println("4. Mostrar árbol");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el newline después de nextInt()
            } else {
                entradaUsuario = scanner.nextLine().trim().toLowerCase();
                if (entradaUsuario.equals("salir") || entradaUsuario.equals("-1")) {
                    opcion = 5; // Salir
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número del menú o 'salir'.");
                    opcion = 0; // Resetear opción para continuar el bucle
                    continue; // Saltar al inicio del bucle
                }
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número a insertar: ");
                    if (scanner.hasNextInt()) {
                        int valorInsertar = scanner.nextInt();
                        scanner.nextLine(); // Consumir newline
                        arbol.insertar(valorInsertar);
                        System.out.println("\n--- Árbol Después de Insertar " + valorInsertar + " ---");
                        arbol.printTree(); // Imprimir árbol después de cada inserción
                    } else {
                        System.out.println("Entrada no válida para insertar. Debe ser un número.");
                        scanner.nextLine(); // Limpiar buffer
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el número a eliminar: ");
                     if (scanner.hasNextInt()) {
                        int valorEliminar = scanner.nextInt();
                        scanner.nextLine(); // Consumir newline
                        arbol.eliminar(valorEliminar);
                        System.out.println("\n--- Árbol Después de Eliminar " + valorEliminar + " ---");
                        arbol.printTree(); // Imprimir árbol después de eliminar
                    } else {
                        System.out.println("Entrada no válida para eliminar. Debe ser un número.");
                        scanner.nextLine(); // Limpiar buffer
                    }
                    break;
                case 3:
                    arbol.vaciarArbol();
                    // arbol.printTree(); // Opcional: mostrar árbol vacío
                    break;
                case 4:
                    System.out.println("\n--- Mostrando Árbol Actual ---");
                    arbol.printTree();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    if (opcion != 0) { // Si no fue por entrada inválida de texto
                        System.out.println("Opción no válida. Intente de nuevo.");
                    }
                    break;
            }

        } while (opcion != 5);

        scanner.close();
        System.out.println("Programa terminado.");
    }
}