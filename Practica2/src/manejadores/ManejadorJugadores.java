/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import clases.DataAccess;
import clases.Jugador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fer
 */
public class ManejadorJugadores {

    private DataAccess da = new DataAccess();
    private Jugador p1 = new Jugador(), p2 = new Jugador();
    private ArrayList<Jugador> jugadores;

    
    /**
     * Registra un jugador en la base de datos
     * @param name El nombre del jugador
     * @param pwd  La contraseña del jugador
     * @return Regresa si se pudo registrar el usuario
     */
    public boolean registerUser(String name, String pwd) {
        boolean b;
        String input_Parameters = name + "," + pwd;
        b = da.nuevoJugador(input_Parameters);
        p1.setNombre(name);
        return b;
    }

    public Jugador getRegisteredUser(String name, String pwd) throws SQLException {
        //  String enc_pwd = Encrypt.md5(pwd);
        ResultSet datosJugador;
        String input_Parameters = name + "," + pwd;
        datosJugador = da.getJugador(input_Parameters);
        p1.setNombre(datosJugador.getString("nombre_Jugador"));
        p1.setGanados(Integer.parseInt(datosJugador.getString("ganados")));
        p1.setJugados(Integer.parseInt(datosJugador.getString("jugados")));
        return p1;
// return da.getJugador(input_Parameters).getString("nombre_Jugador");
    }

    public ArrayList<Jugador> getRanking() throws SQLException {
        jugadores = new ArrayList();
        int cont = 0;
        ResultSet rs = da.getRanking();
        do {
            jugadores.add(new Jugador(rs.getString("nombre_jugador"), rs.getString("pwd_jugador"), Integer.parseInt(rs.getString("ganados")), Integer.parseInt(rs.getString("jugados")), false));
            rs.next();
            cont++;
        } while (!rs.isAfterLast() && cont < 5);
        return jugadores;
    }

    public void updateJugador() {

    }
}
