/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import clases.DataAccess;
import clases.Juego;
import clases.Jugador;
import clases.SuperHeroe;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fer
 */
public class JuegoControl {

    private boolean regFlag = false;
    private DataAccess da = new DataAccess();
    private Jugador p1 = new Jugador(), p2 = new Jugador();
    private Juego j1;
    private ManejadorJugadores manejaJugadores;
    private ManejadorJuego manJuego;
    //private ArrayList<Jugador> jugadores;

    public JuegoControl() {
        this.manejaJugadores = new ManejadorJugadores();
        manJuego = new ManejadorJuego();
    }

    public boolean getFlag() {
        return regFlag;
    }

    public void setFlag(boolean flag) {
        this.regFlag = flag;
    }

    public void registerUser(String name, String pwd) {
        manejaJugadores.registerUser(name, pwd);
    }

    public void getRegisteredUser(String name, String pwd) throws SQLException {
        p1 = manejaJugadores.getRegisteredUser(name, pwd);
    }

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

    public int fist(int player){
       return manJuego.fist(player);
    }
    
    public int kick(int player){
        return manJuego.kick(player);
    }
    
    public int special(int player){
        return manJuego.special(player);
    }
////    public Jugador jugar() {
////        return j1.jugar(); //jugar debe regresar un objeto jugador que representa el jugador vencedor
////    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList<Jugador> getRanking() throws SQLException {
        return manejaJugadores.getRanking();
    }

    public void playAgainstAi() throws SQLException{
        p2=manejaJugadores.getRegisteredUser("Hackerman", "Hackerman");
        p2.setAi(true);
    }
    
    public SuperHeroe getHero1(){
        return manJuego.hero1;
    }
    
    public SuperHeroe getHero2(){
        return manJuego.hero2;
    }
    
    
    public Jugador getP1() {
        return p1;
    }

//    public void setP1(Jugador p1) {
//        this.p1 = p1;
//    }

//    public Jugador getP2() {
//        return p2;
//    }
//
//    public void setP2(Jugador p2) {
//        this.p2 = p2;
//    }

    
}
