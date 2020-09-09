/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hilo;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.CocheEncuentro;
import vista.frmCarroEncuentro;

/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public class HiloEncuentro extends Thread{

    boolean estado = true;
    private frmCarroEncuentro frm; 
    private JLabel carro;
    private JLabel carro1;

    public HiloEncuentro(frmCarroEncuentro frm, JLabel carro, JLabel carro1) {
        this.frm = frm;
        this.carro = carro;
        this.carro1 = carro1;

    }
    
    public static double posicion(double x, double v, double a, double t) {
        return x + v*t + (a*t*t)/2;
    }
    
    public void parar(){
        estado = false;
    }
    
    @Override
    public void run(){
        int x = 0;
        int x1 = 0;
        int tiempo = 0;
        try {
            while (estado) { 
                sleep(10); 
                x = frm.getCarro().getLocation().x;
                x1 = frm.getCarro1().getLocation().x;
                tiempo++;
                carro.setLocation(x + ((int)posicion(x, Double.parseDouble(frm.getTxtVel().getText()), Double.parseDouble(frm.getTxtAce().getText()), tiempo)/1000), carro.getLocation().y);
                carro1.setLocation(x1 - ((int)posicion(x1, Double.parseDouble(frm.getTxtVel().getText()), Double.parseDouble(frm.getTxtAce1().getText()), tiempo)/1000), carro.getLocation().y);  
                frm.repaint(); 
                if(x >= x1-100){
                    estado = false;
                }
            }
            frm.botonesFinal();
            JOptionPane.showMessageDialog(null, "Los coches chocaron :(");
            CocheEncuentro coche = new CocheEncuentro(Double.parseDouble(frm.getTxtPos().getText()),Double.parseDouble(frm.getTxtPos1().getText()), Double.parseDouble(frm.getTxtVel().getText()), Double.parseDouble(frm.getTxtVel1().getText()), Double.parseDouble(frm.getTxtAce().getText()), Double.parseDouble(frm.getTxtAce1().getText()));
            frm.añadir(coche);
            frm.listar();
            } catch (Exception e) {
        }
    }
}
