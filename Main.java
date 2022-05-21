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

    

