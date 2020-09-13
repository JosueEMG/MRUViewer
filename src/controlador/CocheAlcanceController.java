/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import java.util.*;
import javax.swing.JOptionPane;
import modelo.CocheAlcance;
import vista.frmCarroAlcance;
/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public class CocheAlcanceController {
    public frmCarroAlcance frm;
    List<CocheAlcance> list = new ArrayList();

    public CocheAlcanceController() {
    }
    
    public void añadir(CocheAlcance e) {
        list.add(e);
    }
    
    public List<CocheAlcance> listado() {
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
            JOptionPane.showMessageDialog(null, "No hay datos registrados en las tablas", "Advetencia" , JOptionPane.ERROR_MESSAGE);
        }
    }
}
