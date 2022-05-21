
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

/*-------------------------------------------------*/
/* Importaciones */
/*-------------------------------------------------*/
package javaapplication30;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class MainIT {

      public void primero(){
            Vector<Integer> datos =Main.constructPath(0, 3);
            Vector<Integer> ruta=new  Vector<>();
            ruta.add(0);
            ruta.add(1);
            ruta.add(2);
            ruta.add(3);
            assertEquals(ruta, datos);
      }

      public void segundo(){
            Vector<Integer> datos1 =Main.constructPath(0, 4);
            Vector<Integer> ruta1=new  Vector<>();
            ruta1.add(0);
            ruta1.add(4);
            assertEquals(ruta1, datos1);
      }
   
      public void tercero(){
            Vector<Integer> datos2 =Main.constructPath(3, 1);
            Vector<Integer> ruta2=new  Vector<>();
            ruta2.add(3);
            ruta2.add(2);
            ruta2.add(1);
            assertEquals(ruta2, datos2);
      }
      
}
