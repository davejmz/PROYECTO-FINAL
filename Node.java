//Autor: David Cristopher Coronado Jiménez Cabrera
//5/17/2025
//PROYECTO FINAL: Implementación de un Árbol AVL en Java. 
//Esta clase define la estructura de cada nodo en el árbol AVL.
public class Node {
    int valor;         //Valor almacenado en el nodo
    Node izquierda;    //Referencia al hijo izquierdo
    Node derecha;     //Referencia al hijo derecho
    int altura;        //Altura del subárbol que tiene este nodo como raíz

    //Este es el constructor para crear un nuevo nodo del árbol
    public Node(int valorNodo) {
        this.valor = valorNodo;
        this.altura = 1; //La altura inicial de un nuevo nodo es 1 (es una hoja)
        this.izquierda = null;
        this.derecha = null;
    }
}