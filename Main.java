/*
 * Universidad del Valle de Guatemala
 * Ingeneria en Ciencias de la Computacion y TI
 * Departamento de Computacion
 * Hoja de Trabajo 10  Grafos
 * 
 * Integrantes
 * Angel Gabriel Perez Figueroa   | 21298
 * Bryan Carlos España Machorro   | 21550
 * Javier Alejandro Prado Ramirez | 21486
 * Gabriel Estuardo Garcia Donis  | 21352
 */

import java.util.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int V = 5;
        int[][] grafo = { { 0, 30, Informacion, Informacion, 15 }, { 30, 0, 25, Informacion, 40 }, { Informacion, 25, 0, 15, 70 }, { Informacion, Informacion, 15, 0, 90 }, { 15, 40, 70, 90, 0 } };
 
        inicio(V, grafo);

        floydWarshall(V);
        Vector<Integer> path;

        try (Scanner scan = new Scanner(System.in)) {
            int opcion = 0;
            Vista Vista = new Vista();

            while (opcion != 4) {

                System.out.println("\nBienvenido, A donde quieres viajar?\n");
                System.out.println("(1). Ir a una nueva ciudad (Ingrese origen y destino)");
                System.out.println("(2). Mostrar el centro del grafo");
                System.out.println("(3). Modificar mapa (grafo)");
                System.out.println("(4). Salir\n");

                opcion = scan.nextInt();
                //Origen y destino
                if (opcion == 1) { 
                    
                    int Origen;
                    int Destino;

                    System.out.println("\nIngrese ciudad de Salida: ");
                    Vista.Ciudades();

                    Origen = scan.nextInt();

                    System.out.println("\nIngrese ciudad de destino: ");
                    Vista.Ciudades();

                    Destino = scan.nextInt();

                    System.out.print("El camino mas corto desde el origen el lugar de destino es: ");
                    path = constructPath(Origen, Destino);
                    printPath(path);

                } else if (opcion == 2) { //Centro de grafo
                } else if (opcion == 3) { //Modificar grafo
                } else if (opcion == 4) { //Salir
                    
                }
            }
        }
    }
    
    static final int Valor = 100;
    static int Informacion = (int) 1e7;

    static int[][] dis = new int[Valor][Valor];
    static int[][] Next = new int[Valor][Valor];

    
    /*---------------------------- Funcion de inicio y arrays----------------------------*/
    static void inicio(int V, int[][] grafo) {
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dis[i][j] = grafo[i][j];

                // --------- Sin borde entre nodo [i] & [j] --------------
                if (grafo[i][j] == Informacion)
                    Next[i][j] = -1;
                else
                    Next[i][j] = j;
            }
        }
    }

    /*----------------- Encontrar el camino mas corto entre [U] & [V] --------------------*/
    static Vector<Integer> constructPath(int u, int v) {
        
        /* Si no se encuentra ningun relacion entre [U] & [V], se retorna un array vacio */
        if (Next[u][v] == -1)
            return null;
            
            // --------- Guardado del path en un vector ---------
            Vector<Integer> path = new Vector<Integer>(); 
            path.add(u);

            while (u != v) {
                u = Next[u][v];
                path.add(u);
            }
            return path;
    }

    static void floydWarshall(int V) {
        
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {

                    // --------- No puede correr a traves de un nodo que aun no existe ---------
                    if (dis[i][k] == Informacion ||
                            dis[k][j] == Informacion)
                        continue;

                    if (dis[i][j] > dis[i][k] +
                            dis[k][j]) {
                        dis[i][j] = dis[i][k] +
                                dis[k][j];
                        Next[i][j] = Next[i][k];
                    }
                }
            }
        }
    }

    /*------------- funcion para imprimir la ruta mas corta --------------*/
    static void printPath(Vector<Integer> path) {
        int n = path.size();
        for (int i = 0; i < n - 1; i++)
            System.out.print(path.get(i) + " a ");
            System.out.print(path.get(n - 1) + "\n");
    }

}
