/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.JOptionPane;
import modelo.CocheAlcance;
import modelo.CocheEncuentro;
/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public class CocheController {

    List<CocheEncuentro> liste = new ArrayList();
    List<CocheAlcance> lista = new ArrayList();
    
    public void añadir(CocheEncuentro e) {
        liste.add(e);
    }
    
    public void añadir(CocheAlcance a) {
        lista.add(a);
    }
    
    public List<CocheEncuentro> listadoEncuentro() {
        return liste;
    }
    
    public List<CocheAlcance> listadoAlcance() {
        return lista;
    }
    
    public boolean encontrarEncuentro() {
        if(liste == null || liste.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean encontrarAlcance() {
        if(lista == null || lista.isEmpty()){
            return false;
        }
        return true;
    }
    
    public void eliminarEncuentro() {
        if(encontrarEncuentro()) {
            liste.clear();
        }
        else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No hay datos registrados en las tablas", "Advetencia" , JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarAlcance() {
        if(encontrarEncuentro()) {
            lista.clear();
        }
        else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No hay datos registrados en las tablas", "Advetencia" , JOptionPane.ERROR_MESSAGE);
        }
    }
}
