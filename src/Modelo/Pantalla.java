/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.InOut;
import java.util.Random;
import javax.swing.JOptionPane;

public class Pantalla {

    String[][] matp = new String[10][15];
    String[][] mats = new String[10][15];
    int cant = 0;
   Jugador ju=new Jugador();
    int derrivados=0;
    int vidas=3;
    int direccion=0;
    InOut o = new InOut();

    public void iniciar() {
        matriz(matp);
        matriz(mats);
        Aviones();
        Bombas();
        JOptionPane.showMessageDialog(null, "   0   1    2   3   4    5    6   7   8   9  10  11 12 13 14"+"\n"+Leerm(mats));
       int bomba=cant*3;
        while(vidas!=0&&derrivados<cant){
            posicion(o.PedirString("Cantidad de aviones= "+cant+"\n"+"Cantidad de bombas="+bomba+"\n"+
                    "Aviones derrivados= "+derrivados+"\n"+
                    "Vidas= "+vidas+"\n"+
                    "Digite el numero de la fila y la columna separados por una coma (Fila,Columna)"+"\n"+"Recuerde que el rango de la fila es de [0-9] y de la columna es de [0-14]"+"\n"+"   0   1    2   3   4    5    6   7   8   9  10  11 12 13 14"+"\n"+
                    Leerm(matp))); 
                  
        }
         
        if(vidas==0){
            JOptionPane.showMessageDialog(null, "Perdiste");
        }else{
            JOptionPane.showMessageDialog(null, "Genial! Ganaste");
        }
       
    }
    
    public void posicion(String datos){
        String[] v=datos.split(",");
        if(mats[Integer.parseInt(v[0])][Integer.parseInt(v[1])]=="✈"){
            matp[Integer.parseInt(v[0])][Integer.parseInt(v[1])]="X";
            mats[Integer.parseInt(v[0])][Integer.parseInt(v[1])]="X";
            if (direccion !=0) {
                if (mats[Integer.parseInt(v[0])][Integer.parseInt(v[1])+1] != "✈"
                    && mats[Integer.parseInt(v[0])][Integer.parseInt(v[1])-1] != "✈") {
                    derrivados++;
                }
            } else {
                if (mats[Integer.parseInt(v[0])+1][Integer.parseInt(v[1])] != "✈"
                    && mats[Integer.parseInt(v[0])-1][Integer.parseInt(v[1])] != "✈") {
                    derrivados++;
                }
            }
            
            
        }
        if(mats[Integer.parseInt(v[0])][Integer.parseInt(v[1])]=="O"){
            JOptionPane.showMessageDialog(null, "Mala suerte :(, pierdes una vida");
            vidas--;
            
            matp[Integer.parseInt(v[0])][Integer.parseInt(v[1])]="O";
        }
        if(mats[Integer.parseInt(v[0])][Integer.parseInt(v[1])]=="O"){
            matp[Integer.parseInt(v[0])][Integer.parseInt(v[1])]="O";
        }
    }

    public String Bombas() {
        Random al = new Random(System.currentTimeMillis());
        boolean x = true;
        int f = 0;
        int c = 0;
        for (int i = 0; i < cant*3; i++) {
            while (x == true) {
                f = al.nextInt(8);
                c = al.nextInt(13);
                if (mats[f][c] != "✈") {
                    x=false;
                    
                }
            }
            
            mats[f][c]="O";
            x=true;
        }
        return Leerm(mats);
    }

    public void Aviones() {
        Random al = new Random(System.currentTimeMillis());
        boolean x = true;
        int f = 0;
        int c = 0;
        int tam=0;
        cant = al.nextInt(5) + 3;
        direccion = al.nextInt(2);
        tam=o.PedirEnteros("digite el tamaño del avion");
           ju.setTamaño(tam);
           while(tam<2||tam>6){
           o.MostrarDatos("Error, el tamaño debe estar entre 2 y 6 aviones");
           tam=o.PedirEnteros("digite el tamaño del avion");}
       
        for (int i = 0; i < cant; i++) {
           
            while (x == true) {
                f = al.nextInt(7)+1;
                c = al.nextInt(12)+1;
                x = verificar(f, c);
            }
            if (direccion == 1) {
                for (int j = c; j < (c + tam); j++) {
                    mats[f][j] = "✈";
                }
            } else {
                for (int j = f; j < (f + tam); j++) {
                    mats[j][c] = "✈";
                }
            }
            x = true;
        }

    }

    public boolean verificar(int f, int c) {
        boolean x = false;
        if (mats[f][c + 2] == "✈") {
            x = true;
        }
        if (mats[f + 2][c] == "✈") {
            x = true;
        }
        return x;
    }

    public String matriz(String[][] mat) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                mat[i][j] = "•";
            }
        }
        return Leerm(mat);
    }
    
    public String leerv(String v[]){
        String m="";
        for (int i = 0; i < v.length; i++) {
            m+=v[i];
        }
        return m;
    }

    public String Leerm(String m[][]) {
        String t = "";
      
        for (int i = 0; i < 10; i++) {
            t += i + " ";
            for (int j = 0; j < 15; j++) {
                t += m[i][j] + "   ";
            }
            t += "\n";
        }

        return t;
    }
}
