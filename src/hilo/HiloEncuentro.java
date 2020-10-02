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
public class HiloEncuentro extends Hilo{

    public HiloEncuentro(frmCarroEncuentro frme, JLabel carro, JLabel carro1) {
        super(frme, carro, carro1);
    }
    
    @Override
    public void run(){
        int x = 0;
        int x1 = 0;
        int tiempo = 0;
        int velocidad = 0;
        try {
            while (isEstado()) {
                velocidad = super.getFrme().velocidad();
                sleep(velocidad); 
                x = super.getFrme().getCarro().getLocation().x;
                x1 = super.getFrme().getCarro1().getLocation().x;
                tiempo++;
                super.getCarro().setLocation(x + (int)(posicion(x, getV(), Double.parseDouble(super.getFrme().getTxtAce().getText()), tiempo)/10000), 310);
                setV(getV() + velocidad(getV(), Double.parseDouble(super.getFrme().getTxtAce().getText()), tiempo));
                super.getCarro1().setLocation(x1 - (int)(posicion(x1, getV1(), Double.parseDouble(super.getFrme().getTxtAce1().getText()), tiempo)/10000), 310);
                setV1(getV1() + velocidad(getV1(), Double.parseDouble(super.getFrme().getTxtAce1().getText()), tiempo));
                super.getFrme().repaint(); 
                if(x >= x1-150){
                    setEstado(false);
                }
            }
            super.getFrme().botonesFinal();
            JOptionPane.showMessageDialog(null, "Los coches chocaron :(");
            CocheEncuentro coche = new CocheEncuentro(Double.parseDouble(super.getFrme().getTxtPos().getText()),Double.parseDouble(super.getFrme().getTxtPos1().getText()), Double.parseDouble(super.getFrme().getTxtVel().getText()), Double.parseDouble(super.getFrme().getTxtVel1().getText()), Double.parseDouble(super.getFrme().getTxtAce().getText()), Double.parseDouble(super.getFrme().getTxtAce1().getText()));
            super.getFrme().añadir(coche);
            super.getFrme().listar();
            } catch (Exception e) {
        }
    }
}
