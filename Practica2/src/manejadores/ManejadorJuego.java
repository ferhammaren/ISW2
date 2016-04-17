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

    SuperHeroe hero1, hero2; //jero1 es el heroe de jugador 1, heroe2 es el heroe de jugador 2

    public ManejadorJuego() {
    }

    /**
     * Ejecuta la seleccion de heroes
     *
     * @param a El numero del jugador seleccionando
     * @param b El numero del heroe que . Si es AI, b es irrelevante.
     * @param isAi Verifica si el jugador es humano o computadora
     */
    public int seleccionarHeroe(int a, int b, boolean isAi) {
        int selected = 0, hero = 0;
        if (a == 1) { //seleccion para jugador 1
            if (!isAi) {
                // <editor-fold defaultstate="collapsed" desc="Si el jugador 1 no es AI se ejecuta esto"> 
                switch (b) {
                    case 1:
                        hero1 = new Hero1(10);
                        selected = 1;
                        break;
                    case 2:
                        hero1 = new Hero2(20);
                        selected = 2;
                        break;
                    case 3:
                        hero1 = new Hero3(30);
                        selected = 3;
                        break;
                    case 4:
                        hero1 = new Hero4(50);
                        selected = 4;
                        break;
                    default:
                        hero1 = new Hero1(10);
                        selected = 1;
                        break;
                }
                // </editor-fold> 
            } else {
                // <editor-fold defaultstate="collapsed" desc="Si el jugador 1 ES es AI se ejecuta esto"> 

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
        } else //seleccion para jugador 2
        // <editor-fold defaultstate="collapsed" desc="Si el jugador 2 no es AI se ejecuta esto"> 
        {
            if (!isAi) {
                switch (b) {
                    case 1:
                        hero2 = new Hero1(10);
                        selected = 1;
                        break;
                    case 2:
                        hero2 = new Hero2(20);
                        selected = 2;
                        break;
                    case 3:
                        hero2 = new Hero3(30);
                        ;
                        selected = 3;
                        break;
                    case 4:
                        hero2 = new Hero4(50);
                        selected = 4;
                        break;
                    default:
                        hero2 = new Hero1(10);
                        selected = 1;
                        break;
                }
            } // </editor-fold> 
            else {
                // <editor-fold defaultstate="collapsed" desc="Si el jugador 2 no ES AI se ejecuta esto"> 
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
        selected = hero;
        return selected;       
    }    

    
    
    public int getSpMeter(){
        int meter=0;
        return meter;
    }
    
    public int getPlayersEnergy(){
        int a=0;
        return a;
    }
    
    public void kick(int player){
        
    }
    public void fist(int player){
        
    }
    public void special(int player){
        
    }
}
