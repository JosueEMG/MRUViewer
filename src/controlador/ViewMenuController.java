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
import vista.frmMenu;

/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public class ViewMenuController implements MouseListener{

    private final frmMenu menu;
    
    public final void events() {
        menu.getBtnEncuentro().addMouseListener(this);
        menu.getBtnAlcance().addMouseListener(this);
        menu.getBtnCerrar().addMouseListener(this);
    }

    public ViewMenuController(frmMenu menu) {
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
        
        if(evt.equals(menu.getBtnEncuentro())) {
            changeBackground(menu.continerBtnTe, new Color(44, 62, 80));
        }
        else if(evt.equals(menu.getBtnAlcance())) {
            changeBackground(menu.continerBtnTa, new Color(44, 62, 80));
        }
        else if(evt.equals(menu.getBtnCerrar())) {
            changeBackground(menu.continerBtnClose, new Color(255, 80, 80));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
        Object evt = me.getSource();
        
        if(evt.equals(menu.getBtnEncuentro())) {
            changeBackground(menu.continerBtnTe, new Color(51, 51, 51));
        }
        else if(evt.equals(menu.getBtnAlcance())) {
            changeBackground(menu.continerBtnTa, new Color(51, 51, 51));
        }
        else if(evt.equals(menu.getBtnCerrar())) {
            changeBackground(menu.continerBtnClose, new Color(255, 0, 0));
        }
    }
    
    private void changeBackground(JPanel panel, Color color) {
        
        panel.setBackground(color);
    }

}
