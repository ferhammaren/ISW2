/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.sql.*;

/**
 * Clase para hacer operaciones con base de datos
 * @author Fer
 */
public class DataAccess {

    private Connection conn = null;
    private static final String URL = "jdbc:mysql://localhost:3306/Practica2";
    private static final String USER = "isw";
    private static final String PSWD = "1234";

    /**
     * Regresa la conexión a la base de datos
     *
     * @return Connection
     */
    private Connection getConnection() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PSWD);
        } catch (Exception ex) {
            System.out.println("Error " + ex.toString());
        }
        return conn;
    }

    /**
     * Ejecuta el procedimiento almacenado de insertar jugador.
     *
     * @param line Los parámetros a insertar en el procedimiento.
     * @return boolean
     */
    public boolean nuevoJugador(String line) {
        CallableStatement cs;
        boolean b = false;
        try {
            String input[] = line.split(",");
            //se llama al procedimiento almacenado con los parametros 
            cs = this.getConnection().prepareCall("{call agregarJugador(?,?)}");
            cs.setString(1, input[0]);
            cs.setString(2, input[1]);
            b = cs.execute();
        } catch (Exception ex) {
            System.out.println("err " + ex.toString());
        }
        return b;
    }

    /**
     * Regresa los datos de un jugador ya registrado en la BBDD
     *
     * @param line texto con los parametros
     * @return ResultSet con la informacion del jugador
     */
    public ResultSet getJugador(String line) {
        ResultSet a = null;
        CallableStatement cs;
        try {
            String input[] = line.split(",");
            //se llama al procedimiento almacenado con los parametros 
           // String md5Pass = Encrypt.md5(input[1]);
            cs = this.getConnection().prepareCall("{call getJugador(?,?)}");
            cs.setString(1, input[0]);
            cs.setString(2, input[1]);
            a = cs.executeQuery();
            a.next();
        } catch (Exception ex) {
            System.out.println("err " + ex.toString());

        }
        return a;
    }

    /**
     * Regresa el ranking de jugadores. Se recorre con .next
     *
     * @return Set de resultados con el primer jugador en el ranking.
     */
    public ResultSet getRanking() {
        ResultSet a = null;
        CallableStatement cs;
        try {
            //se llama al procedimiento almacenado con los parametros 
            cs = this.getConnection().prepareCall("{call getJugadores}");
            a = cs.executeQuery();
            a.next();
        } catch (Exception ex) {
            System.out.println("err " + ex.toString());
        }
        return a;
    }

    /**
     * Actualiza la informacion de juegos del jugador
     *
     * @param line String que contiene los parametros
     * @return ResultSet con los datos del jugador actualziados
     */
    public ResultSet updateJugador(String line) {
        ResultSet a = null;
        CallableStatement cs;
        try {
            String input[] = line.split(",");
            //se llama al procedimiento almacenado con los parametros 
            cs = this.getConnection().prepareCall("{call updateJugador(?,?,?,?)}");
            cs.setString(1, input[0]);
            cs.setString(2, input[1]);
            cs.setString(3, input[2]);
            cs.setString(4, input[3]);
            cs.execute();
            a.next();
        } catch (Exception ex) {
            System.out.println("err " + ex.toString());

        }
        return a;
    }

}
