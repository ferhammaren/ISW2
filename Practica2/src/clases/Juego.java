/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Fer
 */
public class Juego {

    private SuperHeroe p1Hero;
    private SuperHeroe p2Hero;
    private Jugador p1;
    private Jugador p2;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private String line = "";

    public Juego(Jugador p1, Jugador p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    // <editor-fold defaultstate="collapsed" desc="Jugar"> 

    // </editor-fold>
    public void selectHero() {
        BufferedReader in = null;
        PrintWriter out = null;
        String line = "";
        Hero1 h1, h2, h3, h4;
        h1 = new Hero1(20);
        h2 = new Hero1(30);
        h3 = new Hero1(40);
        h4 = new Hero1(50);
        System.out.println("\n Selecciona un heroe:\n[1] [2]\n[3] [4]\n");
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out, true);
        try {
            line = in.readLine();
        } catch (IOException ex) {
            System.out.println("READ FAIL");
            System.exit(-1);
        }
        switch (line) {
            case "1":
                p1Hero = h1;
                break;
            case "2":
                p1Hero = h2;
                break;
            case "3":
                p1Hero = h3;
                break;
            case "4":
                p1Hero = h4;
                break;
            default:
                break;
        }
        if (p2.isAi()) {
            int hero;
            Random x = new Random();
            hero = x.nextInt(4);
            if (hero < 1) {
                p2Hero = h1;
            } else if (hero == 2) {
                p2Hero = h2;
            } else if (hero == 3) {
                p2Hero = h3;
            } else {
                p2Hero = h4;
            }
        }
    }

    public void jugar() {
        int fightTime = 100;
        int p1Meter = 0;
        int p2Meter = 0;
        System.out.println("COMIENZA LA PELEA: TIEMPO 100S");
        do {
            System.out.println("Turno de " + p1.getNombre() + "\n");
            if (p1Meter < 5) {
                System.out.println("[1]Patada [2]Puñetazo\n");
            } else {
                System.out.println("[1]Patada [2]Puñetazo [3]Especial\n");
            }
            //leer comandos
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out, true);
            try {
                line = in.readLine();
            } catch (IOException ex) {
                System.out.println("READ FAIL");
                System.exit(-1);
            }

            switch (line) { //seleccion del comando
                case "1":
                    p2Hero.setEnergia(p2Hero.getEnergia() - p1Hero.patada());
                    p1Meter++;
                    break;
                case "2":
                    p2Hero.setEnergia(p2Hero.getEnergia() - p1Hero.fist());
                    p1Meter++;
                    break;
                case "3":
                    if (p1Meter < 5) { //restriccion para usar el especial
                        System.out.println("No tienes energía!");
                    } else {
                        p2Hero.setEnergia(p2Hero.getEnergia() - p1Hero.special());
                    }
                    break;
                default:
                    break;
            }
        } while (p1Hero.getEnergia() != 0 || p2Hero.getEnergia() != 0 || fightTime != 0);
    }

}
