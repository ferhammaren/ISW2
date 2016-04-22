/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 * La clase jugador guarda los datos de un jugador en un objeto
 * @author Fer
 */
public class Jugador {

    private String nombre;
    private String pass;
    private int ganados;
    private int jugados;
    private int index;
    private boolean ai;

    /**
     * Constructor 1
     *
     * @param nombre El nombre de usuario que eligio el jugador
     * @param ganados El número de juegos ganados
     * @param jugados El número de juegos jugados
     * @param ai Determina si el jugador es inteligencia artificial o humano
     * @param index El indice del jugador dentro de la tabla
     */
    public Jugador(String nombre, int ganados, int jugados, boolean ai,int index) {
        this.nombre = nombre;
        this.ganados = ganados;
        this.jugados = jugados;
        this.ai = ai;
        this.index=index;
    }

    /**
     * Constructor en blanco
     */
    public Jugador() {

    }

    /**
     * Regresa el número de juegos ganados
     *
     * @return int ganados
     *
     */
    public int getGanados() {
        return ganados;
    }

    /**
     * Modifica el número de juegos ganados
     *
     * @param ganados El número de juegos ganados
     *
     */
    public void setGanados(int ganados) {
        this.ganados = ganados;
    }

    /**
     * Regresa el número de juegos ganados
     *
     * @return int jugados
     *
     */
    public int getJugados() {
        return jugados;
    }

    /**
     * Modifica el número de juegos ganados
     *
     * @param jugados El número de partidas jugadas
     *
     */
    public void setJugados(int jugados) {
        this.jugados = jugados;
    }

    /**
     * Regresa el nombre del jugador
     * @return  El nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Indica si el jugador es AI
     * @return Verdadero si es AI, falso si es humano
     */
    public boolean isAi() {
        return ai;
    }

    /**
     * Convierte al jugador en AI y viceversa
     * @param ai true si es AI, false si no lo es
     */
    public void setAi(boolean ai) {
        this.ai = ai;
    }

        public String getPass(){
        return pass;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
        
        
        
    @Override

    public String toString() {
        //return "Jugador{" + "nombre=" + nombre + ", ganados=" + ganados + ", jugados=" + jugados + '}' + "\n";
        return "Nombre: " + nombre + " | Jugados: " + jugados + " | Ganados: " + ganados + "\n";
    }

}
