/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controlador.ViewMenuController;

/**
 *
 * @author Josue Emmanuel Medina Garcia
 */
public class frmMenu extends javax.swing.JFrame {

    public ViewMenuController controller;
    
    public frmMenu() {
        initComponents();
        try {
            setIconImage(new ImageIcon(getClass().getResource("/imagenes/camioneta_r.png")).getImage());            
        } catch (Exception e) {
        }
        this.setLocationRelativeTo(null);
        cerrar();
        controller = new ViewMenuController(this);
        
    }

    public void cerrar() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void confirmarSalida() {
        int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro(a) de salir de la aplicación?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        continerBtnTe = new javax.swing.JPanel();
        btnEncuentro = new javax.swing.JButton();
        continerBtnTa = new javax.swing.JPanel();
        btnAlcance = new javax.swing.JButton();
        continerBtnClose = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MRUVProject");
        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(535, 390));
        setMinimumSize(new java.awt.Dimension(535, 390));
        setPreferredSize(new java.awt.Dimension(535, 390));
        setResizable(false);
        setSize(new java.awt.Dimension(535, 390));

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MRUVProject");
        menu.add(jLabel1);
        jLabel1.setBounds(195, 0, 145, 32);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Created by: Josué Emmnauel Medina García");
        menu.add(jLabel2);
        jLabel2.setBounds(10, 330, 270, 20);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Version: 1.0.2");
        menu.add(jLabel3);
        jLabel3.setBounds(440, 330, 83, 20);

        continerBtnTe.setBackground(new java.awt.Color(51, 51, 51));
        continerBtnTe.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(102, 102, 102)));
        continerBtnTe.setForeground(new java.awt.Color(255, 255, 255));
        continerBtnTe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        continerBtnTe.setMinimumSize(new java.awt.Dimension(250, 80));
        continerBtnTe.setPreferredSize(new java.awt.Dimension(350, 70));
        continerBtnTe.setLayout(new java.awt.BorderLayout());

        btnEncuentro.setBackground(new java.awt.Color(255, 255, 255));
        btnEncuentro.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        btnEncuentro.setForeground(new java.awt.Color(255, 255, 255));
        btnEncuentro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/encuentro.png"))); // NOI18N
        btnEncuentro.setMnemonic('e');
        btnEncuentro.setText("Tiempo de encuentro");
        btnEncuentro.setContentAreaFilled(false);
        btnEncuentro.setFocusPainted(false);
        btnEncuentro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEncuentro.setIconTextGap(20);
        btnEncuentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncuentroActionPerformed(evt);
            }
        });
        continerBtnTe.add(btnEncuentro, java.awt.BorderLayout.CENTER);

        menu.add(continerBtnTe);
        continerBtnTe.setBounds(90, 70, 360, 70);

        continerBtnTa.setBackground(new java.awt.Color(51, 51, 51));
        continerBtnTa.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(102, 102, 102)));
        continerBtnTa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        continerBtnTa.setMinimumSize(new java.awt.Dimension(250, 80));
        continerBtnTa.setPreferredSize(new java.awt.Dimension(350, 70));
        continerBtnTa.setLayout(new java.awt.BorderLayout());

        btnAlcance.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        btnAlcance.setForeground(new java.awt.Color(255, 255, 255));
        btnAlcance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/alcance.png"))); // NOI18N
        btnAlcance.setMnemonic('a');
        btnAlcance.setText("Tiempo de alcance");
        btnAlcance.setContentAreaFilled(false);
        btnAlcance.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlcance.setIconTextGap(20);
        btnAlcance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlcanceActionPerformed(evt);
            }
        });
        continerBtnTa.add(btnAlcance, java.awt.BorderLayout.CENTER);

        menu.add(continerBtnTa);
        continerBtnTa.setBounds(90, 160, 360, 70);

        continerBtnClose.setBackground(new java.awt.Color(255, 51, 51));
        continerBtnClose.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        continerBtnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        continerBtnClose.setPreferredSize(new java.awt.Dimension(150, 40));
        continerBtnClose.setLayout(new java.awt.BorderLayout());

        btnCerrar.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setMnemonic('c');
        btnCerrar.setText("Cerrar");
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setMaximumSize(new java.awt.Dimension(177, 37));
        btnCerrar.setMinimumSize(new java.awt.Dimension(177, 37));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        continerBtnClose.add(btnCerrar, java.awt.BorderLayout.CENTER);

        menu.add(continerBtnClose);
        continerBtnClose.setBounds(195, 250, 150, 40);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("(Atl + A)");
        menu.add(jLabel4);
        jLabel4.setBounds(460, 190, 60, 16);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("(Atl + C)");
        menu.add(jLabel5);
        jLabel5.setBounds(350, 260, 60, 16);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("(Atl + E)");
        menu.add(jLabel6);
        jLabel6.setBounds(460, 100, 60, 16);

        getContentPane().add(menu, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleDescription("This software has been created for show how the MRUV works with two cars");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncuentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncuentroActionPerformed
        frmCarroEncuentro frm = new frmCarroEncuentro();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEncuentroActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        confirmarSalida();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAlcanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlcanceActionPerformed
        frmCarroAlcance frm = new frmCarroAlcance();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAlcanceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlcance;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEncuentro;
    public javax.swing.JPanel continerBtnClose;
    public javax.swing.JPanel continerBtnTa;
    public javax.swing.JPanel continerBtnTe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtnCerrar() {
        return btnCerrar;
    }

    public void setBtnCerrar(javax.swing.JButton btnCerrar) {
        this.btnCerrar = btnCerrar;
    }

    public javax.swing.JButton getBtnEncuentro() {
        return btnEncuentro;
    }

    public void setBtnEncuentro(javax.swing.JButton btnEncuentro) {
        this.btnEncuentro = btnEncuentro;
    }

    public javax.swing.JButton getBtnAlcance() {
        return btnAlcance;
    }

    public void setBtnAlcance(javax.swing.JButton btnEncuentro1) {
        this.btnAlcance = btnEncuentro1;
    }
}
