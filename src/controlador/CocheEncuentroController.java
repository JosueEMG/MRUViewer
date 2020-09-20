/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.JOptionPane;
import modelo.CocheEncuentro;
import vista.frmCarroEncuentro;
/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public class CocheEncuentroController {
    public frmCarroEncuentro frm;
    List<CocheEncuentro> list = new ArrayList();

    public CocheEncuentroController() {
    }
    
    public void añadir(CocheEncuentro e) {
        list.add(e);
    }
    
    public List<CocheEncuentro> listado() {
        return list;
    }
    
    public boolean encontrar() {
        if(list == null || list.isEmpty()){
            return false;
        }
        return true;
    }
    
    public void eliminar() {
        if(encontrar()) {
            list.clear();
        }
        else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No hay datos registrados en las tablas", "Advetencia" , JOptionPane.ERROR_MESSAGE);
        }
    }
}
