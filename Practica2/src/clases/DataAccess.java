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
import java.sql.*;
public class DataAccess {
 private Connection conn=null;
 private Statement stm=null;
 private static final String URL= "jdbc:mysql://localhost:3306/Practica2";
 private static final String USER= "isw";
 private static final String PSWD= "1234";
 /**
  * Regresa la conexión a la base de datos
  * @return Connection 
  */
 private Connection getConnection(){
     try{
         String driver ="com.mysql.jdbc.Driver";
         Class.forName("com.mysql.jdbc.Driver");
         conn=DriverManager.getConnection(URL,USER,PSWD);
     }
     catch (Exception ex){
         System.out.println("Error "+ex.toString());
     }
     return conn;
 }
 
 /**
  * Ejecuta el procedimiento almacenado de insertar jugador.
  * @param line Los parámetros a insertar en el procedimiento.
  */
    public void nuevoJugador(String line){
        CallableStatement cs;
        try{
            String input[]=line.split(",");
            //se llama al procedimiento almacenado con los parametros 
            cs=this.getConnection().prepareCall("{call agregarJugador(?)}");
            cs.setString(1,input[0]);
            cs.execute();
            
        }catch(Exception ex){
            System.out.println("err "+ex.toString());
        }
//        finally{
//            try{
//                conn.close();
//            }catch(SQLException ex){
//                System.out.println("Error "+ex.toString());
//            }
//        }
    }
    
    public ResultSet getJugador(String line){
        ResultSet a=null;
              CallableStatement cs;
        try{
            String input[]=line.split(",");
            //se llama al procedimiento almacenado con los parametros 
            cs=this.getConnection().prepareCall("{call getJugador(?)}");
            cs.setString(1,input[0]);
            a=cs.executeQuery();
            a.next();        
        }catch(Exception ex){
            System.out.println("err "+ex.toString());
            
        }
return a;
    }
 public ResultSet getRanking(){
        ResultSet a=null;
              CallableStatement cs;
        try{
            //se llama al procedimiento almacenado con los parametros 
            cs=this.getConnection().prepareCall("{call getJugadores}");
            a=cs.executeQuery();
            a.next();        
        }catch(Exception ex){
            System.out.println("err "+ex.toString());
            
        }
return a;
    }    
}


