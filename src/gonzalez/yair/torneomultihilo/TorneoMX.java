package gonzalez.yair.torneomultihilo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TorneoMX {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Equipo pumas = new Equipo("Pumas");
        Equipo cruzAzul = new Equipo("Cruz Azul");
        Equipo america = new Equipo("America");
        Equipo chivas = new Equipo("Chivas");


        System.out.println("Presiona Enter para iniciar Jornada 1");
        sc.nextLine();

        Partido partido1 = new Partido(pumas, cruzAzul);
        Partido partido2 = new Partido(chivas, america);

        Thread hilo1 = new Thread(partido1);
        Thread hilo2 = new Thread(partido2);
        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n--- TABLA GENERAL JORNADA 1 ---");
        america.mostrarEstadisticas();
        chivas.mostrarEstadisticas();
        cruzAzul.mostrarEstadisticas();
        pumas.mostrarEstadisticas();

        System.out.println("Presiona Enter para iniciar Jornada 2");
        sc.nextLine();

        Partido partido3 = new Partido(pumas, america);
        Partido partido4 = new Partido(cruzAzul, chivas);

        Thread hilo3 = new Thread(partido3);
        Thread hilo4 = new Thread(partido4);
        hilo3.start();
        hilo4.start();

        try {
            hilo3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            hilo4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n--- TABLA GENERAL JORNADA 2 ---");
        america.mostrarEstadisticas();
        chivas.mostrarEstadisticas();
        cruzAzul.mostrarEstadisticas();
        pumas.mostrarEstadisticas();

        System.out.println("Presiona Enter para iniciar Jornada 3");
        sc.nextLine();

        Partido partido5 = new Partido(pumas, chivas);
        Partido partido6 = new Partido(cruzAzul, america);

        Thread hilo5 = new Thread(partido5);
        Thread hilo6 = new Thread(partido6);
        hilo5.start();
        hilo6.start();

        try {
            hilo5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            hilo6.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n--- TABLA GENERAL JORNADA 3 ---");
        america.mostrarEstadisticas();
        chivas.mostrarEstadisticas();
        cruzAzul.mostrarEstadisticas();
        pumas.mostrarEstadisticas();

    }
}
