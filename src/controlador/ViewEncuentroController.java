/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import vista.frmCarroEncuentro;

/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public class ViewEncuentroController implements MouseListener{

    private final frmCarroEncuentro menu;
    
    public final void events() {
        menu.getBtnVolver().addMouseListener(this);
    }

    public ViewEncuentroController(frmCarroEncuentro menu) {
        this.menu = menu;
        events();
    }
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
        Object evt = me.getSource();
        
        if(evt.equals(menu.getBtnVolver())) {
            changeBackground(menu.continerBtnBack, new Color(80, 150, 80));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
        Object evt = me.getSource();
        
        if(evt.equals(menu.getBtnVolver())) {
            changeBackground(menu.continerBtnBack, new Color(51, 150, 51));
        }
    }
    
    private void changeBackground(JPanel panel, Color color) {
        
        panel.setBackground(color);
    }
}
