//Autor: David Cristopher Coronado Jiménez Cabrera
//5/17/2025
//PROYECTO FINAL: Implementación de un Árbol AVL en Java. 
//Esta clase va a gestionar la estructura y operaciones del Árbol AVL.
public class AVLTree {
    Node raiz; //Raíz del árbol

    //Constructor
public AVLTree() {
        this.raiz = null;
    }

    //*Estos son métodos auxiliares para altura y balance

    //Obtiene la altura de un nodo (0 si el nodo es nulo)
    private int obtenerAltura(Node nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    //Calcula el mayor de dos números enteros
    private int maximo(int a, int b) {
        return (a > b) ? a : b;
    }

    //Este método calcula el factor de balance de un nodo
    //Factor de Balance = altura(subárbol izquierdo) - altura(subárbol derecho)
    private int obtenerFactorBalance(Node nodo) {
        if (nodo == null) {
            return 0;
        }
        return obtenerAltura(nodo.izquierda) - obtenerAltura(nodo.derecha);
    }

    //*Métodos de rotación para mantener el balance

    //Rotación simple a la derecha
    private Node rotarHaciaDerecha(Node y) {
        Node x = y.izquierda;
        Node T2 = x.derecha;

        //Para realizar rotación
        x.derecha = y;
        y.izquierda = T2;

        //Actualizar alturas
        y.altura = maximo(obtenerAltura(y.izquierda), obtenerAltura(y.derecha)) + 1;
        x.altura = maximo(obtenerAltura(x.izquierda), obtenerAltura(x.derecha)) + 1;

        return x; //Nueva raíz del subárbol rotado
    }

    //Rotación simple a la izquierda
    private Node rotarHaciaIzquierda(Node x) {
        Node y = x.derecha;
        Node T2 = y.izquierda;

        //Nuevamente, para realizar rotación
        y.izquierda = x;
        x.derecha = T2;

        //Actualizar alturas
        x.altura = maximo(obtenerAltura(x.izquierda), obtenerAltura(x.derecha)) + 1;
        y.altura = maximo(obtenerAltura(y.izquierda), obtenerAltura(y.derecha)) + 1;

        return y; //Nueva raíz del subárbol rotado
    }

    //*Método de inserción

    //Este es un método público para insertar un valor en el árbol
    public void insertar(int valor) { //Cambiado de agregarValor a insertar
        System.out.println("Insertando: " + valor);
        raiz = insertarRecursivo(raiz, valor); //Cambiado de agregarValorRecursivo
    }

    //Ahora, este es un método recursivo para insertar un valor y balancear el árbol
    private Node insertarRecursivo(Node nodoActual, int valorNuevo) { //Cambiado de agregarValorRecursivo
        //1. Inserción estándar de un Árbol Binario de Búsqueda (BST)
        if (nodoActual == null) {
            return (new Node(valorNuevo));
        }

        if (valorNuevo < nodoActual.valor) {
            nodoActual.izquierda = insertarRecursivo(nodoActual.izquierda, valorNuevo);
        } else if (valorNuevo > nodoActual.valor) {
            nodoActual.derecha = insertarRecursivo(nodoActual.derecha, valorNuevo);
        } else {
            //Valores duplicados no se insertan
            System.out.println("Valor " + valorNuevo + " ya existe. No se insertará.");
            return nodoActual;
        }

        //2. Se actualiza la altura del ancestro actual
        nodoActual.altura = 1 + maximo(obtenerAltura(nodoActual.izquierda), obtenerAltura(nodoActual.derecha));

        //3. Obetnemos el factor de balance para este ancestro
        int factorBalance = obtenerFactorBalance(nodoActual);

        //4. Si el nodo está desbalanceado, hay 4 casos:

        //-Caso Izquierda-Izquierda (Rotación Simple a Derecha)
        if (factorBalance > 1 && valorNuevo < nodoActual.izquierda.valor) {
            System.out.println("Desbalance: Izquierda-Izquierda. Rotación Simple a Derecha en nodo " + nodoActual.valor);
            return rotarHaciaDerecha(nodoActual);
        }

        //-Caso Derecha-Derecha (Rotación Simple a Izquierda)
        if (factorBalance < -1 && valorNuevo > nodoActual.derecha.valor) {
            System.out.println("Desbalance: Derecha-Derecha. Rotación Simple a Izquierda en nodo " + nodoActual.valor);
            return rotarHaciaIzquierda(nodoActual);
        }

        //-Caso Izquierda-Derecha (Rotación Doble: Izquierda-Derecha)
        if (factorBalance > 1 && valorNuevo > nodoActual.izquierda.valor) {
            System.out.println("Desbalance: Izquierda-Derecha. Rotación Izquierda en " + nodoActual.izquierda.valor + " y luego Derecha en " + nodoActual.valor);
            nodoActual.izquierda = rotarHaciaIzquierda(nodoActual.izquierda);
            return rotarHaciaDerecha(nodoActual);
        }

        //-Caso Derecha-Izquierda (Rotación Doble: Derecha-Izquierda)
        if (factorBalance < -1 && valorNuevo < nodoActual.derecha.valor) {
            System.out.println("Desbalance: Derecha-Izquierda. Rotación Derecha en " + nodoActual.derecha.valor + " y luego Izquierda en " + nodoActual.valor);
            nodoActual.derecha = rotarHaciaDerecha(nodoActual.derecha);
            return rotarHaciaIzquierda(nodoActual);
        }

        //En dado caso de no haber desbalance, retornar el nodo sin cambios
        return nodoActual;
    }

    //*Método de eliminación

    //Método público para eliminar un valor del árbol
    public void eliminar(int valor) { //Cambiado de quitarValor a eliminar
        System.out.println("Intentando eliminar: " + valor);
        raiz = eliminarRecursivo(raiz, valor); //Cambiado de quitarValorRecursivo
    }
    
    //Este método encuentra el nodo con el valor mínimo en un subárbol (el más a la izquierda)
    private Node encontrarMinimo(Node nodo) { //Cambiado de encontrarMinimoValor
        Node actual = nodo;
        while (actual.izquierda != null) {
            actual = actual.izquierda;
        }
        return actual;
    }

    //Método recursivo para eliminar un valor y balancear el árbol
    private Node eliminarRecursivo(Node nodoActual, int valorAEliminar) { //Cambiado de quitarValorRecursivo
        //1. Eliminación estándar de un Árbol Binario de Búsqueda (BST)
        if (nodoActual == null) {
            System.out.println("Valor " + valorAEliminar + " no encontrado para eliminar.");
            return nodoActual; 
        }

        if (valorAEliminar < nodoActual.valor) {
            nodoActual.izquierda = eliminarRecursivo(nodoActual.izquierda, valorAEliminar);
        } else if (valorAEliminar > nodoActual.valor) {
            nodoActual.derecha = eliminarRecursivo(nodoActual.derecha, valorAEliminar);
        } else { //valorAEliminar == nodoActual.valor (nodo encontrado)
            //Este es un nodo con un solo hijo o sin hijos
            if ((nodoActual.izquierda == null) || (nodoActual.derecha == null)) {
                Node temp = (nodoActual.izquierda != null) ? nodoActual.izquierda : nodoActual.derecha;

                if (temp == null) { //Sin hijos
                    nodoActual = null; //Simplemente se elimina
                } else { //Un hijo
                    nodoActual = temp; //El hijo reemplaza al nodo
                }
            } else { //Nodo con dos hijos
                //Obtener el sucesor en inorden (el más pequeño en el subárbol derecho)
                Node sucesor = encontrarMinimo(nodoActual.derecha);
                //Copiar el valor del sucesor al nodo actual
                nodoActual.valor = sucesor.valor;
                //Eliminar el sucesor
                nodoActual.derecha = eliminarRecursivo(nodoActual.derecha, sucesor.valor);
            }
        }

        //Si el árbol quedó vacío después de la eliminación (ej. eliminar la única raíz)
        if (nodoActual == null) {
            return nodoActual;
        }

        //2. Actualizar la altura del nodo actual
        nodoActual.altura = maximo(obtenerAltura(nodoActual.izquierda), obtenerAltura(nodoActual.derecha)) + 1;

        //3. Obtener el factor de balance
        int factorBalance = obtenerFactorBalance(nodoActual);

        //4. Si el nodo está desbalanceado, aplicar rotaciones

        //Caso Izquierda-Izquierda (o Izquierda-Neutro para eliminación)
        if (factorBalance > 1 && obtenerFactorBalance(nodoActual.izquierda) >= 0) {
            System.out.println("Rebalanceo tras eliminación: Rotación Simple a Derecha en nodo " + nodoActual.valor);
            return rotarHaciaDerecha(nodoActual);
        }

        //Caso Izquierda-Derecha
        if (factorBalance > 1 && obtenerFactorBalance(nodoActual.izquierda) < 0) {
            System.out.println("Rebalanceo tras eliminación: Rotación Izquierda-Derecha en nodo " + nodoActual.valor);
            nodoActual.izquierda = rotarHaciaIzquierda(nodoActual.izquierda);
            return rotarHaciaDerecha(nodoActual);
        }

        //Caso Derecha-Derecha (o Derecha-Neutro para eliminación)
        if (factorBalance < -1 && obtenerFactorBalance(nodoActual.derecha) <= 0) {
            System.out.println("Rebalanceo tras eliminación: Rotación Simple a Izquierda en nodo " + nodoActual.valor);
            return rotarHaciaIzquierda(nodoActual);
        }

        //Caso Derecha-Izquierda
        if (factorBalance < -1 && obtenerFactorBalance(nodoActual.derecha) > 0) {
            System.out.println("Rebalanceo tras eliminación: Rotación Derecha-Izquierda en nodo " + nodoActual.valor);
            nodoActual.derecha = rotarHaciaDerecha(nodoActual.derecha);
            return rotarHaciaIzquierda(nodoActual);
        }

        return nodoActual;
    }

    //*Métodos para mostrar el árbol

    //Método público para imprimir el árbol (requerido por el PDF como printTree)
    public void printTree() { 
        if (raiz == null) {
            System.out.println("(Árbol vacío)");
        } else {
            printTreeRecursivo(raiz, 0, "R: "); //Llamada al método recursivo de impresión
        }
        System.out.println("----------------------------------------");
    }

    //Método recursivo para imprimir el árbol con formato jerárquico
    private void printTreeRecursivo(Node nodo, int nivel, String prefijo) {
        if (nodo == null) {
            return;
        }

        printTreeRecursivo(nodo.derecha, nivel + 1, "/ ");

        for (int i = 0; i < nivel; i++) {
            System.out.print("    "); //4 espacios por nivel de indentación
        }
        //System.out.println(prefijo + nodo.valor + " (H:" + nodo.altura + ", FB:" + obtenerFactorBalance(nodo) + ")"); // Con altura y FB
        System.out.println(prefijo + nodo.valor); //Solo valor

        printTreeRecursivo(nodo.izquierda, nivel + 1, "\\ ");
    }
    
    //Método para vaciar el árbol completamente
    public void vaciarArbol() {
        raiz = null;
        System.out.println("El árbol ha sido vaciado.");
    }
}