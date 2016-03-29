/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Fer
 *
 */
public abstract class SuperHeroe {

    private int energia;
    private int specialMeter;
    private String name;

    /**
     * Ejecuta el comando patada
     *
     * @return int El valor de energía que baja la patada
     *
     */
    public abstract int patada();

    /**
     * Ejecuta el comando puñetazo
     *
     * @return int El valor de energía que baja el puño
     *
     */
    public abstract int fist();

    /**
     * Ejecuta el ataque especial
     *
     * @return int el valor de energía que baja el ataque especial
     *
     */
    public abstract int special();

    /**
     *
     * @return int La energía del superhéroe
     */
    public abstract int getEnergia();

    /**
     * Define un valor de la energía
     *
     * @param a El valor que se le va a dar a la energía
     */
    public abstract void setEnergia(int a);
/**
 * 
 * @return El valor de la barra de ataque especial
 */
    public abstract int getSpecialMeter();

    /**
     * Modifica el valor de la barra de ataque especial
     * @param specialMeter El valor nuevo que se asignará
     */
    public abstract void setSpecialMeter(int specialMeter);

    /**
     * Regresa el nombre del superheroe
     * @return El nombre del superheroe
     */
    public abstract String getName();

    /**
     * Modifica el nombre del superheroe
     * @param name El nombre que se le asignará al superheroe
     */
    public abstract void setName(String name);

}
