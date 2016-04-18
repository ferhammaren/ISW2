/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import clases.DataAccess;
import clases.DataAccess;
import clases.Juego;
import clases.Juego;
import clases.Jugador;
import clases.Jugador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.ResultSet;

/**
 *
 * @author Fer
 */
public class sandbox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String line = "";
        boolean regFlag = false;
        BufferedReader in = null;
        PrintWriter out = null;
        DataAccess da = new DataAccess();
        Jugador p1=null;
        Jugador p2=new Jugador("Hackerman","",10,10,true);
        do {
            System.out.println("*/*/*/*/*/*/*/*SUPER BATTLE HEROES GOLD 6TH ANNIVERSARY EDITION WITH DLC*\\*\\*\\*\\*\\*\\*\\*");
            if (regFlag != false) {
                System.out.println("Bienvenido "+p1.getNombre());
            }
            System.out.println("[1]Nuevo Usuario\n[2]Usuario Registrado\n[3]Jugar\n[4]Ranking\n[5]Salir\n Selecciona una opción: ");
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out, true);
            try {
                line = in.readLine();
            } catch (IOException ex) {
                System.out.println("READ FAIL");
                System.exit(-1);
            }
            switch (line) {
                case "1":
                     // <editor-fold defaultstate="collapsed" desc="Registrar Usuario"> 
                    System.out.println("Ingresa tu nombre de usuario: ");
                    try {
                        line = in.readLine();
                        System.out.println("Ingresa tu contraseña: ");
                        line=line+","+in.readLine();
                        da.nuevoJugador(line);
                        System.out.println("\nUSUARIO REGISTRADO");
                    } catch (Exception e) {
                        System.out.println("ERROR HUEHUEHUEHUE " + e.toString());
                    }
                    break;
                    // </editor-fold> 
                case "2":
                    // <editor-fold defaultstate="collapsed" desc="Usuario Registrado"> 
                    ResultSet a;
                    System.out.println("Ingresa tu nombre de usuario: ");
                    try {
                        line = in.readLine();     
                        System.out.println("Ingresa tu contraseña: ");
                        String b=in.readLine();
                        line=line+","+b;
                        a = da.getJugador(line);
                        if(a!=null){
                        p1 = new Jugador(a.getString("nombre_Jugador"),a.getString("pwd_Jugador"), a.getInt("GANADOS"), a.getInt("JUGADOS"),false);
                        regFlag=true;
                        }else{
                            System.out.println("ERROR: USUARIO NO ENCONTRADO");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR HUEHUEHUEHUE " + e.toString());
                    }
                    // </editor-fold> 
                    break;
                case "3":
                    // <editor-fold defaultstate="collapsed" desc="Jugar"> 
                    Juego j=new Juego(p1,p2);
                //  j.selectHero();
                  j.jugar();
                    // </editor-fold> 
                    break;
                case "4":
                      // <editor-fold defaultstate="collapsed" desc="Ranking">
                     ResultSet b;
                    try {
                        b = da.getRanking();
                        if(b!=null){                               
                            System.out.println("-----|    Nombre    | Jugados | Ganados | Porcentaje de Ganados |-----\n");
                            do{
                            System.out.println("-----| "+b.getString("nombre_Jugador")+    "|           "+b.getInt("JUGADOS")+"      |       "+b.getInt("GANADOS")+"\n");
                            b.next();
                            }while(!b.isAfterLast());
                        }else{
                            System.out.println("ERROR: NO HAY USUARIOS REGISTRADOS");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR HUEHUEHUEHUE " + e.toString());
                    }
                    // </editor-fold> 
                    break;
                case "5":
                      // <editor-fold defaultstate="collapsed" desc="Salir"> 
                    // </editor-fold> 
                    break;
                default:
                    break;
            }
        } while (!line.equals("5"));
//            in=new BufferedReader(new InputStreamReader(System.in));
//            out= new PrintWriter(System.out,true); 
//        try{
//              line=in.readLine();
//              ResultSet a;
//              a=da.getJugador(line);
//              
//              try{
//                 p1=new Jugador(a.getString("nombre_Jugador"),a.getInt("GANADOS"),a.getInt("JUGADOS"));
//                  System.out.println(p1.toString());
//             // System.out.println("Nombre: "+a.getString("nombre_Jugador")+" Jugados: "+a.getString("JUGADOS")+" Ganados: "+a.getString("GANADOS"));
//          }catch(Exception e){
//                  System.out.println("ERROR HUEHUEHUEHUE "+e.toString());
//          }
//          }
//              catch(IOException ex){
//              System.out.println("READ FAIL");
//                      System.exit(-1);
//          }
    }

}
