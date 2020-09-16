/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public class SaveTextController {

    static FileOutputStream salida;
    
    public static String guardarTexto(File archivo, String contenido) {
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "Los datos se guardaron exitosamente";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al momento de guardar el texto");
        }
        return respuesta;
    }
}
