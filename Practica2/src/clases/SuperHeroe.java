/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Fer
 */
public abstract class SuperHeroe {
 private int energia;
    /**
     * Ejecuta el comando patada
     * @return int El valor de energía que baja la patada
     * 
     */
 public abstract int patada();
 /**
  * Ejecuta el comando puñetazo
  * @return int El valor de energía que baja el puño
  * 
  */
 public abstract int fist();
 /**
  * Ejecuta el ataque especial
  * @return int el valor de energía que baja el ataque especial
  * 
  */
 public abstract int special();
 /**
  * 
  * @return int La energía del superhéroe
  */
 public abstract int getEnergia();
 public abstract void setEnergia(int a);
 
}
