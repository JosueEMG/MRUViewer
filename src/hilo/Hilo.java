/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hilo;

import javax.swing.JLabel;
import vista.frmCarroAlcance;
import vista.frmCarroEncuentro;

/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public abstract class Hilo extends Thread{

    private boolean estado = true;
    private frmCarroAlcance frma; 
    private frmCarroEncuentro frme; 
    private JLabel carro;
    private JLabel carro1;
    private double v;
    private double v1;

    public Hilo(frmCarroAlcance frma, JLabel carro, JLabel carro1) {
        this.frma = frma;
        this.carro = carro;
        this.carro1 = carro1;
        this.v = Double.parseDouble(frma.getTxtVel().getText());
        this.v1 = Double.parseDouble(frma.getTxtVel1().getText());
    }

    public Hilo(frmCarroEncuentro frme, JLabel carro, JLabel carro1) {
        this.frme = frme;
        this.carro = carro;
        this.carro1 = carro1;
        this.v = Double.parseDouble(frme.getTxtVel().getText());
        this.v1 = Double.parseDouble(frme.getTxtVel1().getText());
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
    public abstract void run();

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public frmCarroAlcance getFrma() {
        return frma;
    }

    public void setFrma(frmCarroAlcance frma) {
        this.frma = frma;
    }

    public frmCarroEncuentro getFrme() {
        return frme;
    }

    public void setFrme(frmCarroEncuentro frme) {
        this.frme = frme;
    }

    public JLabel getCarro() {
        return carro;
    }

    public void setCarro(JLabel carro) {
        this.carro = carro;
    }

    public JLabel getCarro1() {
        return carro1;
    }

    public void setCarro1(JLabel carro1) {
        this.carro1 = carro1;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public double getV1() {
        return v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }
    
}
