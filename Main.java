//Autor: David Cristopher Coronado Jiménez Cabrera
//5/17/2025
//PROYECTO FINAL: Implementación de un Árbol AVL en Java. 


//Esta es la clase principal para interactuar con el usuario y el Árbol AVL.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVLTree arbol = new AVLTree(); //Usando AVLTree
        Scanner scanner = new Scanner(System.in); //Usamos Scanner para la entrada del usuario
        String entradaUsuario;

        System.out.println("Bienvenido al Gestor de Árbol AVL.");
        //Se añadió la opción "Salir", como sugerencia en el PDF.
        //También la impresión del árbol tras cada inserción.

        int opcion = 0;

        do {
            //Acá se muestra el árbol antes del menú, si no está vacío, esto después de cada incersión. 
            //En el caso de inserción, se llamará explícitamente.
            //Aquí se muestra como estado actual antes de pedir nueva acción.
            if (opcion != 4 && opcion !=5 ) { //No volver a imprimir si se acaba de mostrar o se va a salir
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
                scanner.nextLine(); //Se consume el newline después de nextInt()
            } else {
                entradaUsuario = scanner.nextLine().trim().toLowerCase();
                if (entradaUsuario.equals("salir") || entradaUsuario.equals("-1")) {
                    opcion = 5; //Salir
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número del menú o 'salir'.");
                    opcion = 0; // quí se resetea la opción para continuar el bucle
                    continue; //Se salta al inicio del bucle
                }
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número a insertar: ");
                    if (scanner.hasNextInt()) {
                        int valorInsertar = scanner.nextInt();
                        scanner.nextLine(); //Consumir newline, y así sucesivamente
                        arbol.insertar(valorInsertar);
                        System.out.println("\n--- Árbol Después de Insertar " + valorInsertar + " ---");
                        arbol.printTree(); //Se imprime árbol después de cada inserción
                    } else {
                        System.out.println("Entrada no válida para insertar. Debe ser un número.");
                        scanner.nextLine(); //Limpiar buffer
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el número a eliminar: ");
                     if (scanner.hasNextInt()) {
                        int valorEliminar = scanner.nextInt();
                        scanner.nextLine(); //Consumir newline
                        arbol.eliminar(valorEliminar);
                        System.out.println("\n--- Árbol Después de Eliminar " + valorEliminar + " ---");
                        arbol.printTree(); //Imprimir árbol después de eliminar
                    } else {
                        System.out.println("Entrada no válida para eliminar. Debe ser un número.");
                        scanner.nextLine(); //Limpiar buffer
                    }
                    break;
                case 3:
                    arbol.vaciarArbol();
                    //arbol.printTree(); // Opcional: mostrar árbol vacío
                    break;
                case 4:
                    System.out.println("\n--- Mostrando Árbol Actual ---");
                    arbol.printTree();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    if (opcion != 0) { //Si no fue por entrada inválida de texto
                        System.out.println("Opción no válida. Intente de nuevo.");
                    }
                    break;
            }

        } while (opcion != 5);

        scanner.close();
        System.out.println("Programa terminado.");
    }
}