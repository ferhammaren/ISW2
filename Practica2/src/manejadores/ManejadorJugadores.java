/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import clases.DataAccess;
import clases.Jugador;
/**
 *
 * @author Fer
 */
public class ManejadorJugadores {
    private DataAccess da = new DataAccess();
    private Jugador p1 = new Jugador(), p2 = new Jugador();
    
    public void registerUser(String name, String pwd) {
        String input_Parameters = name + "," + pwd;
        da.nuevoJugador(input_Parameters);
        p1.setNombre(name);
    }
    
    
}
