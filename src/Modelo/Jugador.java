
package Modelo;

public class Jugador {
    private String Nombre;
    private int vidas;
    private int tamaño;
    

   
    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public Jugador(){//constructor
    }
    public Jugador (String Nombre){
        this.Nombre=Nombre;
        this.vidas=3;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
}
