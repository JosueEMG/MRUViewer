/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hilo;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.CocheAlcance;
import vista.frmCarroAlcance;

/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public class HiloAlcance extends Thread{
    boolean estado = true;
    private frmCarroAlcance frm; 
    private JLabel carro;
    private JLabel carro1;
    double v;
    double v1;

    public HiloAlcance(frmCarroAlcance frm, JLabel carro, JLabel carro1, JTextField velocidad, JTextField velocidad1) {
        this.frm = frm;
        this.carro = carro;
        this.carro1 = carro1;
        this.v = Double.parseDouble(frm.getTxtVel().getText());
        this.v1 = Double.parseDouble(frm.getTxtVel1().getText());
    }
    
    public static double posicion(double x, double v, double a, double t) {
        return x + v*t + (a*t*t)/2;
    }
    
    public static double velocidad (double v, double a, int t) {
        return (v + a*t)/20;
    }
    
    public void parar(){
        estado = false;
    }
    
    @Override
    public void run(){
        int x = 0;
        int x1 = 0;
        int tiempo = 0;
        int velocidad = 0;
        boolean desicion = true;
        try {
            while (estado) {
                velocidad = frm.velocidad();
                sleep(velocidad); 
                x = frm.getCarro().getLocation().x;
                x1 = frm.getCarro1().getLocation().x;
                tiempo++;
                carro.setLocation(x + ((int)posicion(x, v, Double.parseDouble(frm.getTxtAce().getText()), tiempo)/10000), 310);
                v += velocidad(v, Double.parseDouble(frm.getTxtAce().getText()), tiempo);
                carro1.setLocation(x1 + ((int)posicion(x1, v1, Double.parseDouble(frm.getTxtAce1().getText()), tiempo)/10000), 310);  
                v1 += velocidad(v1, Double.parseDouble(frm.getTxtAce1().getText()), tiempo);
                frm.repaint(); 
                if(desicion) {
                    if(x1 >= 1060) {
                        int valor = JOptionPane.showConfirmDialog(frm, "Uno de los coches se esta llendo fuera de la pantalla. \n¿Está seguro(a) de continuar con la animación?", "Advertencia", JOptionPane.YES_NO_OPTION);
                        if(valor == JOptionPane.YES_OPTION){
                            desicion = false;
                        }
                        else{
                            estado = false;
                        }
                    }
                }
                if(x >= x1-100) {
                    estado = false;
                }
                else if(x > 100000) {
                    estado = false;
                }
                
            }
            frm.botonesFinal();
            JOptionPane.showMessageDialog(null, "Los coches chocaron :(");
            CocheAlcance coche = new CocheAlcance(Double.parseDouble(frm.getTxtPos().getText()),Double.parseDouble(frm.getTxtPos1().getText()), Double.parseDouble(frm.getTxtVel().getText()), Double.parseDouble(frm.getTxtVel1().getText()), Double.parseDouble(frm.getTxtAce().getText()), Double.parseDouble(frm.getTxtAce1().getText()));
            frm.añadir(coche);
            frm.listar();
            } catch (Exception e) {
        }
    }
}
