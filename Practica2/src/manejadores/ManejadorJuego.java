/*
 * Hecho por Edgar Alan Cebrero y Luisa Fernanda Meza
 */
package manejadores;

import clases.Heroes.Hero1;
import clases.Heroes.Hero2;
import clases.Heroes.Hero3;
import clases.Heroes.Hero4;
import clases.SuperHeroe;
import java.util.Random;

/**
 *
 * @author Fer
 */
public class ManejadorJuego {

    SuperHeroe hero1, hero2;

    public ManejadorJuego() {
    }

    /**
     * Ejecuta la seleccion de heroes
     *
     * @param a El numero del jugador seleccionando
     * @param b El numero del heroe que seleccionó
     * @param isAi Verifica si el jugador es humano o computadora
     */
    public void seleccionarHeroe(int a, int b, boolean isAi) {
        if (a == 1) { //seleccion para jugador 1
            if (!isAi) {
                // <editor-fold defaultstate="collapsed" desc="Si el jugador 1 no es AI se ejecuta esto"> 
                switch (b) {
                    case 1:
                        hero1 = new Hero1(10);
                        break;
                    case 2:
                        hero1 = new Hero2(20);
                        break;
                    case 3:
                        hero1 = new Hero3(30);
                        break;
                    case 4:
                        hero1 = new Hero4(50);
                        break;
                    default:
                        hero1 = new Hero1(10);
                        break;
                }
                // </editor-fold> 
            } else {
                // <editor-fold defaultstate="collapsed" desc="Si el jugador 1 ES es AI se ejecuta esto"> 
                int hero;
                Random x = new Random();
                hero = x.nextInt(4);
                if (hero < 1) {
                    hero1 = new Hero1(10);
                } else {
                    switch (b) {
                        case 1:
                            hero1 = new Hero1(10);
                            break;
                        case 2:
                            hero1 = new Hero2(20);
                            break;
                        case 3:
                            hero1 = new Hero3(30);
                            break;
                        case 4:
                            hero1 = new Hero4(50);
                            break;
                        default:
                            hero1 = new Hero1(10);
                            break;
                    }
                }
                // </editor-fold> 
            }
        } else  //seleccion para jugador 2
                // <editor-fold defaultstate="collapsed" desc="Si el jugador 2 no es AI se ejecuta esto"> 
         if (!isAi) {
                switch (b) {
                    case 1:
                        hero2 = new Hero1(10);
                        break;
                    case 2:
                        hero2 = new Hero2(20);
                        break;
                    case 3:
                        hero2 = new Hero3(30);
                        break;
                    case 4:
                        hero2 = new Hero4(50);
                        break;
                    default:
                        hero2 = new Hero1(10);
                        break;
                }
            } // </editor-fold> 
            else {
                // <editor-fold defaultstate="collapsed" desc="Si el jugador 2 no ES AI se ejecuta esto"> 
                int hero;
                Random x = new Random();
                hero = x.nextInt(4);
                if (hero < 1) {
                    hero2 = new Hero1(10);
                } else {
                    switch (b) {
                        case 1:
                            hero2 = new Hero1(10);
                            break;
                        case 2:
                            hero2 = new Hero2(20);
                            break;
                        case 3:
                            hero2 = new Hero3(30);
                            break;
                        case 4:
                            hero2 = new Hero4(50);
                            break;
                        default:
                            hero2 = new Hero1(10);
                            break;
                    }
                }
                // </editor-fold> 
            }

    }
    
    
    
    
    
}
