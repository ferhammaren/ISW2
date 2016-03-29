/*
 * Hecho por Edgar Alan Cebrero y Luisa Fernanda Meza
 * Each line should be prefixed with  * 
 */
package clases.Heroes;

import clases.SuperHeroe;

/**
 *
 * @author Fer
 */
public class Hero3 extends SuperHeroe{
    private int energy;
    private String name;
    private int specialMeter;

    public Hero3(int energia) {
        this.energy = energia;
    }

    @Override
    public int patada() {
        return 10;
    }

    /**
     * Ejecuta el comando puñetazo
     *
     * @return int El valor de energía que baja el puño
     *
     */
    @Override
    public int fist() {
        return 5;
    }

    /**
     * Ejecuta el ataque especial
     *
     * @return int el valor de energía que baja el ataque especial
     *
     */
    @Override
    public int special() {
        return 15;
    }

    /**
     *
     * @return int La energía del superhéroe
     */
    @Override
    public int getEnergia() {
        return energy;
    }

    @Override
    public void setEnergia(int a) {
        energy = a;
    }

    @Override
    public int getSpecialMeter() {
        return specialMeter;
    }

    @Override
    public void setSpecialMeter(int specialMeter) {
        this.specialMeter = specialMeter;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
 
