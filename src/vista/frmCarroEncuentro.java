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
import controlador.ViewEncuentroController;
import java.awt.Toolkit;
/**
 *
 * @author Josue Emmanuel Medina Garcia
 */
public class frmCarroEncuentro extends javax.swing.JFrame {
    
    ViewEncuentroController controller;
    DefaultTableModel dt;
    DefaultTableModel dt1;
    boolean salirDirecto = true;
    static HiloEncuentro h;
    CocheEncuentroController c = new CocheEncuentroController();
    
    public frmCarroEncuentro() {
        initComponents();
        controller = new ViewEncuentroController(this);
        try {
            setIconImage(new ImageIcon(getClass().getResource("/imagenes/camioneta_r.png")).getImage());            
        } catch (Exception e) {
        }
        mostrarImg();
        this.setLocationRelativeTo(null);
        btnPausar.setEnabled(false);
        btnReanudar.setEnabled(false);
        btnParar.setEnabled(false);
        cerrar(); 
    }
    
    public void añadir(CocheEncuentro e) {
        c.añadir(e);
    }
    
    void botonesInicio() {
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
    
    void cerrar() {
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
    
    void confirmar() {
        if(salirDirecto){
            this.setVisible(false);
            frmMenu menu = new frmMenu();
            menu.setVisible(true);
        }
        else{
            int valor = JOptionPane.showConfirmDialog(this, "Se eliminaran todos los datos registrados. \n¿Está seguro(a) de volver a la ventana pricipal?", "Advertencia", JOptionPane.YES_NO_OPTION);
            if(valor == JOptionPane.YES_OPTION){
                this.setVisible(false);
                frmMenu menu = new frmMenu();
                menu.setVisible(true);
            }
            else{
                salirDirecto = false;
            }
        }
    }
    
    void frameInicial() {
        salirDirecto = false;
        carro.setLocation(Integer.parseInt(txtPos.getText())-100, 310);
        carro1.setLocation(Integer.parseInt(txtPos1.getText()), 310);
        mostrarImg();
        h = new HiloEncuentro(this, carro, carro1);
        h.start();
    }
    
    void iniciar() {
        try {
            if(Integer.parseInt(txtPos.getText()) > Integer.parseInt(txtPos1.getText())) {
                JOptionPane.showMessageDialog(null, "La posicion del coche 1 tiene que ser menor al del coche 2", "Advertencia", JOptionPane.OK_OPTION);
            }
            else if(Double.parseDouble(txtAce.getText()) <= 0 || Double.parseDouble(txtAce1.getText()) <= 0 || Double.parseDouble(txtVel.getText()) < 0 || Double.parseDouble(txtVel1.getText()) <0 ){
                JOptionPane.showMessageDialog(null, "Debe ingresar aceleracion mayor a 0 o velocidad positiva", "Advertencia", JOptionPane.OK_OPTION);
            }
            else{
                botonesInicio();
                if (Integer.parseInt(txtPos1.getText()) > 1030 || Integer.parseInt(txtPos.getText()) <= 0) {
                    int valor = JOptionPane.showConfirmDialog(this, "Uno o dos coches aparecerán fuera de la pantalla. \n¿Está seguro de continuar con la animación?", "Advertencia", JOptionPane.YES_NO_OPTION);
                    if(valor == JOptionPane.YES_OPTION){
                        frameInicial();
                    }
                    else{
                        botonesFinal();
                        return;
                    }
                }
                else {
                    frameInicial();
                }
            }
        } catch (Exception e) {
            botonesFinal();
            JOptionPane.showMessageDialog(null, "Ingrese valores a todos los campos \no tambien ingrese valores enteros a las posiciones", "Advetencia" , JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public void listar() {
        dt = (DefaultTableModel)tabla.getModel();
        dt1 = (DefaultTableModel)tabla1.getModel();
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
    
    void limpiar() {
        int valor = JOptionPane.showConfirmDialog(this, "Se eliminaran todos los datos registrados. \n¿Está seguro(a) de realizar esta acción?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            salirDirecto = true;
            txtAce.setText("");
            txtAce1.setText("");
            txtPos.setText("100");
            txtPos1.setText("900");
            txtVel.setText("");
            txtVel1.setText("");
            carro.setLocation(0, 310);
            carro1.setLocation(900, 310);
            c.eliminar();
            try {
                dt.setRowCount(0);
                dt1.setRowCount(0);    
            } catch (Exception e) {
            }
        }
    }
    
    void mostrarImg() {
        ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/camioneta_r.png"));
        Image imgesc = img.getImage().getScaledInstance(carro.getWidth(), carro.getHeight(), Image.SCALE_SMOOTH);
        carro.setIcon(new ImageIcon(imgesc));
        ImageIcon img1 = new ImageIcon(getClass().getResource("/imagenes/coche_l.png"));
        Image imgesc1 = img1.getImage().getScaledInstance(carro1.getWidth(), carro1.getHeight(), Image.SCALE_SMOOTH);
        carro1.setIcon(new ImageIcon(imgesc1));
        ImageIcon img2 = new ImageIcon(getClass().getResource("/imagenes/fondopanelMRUVProject.png"));
        Image imgesc2 = img2.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(imgesc2));
    }
    
    public int velocidad() {
        int vec[] = {15, 35, 5};
        return vec[cbVelocidad.getSelectedIndex()];
    }

    @SuppressWarnings("override")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        carro1 = new javax.swing.JLabel();
        carro = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tiempoEncuentro = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        btnPausar = new javax.swing.JButton();
        btnReanudar = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        cbVelocidad = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        continerBtnBack = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        continerBtnClean = new javax.swing.JPanel();
        btnClean = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MRUVProject");
        setMinimumSize(new java.awt.Dimension(1300, 750));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(65, 65, 65));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        carro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/coche_l.png"))); // NOI18N
        jPanel1.add(carro1);
        carro1.setBounds(900, 310, 100, 100);

        carro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/camioneta_r.png"))); // NOI18N
        carro.setToolTipText("");
        jPanel1.add(carro);
        carro.setBounds(0, 310, 100, 100);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondopanelMRUVProject.png"))); // NOI18N
        jPanel1.add(fondo);
        fondo.setBounds(0, 0, 1030, 410);

        jPanel5.add(jPanel1);
        jPanel1.setBounds(6, 51, 1030, 410);

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Datos coche 1");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(80, 490, 120, 25);

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tiempo de encuentro: ");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(290, 660, 154, 22);

        tiempoEncuentro.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        tiempoEncuentro.setForeground(new java.awt.Color(255, 255, 255));
        tiempoEncuentro.setText("Inicie la simulacion para ver resultados");
        jPanel5.add(tiempoEncuentro);
        tiempoEncuentro.setBounds(460, 660, 268, 22);

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tiempo de encuentro");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(490, 10, 233, 32);

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Controles");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(1115, 10, 81, 25);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)), "Botones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Yu Gothic UI", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        btnIniciar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel4.add(btnIniciar);
        btnIniciar.setBounds(20, 40, 100, 50);

        btnPausar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnPausar.setText("Pausar");
        btnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarActionPerformed(evt);
            }
        });
        jPanel4.add(btnPausar);
        btnPausar.setBounds(120, 40, 100, 50);

        btnReanudar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnReanudar.setText("Reanudar");
        btnReanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReanudarActionPerformed(evt);
            }
        });
        jPanel4.add(btnReanudar);
        btnReanudar.setBounds(20, 90, 100, 50);

        btnParar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnParar.setText("Parar");
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });
        jPanel4.add(btnParar);
        btnParar.setBounds(120, 90, 100, 50);

        cbVelocidad.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        cbVelocidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Lento", "Rapido" }));
        jPanel4.add(cbVelocidad);
        cbVelocidad.setBounds(20, 180, 200, 32);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Velocidad:");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(20, 150, 80, 22);

        jPanel5.add(jPanel4);
        jPanel4.setBounds(1048, 240, 235, 230);

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
        txtPos.setText("100");
        txtPos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPosKeyTyped(evt);
            }
        });
        jPanel2.add(txtPos);
        txtPos.setBounds(40, 70, 61, 28);

        txtVel.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        txtVel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVelKeyTyped(evt);
            }
        });
        jPanel2.add(txtVel);
        txtVel.setBounds(40, 110, 61, 28);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("V:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 110, 20, 22);

        txtAce.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        txtAce.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAceKeyTyped(evt);
            }
        });
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
        txtPos1.setText("900");
        txtPos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPos1KeyTyped(evt);
            }
        });
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
        txtVel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVel1KeyTyped(evt);
            }
        });
        jPanel2.add(txtVel1);
        txtVel1.setBounds(150, 110, 61, 28);

        txtAce1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        txtAce1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAce1KeyTyped(evt);
            }
        });
        jPanel2.add(txtAce1);
        txtAce1.setBounds(150, 150, 61, 28);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("A:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(130, 150, 20, 22);

        jPanel5.add(jPanel2);
        jPanel2.setBounds(1048, 35, 235, 200);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Indicaciones:");
        jPanel3.add(jLabel16, java.awt.BorderLayout.NORTH);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("1m = 1px");
        jPanel3.add(jLabel7, java.awt.BorderLayout.WEST);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("1 segundo = 10 milisegundos reales");
        jPanel3.add(jLabel8, java.awt.BorderLayout.PAGE_END);

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("1 Coche = 100m");
        jPanel3.add(jLabel17, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel3);
        jPanel3.setBounds(380, 510, 270, 130);

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Datos coche 2");
        jPanel5.add(jLabel18);
        jLabel18.setBounds(820, 490, 120, 25);

        jScrollPane3.setForeground(new java.awt.Color(51, 51, 51));

        tabla.setBackground(new java.awt.Color(51, 51, 51));
        tabla.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Xf", "Vf", "A"
            }
        ));
        tabla.setGridColor(new java.awt.Color(0, 0, 0));
        tabla.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabla);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(20, 520, 240, 180);

        jScrollPane4.setForeground(new java.awt.Color(51, 51, 51));

        tabla1.setBackground(new java.awt.Color(51, 51, 51));
        tabla1.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        tabla1.setForeground(new java.awt.Color(255, 255, 255));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Xf", "Vf", "A"
            }
        ));
        tabla1.setGridColor(new java.awt.Color(0, 0, 0));
        tabla1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tabla1.getTableHeader().setResizingAllowed(false);
        tabla1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabla1);

        jPanel5.add(jScrollPane4);
        jScrollPane4.setBounds(760, 520, 240, 180);

        continerBtnBack.setBackground(new java.awt.Color(51, 220, 51));
        continerBtnBack.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        continerBtnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        continerBtnBack.setPreferredSize(new java.awt.Dimension(150, 40));
        continerBtnBack.setLayout(new java.awt.BorderLayout());

        btnVolver.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(0, 0, 0));
        btnVolver.setMnemonic('v');
        btnVolver.setText("Volver");
        btnVolver.setContentAreaFilled(false);
        btnVolver.setMaximumSize(new java.awt.Dimension(177, 37));
        btnVolver.setMinimumSize(new java.awt.Dimension(177, 37));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        continerBtnBack.add(btnVolver, java.awt.BorderLayout.CENTER);

        jPanel5.add(continerBtnBack);
        continerBtnBack.setBounds(1055, 610, 160, 50);

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setText("(Atl + L)");
        jPanel5.add(jLabel19);
        jLabel19.setBounds(1220, 550, 60, 22);

        continerBtnClean.setBackground(new java.awt.Color(220, 220, 51));
        continerBtnClean.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        continerBtnClean.setForeground(new java.awt.Color(255, 255, 255));
        continerBtnClean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        continerBtnClean.setPreferredSize(new java.awt.Dimension(150, 40));
        continerBtnClean.setLayout(new java.awt.BorderLayout());

        btnClean.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        btnClean.setForeground(new java.awt.Color(0, 0, 0));
        btnClean.setMnemonic('l');
        btnClean.setText("Limpiar");
        btnClean.setContentAreaFilled(false);
        btnClean.setMaximumSize(new java.awt.Dimension(177, 37));
        btnClean.setMinimumSize(new java.awt.Dimension(177, 37));
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });
        continerBtnClean.add(btnClean, java.awt.BorderLayout.CENTER);

        jPanel5.add(continerBtnClean);
        continerBtnClean.setBounds(1055, 540, 160, 50);

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setText("(Atl + V)");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(1220, 620, 60, 22);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        iniciar();
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

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void txtPosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPosKeyTyped
        char letra = evt.getKeyChar();
        if(Character.isLetter(letra)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(txtPos.getText().length() >= 6) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtPosKeyTyped

    private void txtPos1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPos1KeyTyped
        char letra = evt.getKeyChar();
        if(Character.isLetter(letra)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(txtPos1.getText().length() >= 6) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtPos1KeyTyped

    private void txtVelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVelKeyTyped
        char letra = evt.getKeyChar();
        if(Character.isLetter(letra)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(txtVel.getText().length() >= 3) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtVelKeyTyped

    private void txtVel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVel1KeyTyped
        char letra = evt.getKeyChar();
        if(Character.isLetter(letra)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(txtVel1.getText().length() >= 3) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtVel1KeyTyped

    private void txtAceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAceKeyTyped
        char letra = evt.getKeyChar();
        if(Character.isLetter(letra)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(txtAce.getText().length() >= 3) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtAceKeyTyped

    private void txtAce1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAce1KeyTyped
        char letra = evt.getKeyChar();
        if(Character.isLetter(letra)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        else if(txtAce1.getText().length() >= 3) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtAce1KeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnParar;
    private javax.swing.JButton btnPausar;
    private javax.swing.JButton btnReanudar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel carro;
    private javax.swing.JLabel carro1;
    private javax.swing.JComboBox<String> cbVelocidad;
    public javax.swing.JPanel continerBtnBack;
    public javax.swing.JPanel continerBtnClean;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
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

    public javax.swing.JButton getBtnVolver() {
        return btnVolver;
    }

    public void setBtnVolver(javax.swing.JButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    public javax.swing.JButton getBtnClean() {
        return btnClean;
    }

    public void setBtnClean(javax.swing.JButton btnClean) {
        this.btnClean = btnClean;
    }


}
