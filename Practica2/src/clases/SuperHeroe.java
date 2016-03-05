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
public interface SuperHeroe {
 
    /**
     * Ejecuta el comando patada
     * @return int El valor de energía que baja la patada
     * 
     */
 public int patada();
 /**
  * Ejecuta el comando puñetazo
  * @return int El valor de energía que baja el puño
  * 
  */
 public int fist();
 /**
  * Ejecuta el ataque especial
  * @return int el valor de energía que baja el ataque especial
  * 
  */
 public int special();
 /**
  * 
  * @return int La energía del superhéroe
  */
 public int getEnergia();
 public void setEnergia(int a);
 
}
