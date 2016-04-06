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

/**
 *
 * @author Fer
 */
public class ManejadorJugadores {

    private DataAccess da = new DataAccess();
    private Jugador p1 = new Jugador(), p2 = new Jugador();

    public boolean registerUser(String name, String pwd) {
        boolean b;
        String input_Parameters = name + "," + pwd;
        b = da.nuevoJugador(input_Parameters);
        p1.setNombre(name);
        return b;
    }

    public String getRegisteredUser(String name, String pwd) throws SQLException {
        //  String enc_pwd = Encrypt.md5(pwd);
        String input_Parameters = name + "," + pwd;
        return da.getJugador(input_Parameters).getString("nombre_jugador");
    }

    public String[] getRanking() throws SQLException {
        ResultSet rs = da.getRanking();
        String[] str = new String[200];
        int cont = 0;
        do {
            str[cont] = rs.getString("nombre_Jugador") + "\n";
            rs.next();
            cont++;
        } while (!rs.isAfterLast());
        return str;
    }
    
    public void updateJugador(){
        
    }
}
