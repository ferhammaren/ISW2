/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import clases.Jugador;
import clases.SuperHeroe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * La clase JuegoControl es la encargada de comunicar
 * {@link manejadores.ManejadorJuego} y {@link manejadores.ManejadorJugadores}
 * con la interfaz.
 *
 * @author Fer
 */
public class JuegoControl {

    private boolean regFlag = false;
    private Jugador p1 = new Jugador(), p2 = new Jugador();
    private ManejadorJugadores manejaJugadores;
    private ManejadorJuego manJuego;
    private int counter = 100;
    private Timer timer;
    //private ArrayList<Jugador> jugadores;

    public JuegoControl() {
        this.manejaJugadores = new ManejadorJugadores();
        manJuego = new ManejadorJuego();
    }

    /**
     * Regresa la bandera de si el jugador ya se registró o inició sesión
     *
     * @return true si ya cumplió el requisito
     */
    public boolean getFlag() {
        return regFlag;
    }

    /**
     * Asigna la bandera de si el jugador ya se registró o inició sesión
     *
     * @param flag
     */
    public void setFlag(boolean flag) {
        this.regFlag = flag;
    }

    /**
     * Registra un nuevo jugador
     *
     * @param name Nombre de usuario
     * @param pwd Contraseña
     */
    public void registerUser(String name, String pwd) {
        manejaJugadores.registerUser(name, pwd);
    }

    /**
     * Inicia sesión de un usuario registrado
     *
     * @param name El nombre de usuario
     * @param pwd La contraseña del usuario
     * @throws SQLException
     */
    public void getRegisteredUser(String name, String pwd) throws SQLException {
        p1 = manejaJugadores.getRegisteredUser(name, pwd);
    }

    /**
     * Ejecuta la selección de héroes
     *
     * @param playerNumber El jugador que está seleccionando héroe
     * @param selectedHero El héroe que seleccionó
     * @return
     */
    public int selectHero(int playerNumber, int selectedHero) {
//        j1 = new Juego(p1, p2);
//        j1.selectHero(a);
        boolean isAi;
        if (playerNumber == 1) {
            isAi = p1.isAi();
        } else {
            isAi = p2.isAi();
        }
        return manJuego.seleccionarHeroe(playerNumber, selectedHero, isAi);
    }

    /**
     * Ejecuta un puñetazo de un heroe a otro y aumenta la barra de especial
     *
     * @param player Jugador que manda el puñetazo
     * @return La energía restante del héroe que recibió el ataque
     */
    public int fist(int player) {
        return manJuego.fist(player);
    }

    /**
     * Ejecuta una patada de un héroe a otro y aumenta la barra de especial
     *
     * @param player Jugador que manda la patada
     * @return La energía restante del héroe que recibió el ataque
     */
    public int kick(int player) {
        return manJuego.kick(player);
    }

    /**
     * Valida si el jugador puede ejecutar el ataque especial, si puede hacerlo,
     * lo ejecuta contra el otro héroe y vacía la barra de especial
     *
     * @param player Jugador que usa el especial
     * @return Energía restante del jugador que recibió el ataque
     */
    public int special(int player) {
        return manJuego.special(player);
    }

    /**
     * Actualiza al jugador perdedor y el ganador
     *
     * @param winner El numero del jugador que gano (1 o 2)
     * @param loser El numero del jugador que perdio (1 o 2)
     */
    public void winner(int winner, int loser) {
        if (winner == 1) {
            p1.setGanados(p1.getGanados() + 1);
            p1.setJugados(p1.getJugados() + 1);
            p2.setJugados(p2.getJugados() + 1);
            manejaJugadores.updateJugador(p1.getNombre() + "," + p1.getIndex() + "," + p1.getGanados() + "," + p1.getJugados());
        } else {
            p2.setGanados(p2.getGanados() + 1);
            p2.setJugados(p2.getJugados() + 1);
            p1.setJugados(p1.getJugados() + 1);
            manejaJugadores.updateJugador(p2.getNombre() + "," + p2.getIndex() + "," + p2.getGanados() + "," + p2.getJugados());
        }
    }

    /**
     * Regresa el ranking de jugadores en un Array List
     *
     * @return @throws SQLException
     */
    public ArrayList<Jugador> getRanking() throws SQLException {
        return manejaJugadores.getRanking();
    }

    /**
     *
     * @param label EL label que será actualizado en la GUI
     * @param tiempo El tiempo determinado del juego
     * @return True si el tiempo determinado ha llegado a su fin.
     */
    public boolean timer(JLabel label, int tiempo) {
        counter =  tiempo;
        ActionListener action = (ActionEvent event) -> {
           // System.out.println(timer.isRunning());
            if(counter == 0)
            {
                timer.stop();
                label.setText("0");
            }
            else
            {
                label.setText(""+counter);
                counter--;
            }
        };
        timer = new Timer(1000, action);
        timer.setInitialDelay(0);
        timer.start();
        //System.out.println(timer.isRunning());
        return true;
    }
    
    public boolean getTimer(){
        return timer.isRunning();
    }

    /**
     * Utiliza a Hackerman como AI
     *
     * @throws SQLException
     */
    public void playAgainstAi() throws SQLException {
        p2 = manejaJugadores.getRegisteredUser("Hackerman", "Hackerman");
        p2.setAi(true);
    }

    public SuperHeroe getHero1() {
        return manJuego.hero1;
    }

    public SuperHeroe getHero2() {
        return manJuego.hero2;
    }

    public Jugador getP1() {
        return p1;
    }

    public Jugador getP2() {
        return p2;
    }
}
