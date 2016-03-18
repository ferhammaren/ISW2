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
public class Jugador {
    private String nombre;
    private String pass;
    private int ganados;
    private int jugados;
    private boolean ai;
/**
 * Constructor 1
 * @param nombre El nombre de usuario que eligio el jugador
 * @param ganados El número de juegos ganados
 * @param jugados El número de juegos jugados
 * 
 */
    public Jugador(String nombre,String pass, int ganados, int jugados,boolean ai) {
        this.nombre = nombre;
        this.pass=pass;
        this.ganados = ganados;
        this.jugados = jugados;
        this.ai=ai;
    }
    /**
     * Constructor en blanco
     */
    public Jugador(){
        
    }
/**
 * Regresa el número de juegos ganados
 * @return int ganados
 * 
 */
    public int getGanados() {
        return ganados;
    }

    /**
     * Modifica el número de juegos ganados
     * @param ganados El número de juegos ganados
     * 
     */
    public void setGanados(int ganados) {
        this.ganados = ganados;
    }
/**
 * Regresa el número de juegos ganados
 * @return  int jugados
 * 
 */
    public int getJugados() {
        return jugados;
    }
/**
 * Modifica el número de juegos ganados
 * @param jugados El número de partidas jugadas
 * 
 */
    public void setJugados(int jugados) {
        this.jugados = jugados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAi() {
        return ai;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", ganados=" + ganados + ", jugados=" + jugados + '}';
    }
    
    
    
    
}
