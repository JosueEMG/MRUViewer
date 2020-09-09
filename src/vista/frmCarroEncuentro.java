/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import modelo.CocheEncuentro;
import controlador.CocheEncuentroController;
import javax.swing.JOptionPane;
import hilo.HiloEncuentro;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Josue Emmanuel Medina Garcia
 */
public class frmCarroEncuentro extends javax.swing.JFrame {

    public static HiloEncuentro h;
    CocheEncuentroController c = new CocheEncuentroController();
    public frmCarroEncuentro() {
        initComponents();
        try {
            setIconImage(new ImageIcon(getClass().getResource("/imagenes/camioneta_r.png")).getImage());            
        } catch (Exception e) {
        }
        mostrarimg();
        this.setLocationRelativeTo(null);
        btnPausar.setEnabled(false);
        btnReanudar.setEnabled(false);
        btnParar.setEnabled(false);
        cerrar();
        
    }
    
    public void cerrar() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmar();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void confirmar() {
        int valor = JOptionPane.showConfirmDialog(this, "Se eliminaran todos los datos registrados. \n¿Está seguro de volver a la ventana pricipal?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            this.setVisible(false);
            frmMenu menu = new frmMenu();
            menu.setVisible(true);
        }
    }
    
    void mostrarimg(){
        ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/camioneta_r.png"));
        Image imgesc = img.getImage().getScaledInstance(carro.getWidth(), carro.getHeight(), Image.SCALE_SMOOTH);
        carro.setIcon(new ImageIcon(imgesc));
        ImageIcon img1 = new ImageIcon(getClass().getResource("/imagenes/coche_l.png"));
        Image imgesc1 = img1.getImage().getScaledInstance(carro1.getWidth(), carro1.getHeight(), Image.SCALE_SMOOTH);
        carro1.setIcon(new ImageIcon(imgesc1));
    }
    
    public void añadir(CocheEncuentro e){
        c.añadir(e);
    }
    
    public void listar(){
        DefaultTableModel dt = (DefaultTableModel)tabla.getModel();
        DefaultTableModel dt1 = (DefaultTableModel)tabla1.getModel();
        dt.setRowCount(0);
        dt1.setRowCount(0);
        for (CocheEncuentro c : c.listado()) {
            Object v[] = {Math.round(c.posicion()*100.0)/100.0,Math.round(c.velocidad()*100.0)/100.0,Math.round(c.getA()*100.0)/100.0};
            Object v1[] = {Math.round(c.posicion1()*100.0)/100.0,Math.round(c.velocidad1()*100.0)/100.0*-1,Math.round(c.getA1()*100.0)/100.0};
            dt.addRow(v);
            dt1.addRow(v1);
            tiempoEncuentro.setText(""+Math.round(c.tiempoEncuentro()*100.0)/100.0+" Segundos");
        }  
    }

    @SuppressWarnings("override")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        carro1 = new javax.swing.JLabel();
        carro = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tiempoEncuentro = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        btnPausar = new javax.swing.JButton();
        btnReanudar = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPos = new javax.swing.JTextField();
        txtVel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAce = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPos1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtVel1 = new javax.swing.JTextField();
        txtAce1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MRUVProyect");
        setMinimumSize(new java.awt.Dimension(1300, 750));
        setPreferredSize(new java.awt.Dimension(1300, 750));
        setSize(new java.awt.Dimension(800, 600));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(65, 65, 65));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        carro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/coche_l.png"))); // NOI18N

        carro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/camioneta_r.png"))); // NOI18N
        carro.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(carro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 701, Short.MAX_VALUE)
                .addComponent(carro1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(294, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(carro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carro1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.add(jPanel1);
        jPanel1.setBounds(6, 51, 1025, 410);

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Datos coche 1");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(70, 490, 120, 25);

        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(450, 405));

        tabla.setBackground(new java.awt.Color(51, 51, 51));
        tabla.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Xf ", "Vf", "A"
            }
        ));
        tabla.setGridColor(new java.awt.Color(0, 0, 0));
        tabla.setPreferredSize(new java.awt.Dimension(225, 148));
        tabla.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(10, 520, 243, 180);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Datos coche 2");
        jPanel5.add(jLabel10);
        jLabel10.setBounds(850, 490, 120, 25);

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tiempo de encuentro: ");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(310, 650, 154, 22);

        tiempoEncuentro.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        tiempoEncuentro.setForeground(new java.awt.Color(255, 255, 255));
        tiempoEncuentro.setText("Inicie la simulacion para ver resultados");
        jPanel5.add(tiempoEncuentro);
        tiempoEncuentro.setBounds(470, 650, 268, 22);

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tiempo de encuentro");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(490, 10, 233, 32);

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Controles");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(1115, 19, 81, 25);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)), "Botones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Yu Gothic UI", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        btnIniciar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel4.add(btnIniciar);
        btnIniciar.setBounds(20, 50, 100, 36);

        btnPausar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnPausar.setForeground(new java.awt.Color(0, 0, 0));
        btnPausar.setText("Pausar");
        btnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarActionPerformed(evt);
            }
        });
        jPanel4.add(btnPausar);
        btnPausar.setBounds(120, 50, 100, 36);

        btnReanudar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnReanudar.setForeground(new java.awt.Color(0, 0, 0));
        btnReanudar.setText("Reanudar");
        btnReanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReanudarActionPerformed(evt);
            }
        });
        jPanel4.add(btnReanudar);
        btnReanudar.setBounds(20, 120, 100, 36);

        btnParar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnParar.setForeground(new java.awt.Color(0, 0, 0));
        btnParar.setText("Parar");
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });
        jPanel4.add(btnParar);
        btnParar.setBounds(120, 120, 100, 36);

        jPanel5.add(jPanel4);
        jPanel4.setBounds(1040, 260, 235, 200);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Yu Gothic UI", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Coche 1");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(20, 30, 60, 22);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 70, 20, 22);

        txtPos.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jPanel2.add(txtPos);
        txtPos.setBounds(40, 70, 61, 28);

        txtVel.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jPanel2.add(txtVel);
        txtVel.setBounds(40, 110, 61, 28);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("V:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 110, 20, 22);

        txtAce.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jPanel2.add(txtAce);
        txtAce.setBounds(40, 150, 61, 28);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("A:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 150, 20, 22);

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Coche 2");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(130, 30, 60, 22);

        txtPos1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jPanel2.add(txtPos1);
        txtPos1.setBounds(150, 70, 61, 28);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(130, 70, 20, 22);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("V:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(130, 110, 20, 22);

        txtVel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jPanel2.add(txtVel1);
        txtVel1.setBounds(150, 110, 61, 28);

        txtAce1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jPanel2.add(txtAce1);
        txtAce1.setBounds(150, 150, 61, 28);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("A:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(130, 150, 20, 22);

        jPanel5.add(jPanel2);
        jPanel2.setBounds(1040, 50, 235, 200);

        btnVolver.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(0, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel5.add(btnVolver);
        btnVolver.setBounds(1110, 570, 95, 45);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Indicaciones:");
        jPanel3.add(jLabel16, java.awt.BorderLayout.NORTH);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("1m = 1 pixel");
        jPanel3.add(jLabel7, java.awt.BorderLayout.WEST);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("1 segundo = 10 milisegundos reales");
        jPanel3.add(jLabel8, java.awt.BorderLayout.PAGE_END);

        jPanel5.add(jPanel3);
        jPanel3.setBounds(380, 520, 270, 110);

        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(450, 405));

        tabla1.setBackground(new java.awt.Color(51, 51, 51));
        tabla1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        tabla1.setForeground(new java.awt.Color(255, 255, 255));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Xf ", "Vf", "A"
            }
        ));
        tabla1.setGridColor(new java.awt.Color(0, 0, 0));
        tabla1.setPreferredSize(new java.awt.Dimension(225, 148));
        tabla1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabla1.getTableHeader().setResizingAllowed(false);
        tabla1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabla1);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(790, 520, 243, 180);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void botonesInicio(){
        btnParar.setEnabled(true);
        btnPausar.setEnabled(true);
        btnIniciar.setEnabled(false);
    }
    public void botonesFinal(){
        btnParar.setEnabled(false);
        btnPausar.setEnabled(false);
        btnReanudar.setEnabled(false);
        btnIniciar.setEnabled(true);
    }
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        try {
            if(Double.parseDouble(txtAce.getText()) <= 0 || Double.parseDouble(txtAce1.getText()) <= 0 || Double.parseDouble(txtVel.getText()) < 0 || Double.parseDouble(txtVel1.getText()) <0 ){
                JOptionPane.showMessageDialog(null, "Debe ingresar aceleracion mayor a 0 o velocidad positiva", "Advertencia", JOptionPane.OK_OPTION);
            }
            else{
                botonesInicio();
                carro.setLocation(Integer.parseInt(txtPos.getText()), 300);
                carro1.setLocation(Integer.parseInt(txtPos1.getText()), 300);
                mostrarimg();
                h = new HiloEncuentro(this, carro, carro1);
                h.start();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese valores a todos los campos", "Advetencia" , JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarActionPerformed
        h.suspend();
        btnReanudar.setEnabled(true);
        btnPausar.setEnabled(false);
        btnParar.setEnabled(false);
    }//GEN-LAST:event_btnPausarActionPerformed

    private void btnReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReanudarActionPerformed
        h.resume();
        btnPausar.setEnabled(true);
        btnReanudar.setEnabled(false);
        btnParar.setEnabled(true);
    }//GEN-LAST:event_btnReanudarActionPerformed

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        h.parar();
    }//GEN-LAST:event_btnPararActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        confirmar();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(frmCarroEncuentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCarroEncuentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCarroEncuentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCarroEncuentro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCarroEncuentro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnParar;
    private javax.swing.JButton btnPausar;
    private javax.swing.JButton btnReanudar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel carro;
    private javax.swing.JLabel carro1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla1;
    private javax.swing.JLabel tiempoEncuentro;
    private javax.swing.JTextField txtAce;
    private javax.swing.JTextField txtAce1;
    private javax.swing.JTextField txtPos;
    private javax.swing.JTextField txtPos1;
    private javax.swing.JTextField txtVel;
    private javax.swing.JTextField txtVel1;
    // End of variables declaration//GEN-END:variables

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
    
    public javax.swing.JTextField getTxtAce() {
        return txtAce;
    }

    public void setTxtAce(javax.swing.JTextField txtAce) {
        this.txtAce = txtAce;
    }

    public javax.swing.JTextField getTxtAce1() {
        return txtAce1;
    }

    public void setTxtAce1(javax.swing.JTextField txtAce1) {
        this.txtAce1 = txtAce1;
    }

    public javax.swing.JTextField getTxtVel() {
        return txtVel;
    }

    public void setTxtVel(javax.swing.JTextField txtVel) {
        this.txtVel = txtVel;
    }

    public javax.swing.JTextField getTxtVel1() {
        return txtVel1;
    }

    public void setTxtVel1(javax.swing.JTextField txtVel1) {
        this.txtVel1 = txtVel1;
    }

    public javax.swing.JTextField getTxtPos() {
        return txtPos;
    }

    public void setTxtPos(javax.swing.JTextField txtPos) {
        this.txtPos = txtPos;
    }

    public javax.swing.JTextField getTxtPos1() {
        return txtPos1;
    }

    public void setTxtPos1(javax.swing.JTextField txtPos1) {
        this.txtPos1 = txtPos1;
    }


}
