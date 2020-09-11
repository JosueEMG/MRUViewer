/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import java.util.*;
import modelo.CocheEncuentro;
/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public class CocheEncuentroController {
    List<CocheEncuentro> list = new ArrayList();

    public CocheEncuentroController() {
    }
    
    public void añadir(CocheEncuentro e) {
        list.add(e);
    }
    
    public List<CocheEncuentro> listado() {
        return list;
    }
    
    public void eliminar() {
        for (CocheEncuentro cocheEncuentro : listado()) {
            list.remove(cocheEncuentro);
        }
    }
}
