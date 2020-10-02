/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hilo;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.CocheAlcance;
import vista.frmCarroAlcance;

/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public class HiloAlcance extends Hilo{

    public HiloAlcance(frmCarroAlcance frma, JLabel carro, JLabel carro1) {
        super(frma, carro, carro1);
    }
    
    @Override
    public void run(){
        int x = 0;
        int x1 = 0;
        int tiempo = 0;
        int velocidad = 0;
        boolean desicion = true;
        try {
            while (isEstado()) {
                velocidad = super.getFrma().velocidad();
                sleep(velocidad); 
                x = super.getFrma().getCarro().getLocation().x;
                x1 = super.getFrma().getCarro1().getLocation().x;
                tiempo++;
                super.getCarro().setLocation(x + ((int)posicion(x, getV(), Double.parseDouble(super.getFrma().getTxtAce().getText()), tiempo)/10000), 310);
                setV(getV() + velocidad(getV(), Double.parseDouble(super.getFrma().getTxtAce().getText()), tiempo));
                super.getCarro1().setLocation(x1 + ((int)posicion(x1, getV1(), Double.parseDouble(super.getFrma().getTxtAce1().getText()), tiempo)/10000), 310);  
                setV1(getV1() + velocidad(getV1(), Double.parseDouble(super.getFrma().getTxtAce1().getText()), tiempo));
                super.getFrma().repaint(); 
                if(desicion) {
                    if(x1 >= 1060) {
                        int valor = JOptionPane.showConfirmDialog(super.getFrma(), "Uno de los coches se esta llendo fuera de la pantalla. \n¿Está seguro(a) de continuar con la animación?", "Advertencia", JOptionPane.YES_NO_OPTION);
                        if(valor == JOptionPane.YES_OPTION){
                            desicion = false;
                        }
                        else{
                            setEstado(false);
                        }
                    }
                }
                if(x >= x1-100) {
                    setEstado(false);
                }
                else if(x > 100000) {
                    setEstado(false);
                }
                
            }
            super.getFrma().botonesFinal();
            JOptionPane.showMessageDialog(null, "Los coches chocaron :(");
            CocheAlcance coche = new CocheAlcance(Double.parseDouble(super.getFrma().getTxtPos().getText()),Double.parseDouble(super.getFrma().getTxtPos1().getText()), Double.parseDouble(super.getFrma().getTxtVel().getText()), Double.parseDouble(super.getFrma().getTxtVel1().getText()), Double.parseDouble(super.getFrma().getTxtAce().getText()), Double.parseDouble(super.getFrma().getTxtAce1().getText()));
            super.getFrma().añadir(coche);
            super.getFrma().listar();
            } catch (Exception e) {
        }
    }
}
