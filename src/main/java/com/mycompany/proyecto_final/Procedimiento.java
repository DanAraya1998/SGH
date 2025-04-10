package com.mycompany.proyecto_final;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Procedimiento extends javax.swing.JFrame {

    public Procedimiento(FormHospital formHospital, int duracion, String nombrePaciente) {
        initComponents();
        setTitle("Cirugía en curso");
        setLocationRelativeTo(formHospital);
        setResizable(false);

        lblNombre.setText("Cirugía de " + nombrePaciente);
        pBarTiempo.setMaximum(duracion);
        
        Thread hilo = new Thread(() -> {
        for (int i = 0; i <= duracion; i++) {
            final int valorActual = i;
            final int tiempoRestante = duracion - i;

            SwingUtilities.invokeLater(() -> {
                pBarTiempo.setValue(valorActual);
                lblNombre1.setText("Tiempo restante: " + tiempoRestante + " segundos");
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(this, "Error en el hilo de la cirugía: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Al finalizar
        SwingUtilities.invokeLater(() -> {
            lblNombre.setText("Cirugía finalizada para " + nombrePaciente);
            lblNombre1.setText("Tiempo restante: 0 segundos");
        });
    });

    hilo.start();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        pBarTiempo = new javax.swing.JProgressBar();
        lblNombre1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Cirugía de ");

        lblNombre1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre1.setText("Tiempo restante: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pBarTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(lblNombre1)
                .addGap(26, 26, 26)
                .addComponent(pBarTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JProgressBar pBarTiempo;
    // End of variables declaration//GEN-END:variables
}