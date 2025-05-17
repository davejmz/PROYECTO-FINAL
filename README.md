# PROYECTO ÁRBOL AVL EN JAVA

## 👾 DESCRIPCIÓN EL PROYECTO
Hola! Este proyecto implementa un **Árbol AVL** en Java, el cual es un tipo especial de árbol binario de búsqueda que se auto-balancea después de cada inserción o eliminación. Nos permite insertar números y visualizar el árbol balanceado en la consola con su estructura de niveles.

## 💡 PROBLEMAS A RESOLVER, Y ENFOQUE
Los árboles binarios de búsqueda comunes pueden desequilibrarse, y por lo tanto, eso aumenta el tiempo de búsqueda. Un Árbol AVL mantiene su altura mínima y garantiza operaciones eficientes ($O(\log n)$).

## 📂 ESTRUCTURA

|        Ruta       |                Descripción                      |
| ----------------- | ----------------------------------------------- |
| `PROYECTO-FINAL/` | Directorio principal del proyecto               |
| ├── `Main.java`   | Archivo Main, con menú de interacción.          |
| ├── `AVLTree.java`| Implementación completa del árbol AVL.          |
| └── `Node.java`   | Clase que define la estructura del nodo del árbol. |

## ✨ Características Principales de este Proyecto
* Inserción dinámica de números enteros desde la consola.
* Auto-balanceo por medio de rotaciones AVL (Simples y Dobles).
* Visualización jerárquica del árbol en consola tras cada operación.
* Menú interactivo para insertar, eliminar, vaciar y mostrar el árbol.
* Informes en consola sobre desbalances y rotaciones aplicadas.

## Cómo Compilar y Ejecutar

**Requisitos:**
* Java JDK (Java Development Kit) instalado, claro está. 

**Pasos:**
1.  Clonar el repositorio:
    ```bash
    git clone https://github.com/davejmz/PROYECTO-FINAL.git 
    cd PROYECTO-FINAL
    ```
2.  Compilar los archivos Java en la terminal:
    ```bash
    javac Node.java AVLTree.java Main.java
    ```
3.  Ejecutar el programa en la terminal:
    ```bash
    java Main
    ```

## 📊 Ejemplos de Operaciones

## 📊 Ejemplos de Operaciones AVL

**Caso #1:**
Valores: `[10, 20, 30]`

-RESULTADO:
<pre>
      20
     /  \
    10  30
</pre>

**Caso #2:**
Valores: `[30, 20, 40, 10, 25, 35, 50, 5]`

- RESULTADO:
<pre>
          30
         /  \
       20    40
      / \   /  \
     10 25 35  50
    /
   5
</pre>

**Caso #3:**
Valores: `[15, 10, 20, 8, 12, 17, 25, 6]`

- RESULTADO:
<pre>
          15
         /  \
       10    20
      / \   /  \
     8  12 17  25
    /
   6
</pre>

**Caso #4:**
Valores: `[50, 30, 70, 20, 40, 60, 80, 35]`

-RESULTADO:
<pre>
          50
         /  \
       30    70
      / \   /  \
     20 40 60  80
        /
       35
</pre>