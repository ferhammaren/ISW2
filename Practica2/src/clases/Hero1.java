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
public class Hero1 extends SuperHeroe {
    private int energy;
    private String name;
    public Hero1(int energy){
        this.energy=energy;
    }
    
     @Override
     public int patada(){
       return 10;
     }
 /**
  * Ejecuta el comando puñetazo
  * @return int El valor de energía que baja el puño
  * 
  */
     @Override
 public int fist(){
       return 5;
 }
 /**
  * Ejecuta el ataque especial
  * @return int el valor de energía que baja el ataque especial
  * 
  */
    @Override
 public int special(){
       return 15;
 }
 /**
  * 
  * @return int La energía del superhéroe
  */
    @Override
 public int getEnergia(){
     return energy;
 }
    @Override
 public void setEnergia(int a){
     energy=a;
 }
}
