
package Vista;

import javax.swing.JOptionPane;

public class InOut {
    public int PedirEnteros (String m){
        int a=Integer.parseInt(JOptionPane.showInputDialog(m));
        return a;
    }
    public String PedirString (String m){
        String a=JOptionPane.showInputDialog(m);
        return a;
    }
    public void MostrarDatos (String m){
        JOptionPane.showMessageDialog(null,m);
    }
}
