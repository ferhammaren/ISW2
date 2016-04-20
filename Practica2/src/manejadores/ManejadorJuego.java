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
 * Esta clase se utiliza para manejar el flujo del juego.
 * Utiliza la interfaz {@link clases.SuperHeroe} porque no sabemos que héroes son los que participarán en el juego.
 * Toda la interacción es sólo entre los héroes, y para saber qué jugador fue el vencedor, se regresa el héroe1 o héroe2,
 * que corresponden a jugador 1 y jugador 2 respectivamente.
 * @author Fer
 */
public class ManejadorJuego {

    SuperHeroe hero1, hero2; //jero1 es el heroe de jugador 1, heroe2 es el heroe de jugador 2
    Random x = new Random();

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
                        hero1 = new Hero1(250);
                        selected = 1;
                        break;
                    case 2:
                        hero1 = new Hero2(150);
                        selected = 2;
                        break;
                    case 3:
                        hero1 = new Hero3(100);
                        selected = 3;
                        break;
                    case 4:
                        hero1 = new Hero4(100);
                        selected = 4;
                        break;
                    default:
                        hero1 = new Hero1(250);
                        selected = 1;
                        break;
                }
                // </editor-fold> 
            } else {
                // <editor-fold defaultstate="collapsed" desc="Si el jugador 1 ES es AI se ejecuta esto"> 

                Random x = new Random();
                hero = x.nextInt(4);
                if (hero < 1) {
                    hero1 = new Hero1(250);
                } else {
                    switch (b) {
                        case 1:
                            hero1 = new Hero1(250);
                            break;
                        case 2:
                            hero1 = new Hero2(150);
                            break;
                        case 3:
                            hero1 = new Hero3(100);
                            break;
                        case 4:
                            hero1 = new Hero4(100);
                            break;
                        default:
                            hero1 = new Hero1(250);
                            break;
                    }
                }
                // </editor-fold> 
            }
        } else //seleccion para jugador 2
        // <editor-fold defaultstate="collapsed" desc="Si el jugador 2 no es AI se ejecuta esto"> 
         if (!isAi) {
                switch (b) {
                    case 1:
                        hero2 = new Hero1(250);
                        selected = 1;
                        break;
                    case 2:
                        hero2 = new Hero2(150);
                        selected = 2;
                        break;
                    case 3:
                        hero2 = new Hero3(100);
                        ;
                        selected = 3;
                        break;
                    case 4:
                        hero2 = new Hero3(100);
                        selected = 4;
                        break;
                    default:
                        hero2 = new Hero1(250);
                        selected = 1;
                        break;
                }
            } // </editor-fold> 
            else {
                // <editor-fold defaultstate="collapsed" desc="Si el jugador 2 no ES AI se ejecuta esto"> 
                Random x = new Random();
                hero = x.nextInt(4);
                if (hero < 1) {
                    hero2 = new Hero1(250);
                } else {
                    switch (b) {
                        case 1:
                            hero2 = new Hero1(250);
                            break;
                        case 2:
                            hero2 = new Hero2(150);
                            break;
                        case 3:
                            hero2 = new Hero3(100);
                            break;
                        case 4:
                            hero2 = new Hero4(100);
                            break;
                        default:
                            hero2 = new Hero1(250);
                            break;
                    }
                }
                // </editor-fold> 
            }
        selected = hero;
        return selected;
    }
    
    /**
     * Devuelve el valor que lleva acumulado el héroe en ataque especial
     * @param hero El héroe del que se queire conocer el valor del especial
     * @return 
     */
    public int getSpMeter(int hero) {
        if (hero == 1) {
            return hero1.getSpecialMeter();
        } else {
            return hero2.getSpecialMeter();
        }
    }

    /**
     * Regresa el valor de la energía de un héroe
     * @param hero el héroe del que se quiere conocer la energía
     * @return 
     */
    public int getPlayersEnergy(int hero) {
        if (hero == 1) {
            return hero1.getEnergia();
        } else {
            return hero2.getEnergia();
        }
    }

    /**
     * Ejecuta una patada de un héroe a otro y aumenta la barra de especial
     * @param player Jugador que manda la patada
     * @return La energía restante del héroe que recibió el ataque
     */
    public int kick(int player) {
        if (player == 1) {
            hero2.setEnergia(hero2.getEnergia() - hero1.patada());
            hero1.setSpecialMeter(hero1.getSpecialMeter()+x.nextInt(hero1.patada()));
            return hero2.getEnergia();
        } else {
            hero1.setEnergia(hero1.getEnergia() - hero2.patada());
            hero2.setSpecialMeter(hero2.getSpecialMeter()+x.nextInt(hero2.patada()));
            return hero1.getEnergia();
        }
    }

    /**
     * Ejecuta un puñetazo de un heroe a otro y aumenta la barra de especial
     * @param player Jugador que manda el puñetazo
     * @return La energía restante del héroe que recibió el ataque
     */
    public int fist(int player) {
        if (player == 1) {
            hero2.setEnergia(hero2.getEnergia() - hero1.fist());
            hero1.setSpecialMeter(hero1.getSpecialMeter()+x.nextInt(hero1.fist()));
            return hero2.getEnergia();
        } else {
            hero1.setEnergia(hero1.getEnergia() - hero2.fist());
            hero2.setSpecialMeter(hero2.getSpecialMeter()+x.nextInt(hero2.fist()));
            return hero1.getEnergia();
        }
    }

    /**
     * Valida si el jugador puede ejecutar el ataque especial, si puede hacerlo, lo ejecuta contra
     * el otro héroe y vacía la barra de especial
     * @param player Jugador que usa el especial
     * @return Energía restante del jugador que recibió el ataque
     */
    public int special(int player) {
        if (player == 1) {
            if (hero1.getSpecialMeter() >= hero1.special()/2) {
                hero2.setEnergia(hero2.getEnergia() - hero1.special());
                hero1.setSpecialMeter(0);
                return hero2.getEnergia();
            } else {
                return hero2.getEnergia();
            }
        } else if (hero2.getSpecialMeter() >= hero2.special()/2) {
            hero1.setEnergia(hero1.getEnergia() - hero2.special());
            hero2.setSpecialMeter(0);
            return hero1.getEnergia();
        } else {
            return hero1.getEnergia();
        }
    }
}
