/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import clases.DataAccess;
import clases.Juego;
import clases.Jugador;
import java.sql.ResultSet;

/**
 *
 * @author Fer
 */
public class JuegoControl {

    private boolean regFlag = false;
    private DataAccess da = new DataAccess();
    private Jugador p1 = new Jugador(), p2 = new Jugador();
    private Juego j1;
    private ResultSet a;

    public JuegoControl() {

    }

    public boolean getFlag() {
        return regFlag;
    }

    public void setFlag(boolean flag) {
        this.regFlag = flag;
    }

    public void registerUser(String name, String pwd) {
        String input_Parameters = name + "," + pwd;
        da.nuevoJugador(input_Parameters);
        p1.setNombre(name);
    }

    public void getRegisteredUser(String name, String pwd) {
        //  String enc_pwd = Encrypt.md5(pwd);
        String input_Parameters = name + "," + pwd;
        da.getJugador(input_Parameters);
    }

    public void selectHero(int a) {
        j1 = new Juego(p1, p2);
        j1.selectHero(a);
    }

    public void jugar() {
        j1.jugar(); //jugar debe regresar un objeto jugador que representa el jugador vencedor
    }

    public void getRankings() {
    a=da.getRanking();
    }
}
