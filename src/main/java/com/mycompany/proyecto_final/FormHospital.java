package com.mycompany.proyecto_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FormHospital extends javax.swing.JFrame {

    public FormHospital(PanelEntrada panelEntrada) {
        this.panelEntrada = panelEntrada;
        initComponents();
        setLocationRelativeTo(null);

        tbAgenda.getTableHeader().setReorderingAllowed(false);

        txtIDCirugia.setEnabled(false);
        btnEditarCirugia.setEnabled(false);
        btnEliminarCirugia.setEnabled(false);

        txtIdentificacionPaciente.setEnabled(false);
        btnEditarPaciente.setEnabled(false);
        btnEliminarPaciente.setEnabled(false);

        txtIdentificacionDoctor.setEnabled(false);
        btnEditarDoctor.setEnabled(false);
        btnEliminarDoctror.setEnabled(false);

        txtIDTipoCirugia.setEnabled(false);
        btnEditarTipoCirugia.setEnabled(false);
        btnEliminarTipoCirugia.setEnabled(false);

        new javax.swing.Timer(60000, e -> verificarCirugias()).start();

        cmboxEspecialidadCirugia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmboxEspecialidadCirugia.getSelectedItem() != null) {
                    String especialidad = cmboxEspecialidadCirugia.getSelectedItem().toString();
                    cargarDoctoresPorEspecialidad(especialidad);
                    cargarTiposPorEspecialidad(especialidad);
                }
            }
        });
        mostrarDatosPaciente();

        jTabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = jTabbedPane1.getSelectedIndex();
                switch (selectedIndex) {
                    case 0: // Tab "Gestión pacientes"
                        mostrarDatosPaciente();
                        break;
                    case 1: // Tab "Gestión doctores"
                        cmboxEspecialidadDoctor.removeAllItems();
                        mostrarDatosDoctor();
                        cargarEspecialidades();
                        break;
                    case 2: // Tab "Gestión cirugías"
                        cmboxEspecialidadCirugia.removeAllItems();
                        cmboxNombrePacuenteCirugia.removeAllItems();
                        cmboxTipoCirugia.removeAllItems();
                        mostrarDatosCirugia();
                        cargarEspecialidades();
                        cargarPacientes();
                        break;
                    case 3: //Tab "Gestión especialidades"
                        mostrarDatosTipos();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombrePaciente = new javax.swing.JTextField();
        txtIdentificacionPaciente = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtEstatura = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnAgregarPaciente = new javax.swing.JButton();
        btnBuscarPaciente = new javax.swing.JButton();
        btnEditarPaciente = new javax.swing.JButton();
        btnEliminarPaciente = new javax.swing.JButton();
        btnLimpiarPaciente = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPacientes = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreDoctor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIdentificacionDoctor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboxJornada = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        btnAgregarDoctor = new javax.swing.JButton();
        btnBuscarDoctor = new javax.swing.JButton();
        btnEditarDoctor = new javax.swing.JButton();
        btnEliminarDoctror = new javax.swing.JButton();
        btnLimpiarDoctor = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDoctor = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        cmboxEspecialidadDoctor = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMensaje = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAgenda = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnAgregarCiugia = new javax.swing.JButton();
        btnBuscarCirugia = new javax.swing.JButton();
        btnEditarCirugia = new javax.swing.JButton();
        btnEliminarCirugia = new javax.swing.JButton();
        btnLimpiarCirugia = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        cmboxTipoCirugia = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        txtIDCirugia = new javax.swing.JTextField();
        txtFechaCirugia = new javax.swing.JTextField();
        txtHoraCirugia = new javax.swing.JTextField();
        txtNumQuirofano = new javax.swing.JTextField();
        cmboxNombreDoctorCirugia = new javax.swing.JComboBox<>();
        cmboxNombrePacuenteCirugia = new javax.swing.JComboBox<>();
        txtTiempoDuracion = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cmboxEspecialidadCirugia = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbTiposCirugias = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        btnAgregarTipoCirugia = new javax.swing.JButton();
        btnBuscarTipoCirugia = new javax.swing.JButton();
        btnEditarTipoCirugia = new javax.swing.JButton();
        btnEliminarTipoCirugia = new javax.swing.JButton();
        btnLimpiarTipoCirugia = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtIDTipoCirugia = new javax.swing.JTextField();
        txtTipoCirugia = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtNombreEspecialidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Pacientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(288, 578));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Identificacion:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Edad:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Peso:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Estatura:");

        txtNombrePaciente.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtIdentificacionPaciente.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtEdad.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtEstatura.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtPeso.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        btnAgregarPaciente.setBackground(new java.awt.Color(153, 204, 255));
        btnAgregarPaciente.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAgregarPaciente.setText("Agregar");
        btnAgregarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPacienteActionPerformed(evt);
            }
        });

        btnBuscarPaciente.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscarPaciente.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBuscarPaciente.setText("Buscar");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        btnEditarPaciente.setBackground(new java.awt.Color(153, 204, 255));
        btnEditarPaciente.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEditarPaciente.setText("Editar");
        btnEditarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPacienteActionPerformed(evt);
            }
        });

        btnEliminarPaciente.setBackground(new java.awt.Color(153, 204, 255));
        btnEliminarPaciente.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEliminarPaciente.setText("Eliminar");
        btnEliminarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPacienteActionPerformed(evt);
            }
        });

        btnLimpiarPaciente.setBackground(new java.awt.Color(153, 204, 255));
        btnLimpiarPaciente.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLimpiarPaciente.setText("Limpiar");
        btnLimpiarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnAgregarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnEditarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnEliminarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnLimpiarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de pacientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        tbPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPacientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPacientes);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("Mensaje");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtIdentificacionPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtPeso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtEstatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdentificacionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtEstatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gestión de pacientes", jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Doctores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(288, 2));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Nombre:");

        txtNombreDoctor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Identificacion:");

        txtIdentificacionDoctor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Especialidad:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Jornada:");

        cboxJornada.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cboxJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jornada Diurna", "Jornada Nocturna", "Jornada Mixta", "Turnos Rotativos" }));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        btnAgregarDoctor.setBackground(new java.awt.Color(153, 204, 255));
        btnAgregarDoctor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAgregarDoctor.setText("Agregar");
        btnAgregarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDoctorActionPerformed(evt);
            }
        });

        btnBuscarDoctor.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscarDoctor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBuscarDoctor.setText("Buscar");
        btnBuscarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDoctorActionPerformed(evt);
            }
        });

        btnEditarDoctor.setBackground(new java.awt.Color(153, 204, 255));
        btnEditarDoctor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEditarDoctor.setText("Editar");
        btnEditarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDoctorActionPerformed(evt);
            }
        });

        btnEliminarDoctror.setBackground(new java.awt.Color(153, 204, 255));
        btnEliminarDoctror.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEliminarDoctror.setText("Eliminar");
        btnEliminarDoctror.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDoctrorActionPerformed(evt);
            }
        });

        btnLimpiarDoctor.setBackground(new java.awt.Color(153, 204, 255));
        btnLimpiarDoctor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLimpiarDoctor.setText("Limpiar");
        btnLimpiarDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarDoctorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarDoctror, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnAgregarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnBuscarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnEditarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnEliminarDoctror, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnLimpiarDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de médicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        tbDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDoctorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbDoctor);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Mensaje");

        cmboxEspecialidadDoctor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboxJornada, 0, 320, Short.MAX_VALUE)
                            .addComponent(cmboxEspecialidadDoctor, 0, 320, Short.MAX_VALUE)
                            .addComponent(txtNombreDoctor)
                            .addComponent(txtIdentificacionDoctor))))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtIdentificacionDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmboxEspecialidadDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cboxJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(158, 158, 158)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gestión de doctores", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agendar Cirugia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Nombre del paciente:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Nombre del doctor:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Fecha:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Hora:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Tipo de cirugia:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Número de quirófano:");

        txtMensaje.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtMensaje.setForeground(new java.awt.Color(255, 0, 0));
        txtMensaje.setText("Mensaje");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agenda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        tbAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAgenda);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        btnAgregarCiugia.setBackground(new java.awt.Color(153, 204, 255));
        btnAgregarCiugia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAgregarCiugia.setText("Agregar");
        btnAgregarCiugia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCiugiaActionPerformed(evt);
            }
        });

        btnBuscarCirugia.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscarCirugia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBuscarCirugia.setText("Buscar");
        btnBuscarCirugia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCirugiaActionPerformed(evt);
            }
        });

        btnEditarCirugia.setBackground(new java.awt.Color(153, 204, 255));
        btnEditarCirugia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEditarCirugia.setText("Editar");
        btnEditarCirugia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCirugiaActionPerformed(evt);
            }
        });

        btnEliminarCirugia.setBackground(new java.awt.Color(153, 204, 255));
        btnEliminarCirugia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEliminarCirugia.setText("Eliminar");
        btnEliminarCirugia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCirugiaActionPerformed(evt);
            }
        });

        btnLimpiarCirugia.setBackground(new java.awt.Color(153, 204, 255));
        btnLimpiarCirugia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLimpiarCirugia.setText("Limpiar");
        btnLimpiarCirugia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCirugiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarCiugia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnAgregarCiugia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnBuscarCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnEditarCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnEliminarCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnLimpiarCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setText("ID de la cirugía:");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setText("Tiempo de duración:");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText("Especialidad:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(txtHoraCirugia))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(336, 336, 336))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(txtFechaCirugia))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(txtNumQuirofano))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmboxNombreDoctorCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmboxNombrePacuenteCirugia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTiempoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(76, 76, 76)
                                        .addComponent(cmboxTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtIDCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmboxEspecialidadCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtIDCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtFechaCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtHoraCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmboxEspecialidadCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtNumQuirofano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cmboxTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmboxNombreDoctorCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cmboxNombrePacuenteCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtTiempoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agendar cirugía", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de especialidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel23.setText("Tipo de cirugía:");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agenda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        tbTiposCirugias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbTiposCirugias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTiposCirugiasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbTiposCirugias);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        btnAgregarTipoCirugia.setBackground(new java.awt.Color(153, 204, 255));
        btnAgregarTipoCirugia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAgregarTipoCirugia.setText("Agregar");
        btnAgregarTipoCirugia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTipoCirugiaActionPerformed(evt);
            }
        });

        btnBuscarTipoCirugia.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscarTipoCirugia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBuscarTipoCirugia.setText("Buscar");
        btnBuscarTipoCirugia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTipoCirugiaActionPerformed(evt);
            }
        });

        btnEditarTipoCirugia.setBackground(new java.awt.Color(153, 204, 255));
        btnEditarTipoCirugia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEditarTipoCirugia.setText("Editar");
        btnEditarTipoCirugia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTipoCirugiaActionPerformed(evt);
            }
        });

        btnEliminarTipoCirugia.setBackground(new java.awt.Color(153, 204, 255));
        btnEliminarTipoCirugia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEliminarTipoCirugia.setText("Eliminar");
        btnEliminarTipoCirugia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTipoCirugiaActionPerformed(evt);
            }
        });

        btnLimpiarTipoCirugia.setBackground(new java.awt.Color(153, 204, 255));
        btnLimpiarTipoCirugia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLimpiarTipoCirugia.setText("Limpiar");
        btnLimpiarTipoCirugia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTipoCirugiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnAgregarTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditarTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiarTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setText("ID tipo de cirugía:");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setText("Especialidad:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                .addGap(336, 336, 336))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreEspecialidad)
                                    .addComponent(txtTipoCirugia)
                                    .addComponent(txtIDTipoCirugia, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtIDTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtTipoCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtNombreEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gestión de especialidades", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAgregarCiugiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCiugiaActionPerformed
        try {
            if (txtFechaCirugia.getText().isEmpty() || txtHoraCirugia.getText().isEmpty()
                    || txtNumQuirofano.getText().isEmpty() || txtTiempoDuracion.getText().isEmpty()
                    || cmboxTipoCirugia.getSelectedItem() == null || cmboxNombreDoctorCirugia.getSelectedItem() == null
                    || cmboxNombrePacuenteCirugia.getSelectedItem() == null) {

                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos antes de continuar");
                return;
            }

            if (cmboxEspecialidadCirugia.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Asegurese de que existe una especialidad registrada antes de continuar");
                return;
            }

            String tipoCirugia = cmboxTipoCirugia.getSelectedItem().toString();
            if (tipoCirugia.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Asegurese de que existe un tipo de cirugia registrado antes de continuar");
                return;
            }

            String nombreDoctor = cmboxNombreDoctorCirugia.getSelectedItem().toString();
            if (nombreDoctor.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Asegurese de que existe un doctor registrado para la cirugia");
                return;
            }

            String fecha = txtFechaCirugia.getText();
            String hora = txtHoraCirugia.getText().toLowerCase();
            if (!(hora.contains("am") || hora.contains("pm")
                    || hora.contains("a.m") || hora.contains("p.m")
                    || hora.contains("a.m.") || hora.contains("p.m."))) {
                JOptionPane.showMessageDialog(this, "La hora debe contener 'am', 'pm', 'a.m.', 'p.m.' o alguna variante.");
                return;
            }

            int numQuirofano = Integer.parseInt(txtNumQuirofano.getText());
            String nombrePaciente = cmboxNombrePacuenteCirugia.getSelectedItem().toString();
            String tiempoDuracion = txtTiempoDuracion.getText();

            Cirugia cirugia = new Cirugia(fecha, hora, numQuirofano, tipoCirugia, nombreDoctor, nombrePaciente, tiempoDuracion);
            String mensaje = cirugia.agregarCirugia();

            JOptionPane.showMessageDialog(this, mensaje);
            limpiar();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El numero de quirofano debe ser un valor numerico");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.mostrarDatosCirugia();
    }//GEN-LAST:event_btnAgregarCiugiaActionPerformed

    private void btnLimpiarCirugiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCirugiaActionPerformed
        limpiar();
        btnAgregarCiugia.setEnabled(true);
        btnEditarCirugia.setEnabled(false);
        btnEliminarCirugia.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarCirugiaActionPerformed

    private void btnBuscarCirugiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCirugiaActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID de la cirugía a buscar:"));
        Conexion conexion = new Conexion();
        String datos[] = new String[8];
        try {
            String query = "SELECT * FROM Cirugias where id_cirugia = ?";
            PreparedStatement pstmt = conexion.conectar().prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
            }
            txtIDCirugia.setText(datos[0]);
            txtFechaCirugia.setText(datos[1]);
            txtHoraCirugia.setText(datos[2]);
            txtNumQuirofano.setText(datos[3]);
            cmboxTipoCirugia.setSelectedItem(datos[4]);
            cmboxNombreDoctorCirugia.setSelectedItem(datos[5]);
            cmboxNombrePacuenteCirugia.setSelectedItem(datos[6]);
            txtTiempoDuracion.setText(datos[7]);

            btnAgregarCiugia.setEnabled(false);
            btnEditarCirugia.setEnabled(true);
            btnEliminarCirugia.setEnabled(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la información");
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar el ID ingresado");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        this.mostrarDatosCirugia();
    }//GEN-LAST:event_btnBuscarCirugiaActionPerformed

    private void btnEditarCirugiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCirugiaActionPerformed
        try {
            int id = Integer.parseInt(txtIDCirugia.getText());
            String fecha = txtFechaCirugia.getText();
            String hora = txtHoraCirugia.getText().toLowerCase();
            if (!(hora.contains("am") || hora.contains("pm")
                    || hora.contains("a.m") || hora.contains("p.m")
                    || hora.contains("a.m.") || hora.contains("p.m."))) {
                JOptionPane.showMessageDialog(this, "La hora debe contener 'am', 'pm', 'a.m.', 'p.m.' o alguna variante.");
                return;
            }
            int numQuirofano = Integer.parseInt(txtNumQuirofano.getText());
            String tipoCirugia = cmboxTipoCirugia.getSelectedItem().toString();
            String nombreDoctor = cmboxNombreDoctorCirugia.getSelectedItem().toString();
            String nombrePaciente = cmboxNombrePacuenteCirugia.getSelectedItem().toString();
            String tiempoDuracion = txtTiempoDuracion.getText();

            Cirugia cirugia = new Cirugia(id, fecha, hora, numQuirofano, tipoCirugia, nombreDoctor, nombrePaciente, tiempoDuracion);

            cirugia.editarCirugia();
            JOptionPane.showMessageDialog(this, "La información de la cirugía se actualizó exitosamente");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los IDs de quirófano, doctor y/o paciente deben ser valores numéricos");
        }
        this.mostrarDatosCirugia();
    }//GEN-LAST:event_btnEditarCirugiaActionPerformed

    private void btnEliminarCirugiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCirugiaActionPerformed
        int btn = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la cirugía seleccionada?", "Eliminar cirugía", JOptionPane.YES_NO_OPTION);
        if (btn == 0) {
            int id = Integer.parseInt(txtIDCirugia.getText());
            Cirugia cirugia = new Cirugia(id);
            String mensaje = cirugia.eliminarCirugia();
            JOptionPane.showMessageDialog(this, mensaje);
            limpiar();
        }
        this.mostrarDatosCirugia();
    }//GEN-LAST:event_btnEliminarCirugiaActionPerformed

    private void btnAgregarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPacienteActionPerformed
        try {
            int edad = Integer.parseInt(txtEdad.getText());
            double peso = Double.parseDouble(txtPeso.getText());
            double estatura = Double.parseDouble(txtEstatura.getText());
            String nombre = txtNombrePaciente.getText();

            if (edad < 0 || peso < 0 || estatura < 0) {
                JOptionPane.showMessageDialog(this, "La edad, peso, estatura y la identificación no pueden ser valores negativos.");
                return;
            }

            Paciente paciente = new Paciente(edad, peso, estatura, nombre);

            String mensaje = paciente.agregarUsuario();

            JOptionPane.showMessageDialog(this, mensaje);
            limpiar();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La identificación, estatura, edad y peso deben ser valores numéricos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.mostrarDatosPaciente();

    }//GEN-LAST:event_btnAgregarPacienteActionPerformed

    private void tbAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAgendaMouseClicked
        int fila = tbAgenda.getSelectedRow();
        txtIDCirugia.setText(tbAgenda.getValueAt(fila, 0).toString());
        txtFechaCirugia.setText(tbAgenda.getValueAt(fila, 1).toString());
        txtHoraCirugia.setText(tbAgenda.getValueAt(fila, 2).toString());
        txtNumQuirofano.setText(tbAgenda.getValueAt(fila, 3).toString());
        cmboxTipoCirugia.setSelectedItem(tbAgenda.getValueAt(fila, 4).toString());
        cmboxNombreDoctorCirugia.setSelectedItem(tbAgenda.getValueAt(fila, 5).toString());
        cmboxNombrePacuenteCirugia.setSelectedItem(tbAgenda.getValueAt(fila, 6).toString());
        txtTiempoDuracion.setText(tbAgenda.getValueAt(fila, 7).toString());

        btnAgregarCiugia.setEnabled(false);
        btnEditarCirugia.setEnabled(true);
        btnEliminarCirugia.setEnabled(true);
    }//GEN-LAST:event_tbAgendaMouseClicked

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del paciente a buscar:"));
        Conexion conexion = new Conexion();
        String datos[] = new String[5];
        try {
            String query = "SELECT * FROM Paciente where id_paciente = ?";
            PreparedStatement pstmt = conexion.conectar().prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            boolean encontrado = false;
            while (rs.next()) {
                encontrado = true;
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
            }
            if (encontrado) {
                txtEdad.setText(datos[0]);
                txtPeso.setText(datos[1]);
                txtEstatura.setText(datos[2]);
                txtIdentificacionPaciente.setText(datos[3]);
                txtNombrePaciente.setText(datos[4]);

                btnAgregarPaciente.setEnabled(false);
                btnEditarPaciente.setEnabled(true);
                btnEliminarPaciente.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar el ID ingresado");
            }
            btnAgregarPaciente.setEnabled(false);
            btnEditarPaciente.setEnabled(true);
            btnEliminarPaciente.setEnabled(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la información");
            System.out.println("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar el ID ingresado");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        this.mostrarDatosPaciente();
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void btnEditarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPacienteActionPerformed
        try {
            int edad = Integer.parseInt(txtEdad.getText());
            double peso = Double.parseDouble(txtPeso.getText());
            double estatura = Double.parseDouble(txtEstatura.getText());
            int id_paciente = Integer.parseInt(txtIdentificacionPaciente.getText());
            String nombre = txtNombrePaciente.getText();

            if (edad < 0 || peso < 0 || estatura < 0 || id_paciente < 0) {
                JOptionPane.showMessageDialog(this, "La edad, peso, estatura y la identificación no pueden ser valores negativos.");
                return;
            }
            Paciente paciente = new Paciente(edad, peso, estatura, id_paciente, nombre);
            paciente.actualizarUsuario();
            JOptionPane.showMessageDialog(this, "La información del paciente se actualizó exitosamente");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La identificación, estatura, edad y peso deben ser valores numéricos");
        }
        this.mostrarDatosPaciente();
    }//GEN-LAST:event_btnEditarPacienteActionPerformed

    private void btnEliminarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPacienteActionPerformed
        int btn = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el paciente seleccionado?", "Eliminar paciente", JOptionPane.YES_NO_OPTION);
        if (btn == 0) {
            int id = Integer.parseInt(txtIdentificacionPaciente.getText());
            Paciente paciente = new Paciente(id);
            String mensaje = paciente.eliminarUsuario();
            JOptionPane.showMessageDialog(this, mensaje);
            limpiar();
        }
        this.mostrarDatosPaciente();
    }//GEN-LAST:event_btnEliminarPacienteActionPerformed

    private void btnLimpiarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPacienteActionPerformed
        limpiar();
        btnAgregarPaciente.setEnabled(true);
        btnEditarPaciente.setEnabled(false);
        btnEliminarPaciente.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarPacienteActionPerformed

    private void tbPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPacientesMouseClicked
        int fila = tbPacientes.getSelectedRow();
        txtEdad.setText(tbPacientes.getValueAt(fila, 0).toString());
        txtPeso.setText(tbPacientes.getValueAt(fila, 1).toString());
        txtEstatura.setText(tbPacientes.getValueAt(fila, 2).toString());
        txtIdentificacionPaciente.setText(tbPacientes.getValueAt(fila, 3).toString());
        txtNombrePaciente.setText(tbPacientes.getValueAt(fila, 4).toString());

        btnAgregarPaciente.setEnabled(false);
        btnEditarPaciente.setEnabled(true);
        btnEliminarPaciente.setEnabled(true);
    }//GEN-LAST:event_tbPacientesMouseClicked

    private void btnAgregarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDoctorActionPerformed
        try {
            if (cmboxEspecialidadDoctor.getSelectedItem() != null && cboxJornada.getSelectedItem() != null) {
                String especialidad = cmboxEspecialidadDoctor.getSelectedItem().toString();
                String jornada = cboxJornada.getSelectedItem().toString();
                String nombre = txtNombreDoctor.getText();

                Doctor doctor = new Doctor(especialidad, jornada, nombre);
                String mensaje = doctor.agregarUsuario();

                JOptionPane.showMessageDialog(this, mensaje);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una especialidad previamente creada");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.mostrarDatosDoctor();
    }//GEN-LAST:event_btnAgregarDoctorActionPerformed

    private void btnBuscarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDoctorActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del doctor a buscar:"));
        Conexion conexion = new Conexion();
        String datos[] = new String[5];
        try {
            String query = "SELECT * FROM Doctor where id_doctor = ?";
            PreparedStatement pstmt = conexion.conectar().prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            boolean encontrado = false;
            while (rs.next()) {
                encontrado = true;
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
            }
            if (encontrado) {
                cmboxEspecialidadDoctor.setSelectedItem(datos[0]);
                cboxJornada.setSelectedItem(datos[1]);
                txtIdentificacionDoctor.setText(datos[2]);
                txtNombreDoctor.setText(datos[3]);

                btnAgregarDoctor.setEnabled(false);
                btnEditarDoctor.setEnabled(true);
                btnEliminarDoctror.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar el ID ingresado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la información");
            System.out.println("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar el ID ingresado");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        this.mostrarDatosDoctor();
    }//GEN-LAST:event_btnBuscarDoctorActionPerformed

    private void btnEditarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDoctorActionPerformed
        try {
            if (cmboxEspecialidadDoctor.getSelectedItem() != null && cboxJornada.getSelectedItem() != null) {
                String especialidad = cmboxEspecialidadDoctor.getSelectedItem().toString();
                String jornada = cboxJornada.getSelectedItem().toString();
                int id = Integer.parseInt(txtIdentificacionDoctor.getText());
                String nombre = txtNombreDoctor.getText();

                Doctor doctor = new Doctor(especialidad, jornada, id, nombre);
                doctor.actualizarUsuario();

                JOptionPane.showMessageDialog(this, "La informacion del doctor se actualizo correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una especialidad previamente creada");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.mostrarDatosDoctor();
    }//GEN-LAST:event_btnEditarDoctorActionPerformed

    private void btnEliminarDoctrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDoctrorActionPerformed
        int btn = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el doctor seleccionado?", "Eliminar doctor", JOptionPane.YES_NO_OPTION);
        if (btn == 0) {
            int id = Integer.parseInt(txtIdentificacionDoctor.getText());
            Doctor doctor = new Doctor(id);
            String mensaje = doctor.eliminarUsuario();
            JOptionPane.showMessageDialog(this, mensaje);
            limpiar();
        }
        this.mostrarDatosDoctor();
    }//GEN-LAST:event_btnEliminarDoctrorActionPerformed

    private void btnLimpiarDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarDoctorActionPerformed
        limpiar();
        btnAgregarDoctor.setEnabled(true);
        btnEditarDoctor.setEnabled(false);
        btnEliminarDoctror.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarDoctorActionPerformed

    private void tbDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDoctorMouseClicked
        int fila = tbDoctor.getSelectedRow();
        cmboxEspecialidadDoctor.setSelectedItem(tbDoctor.getValueAt(fila, 0).toString());
        cboxJornada.setSelectedItem(tbDoctor.getValueAt(fila, 1).toString());
        txtIdentificacionDoctor.setText(tbDoctor.getValueAt(fila, 2).toString());
        txtNombreDoctor.setText(tbDoctor.getValueAt(fila, 3).toString());

        btnAgregarDoctor.setEnabled(false);
        btnEditarDoctor.setEnabled(true);
        btnEliminarDoctror.setEnabled(true);
    }//GEN-LAST:event_tbDoctorMouseClicked

    private void tbTiposCirugiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTiposCirugiasMouseClicked
        int fila = tbTiposCirugias.getSelectedRow();
        txtIDTipoCirugia.setText(tbTiposCirugias.getValueAt(fila, 0).toString());
        txtTipoCirugia.setText(tbTiposCirugias.getValueAt(fila, 1).toString());
        txtNombreEspecialidad.setText(tbTiposCirugias.getValueAt(fila, 2).toString());

        btnAgregarTipoCirugia.setEnabled(false);
        btnEditarTipoCirugia.setEnabled(true);
        btnEliminarTipoCirugia.setEnabled(true);
    }//GEN-LAST:event_tbTiposCirugiasMouseClicked

    private void btnAgregarTipoCirugiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTipoCirugiaActionPerformed
        try {
            String tipoCirugia = txtTipoCirugia.getText();
            String especialidad = txtNombreEspecialidad.getText();

            tiposCirugia tipos = new tiposCirugia(tipoCirugia, especialidad);

            String mensaje = tipos.agregartipoCirugia();

            JOptionPane.showMessageDialog(this, mensaje);
            limpiar();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        this.mostrarDatosTipos();
    }//GEN-LAST:event_btnAgregarTipoCirugiaActionPerformed

    private void btnBuscarTipoCirugiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTipoCirugiaActionPerformed
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del tipo de cirugía a buscar:"));
        Conexion conexion = new Conexion();
        String datos[] = new String[3];
        try {
            String query = "SELECT * FROM tipos_cirugia where id_tipo = ?";
            PreparedStatement pstmt = conexion.conectar().prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            boolean encontrado = false;
            while (rs.next()) {
                encontrado = true;
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
            }
            if (encontrado) {
                txtIDTipoCirugia.setText(datos[0]);
                txtTipoCirugia.setText(datos[1]);
                txtNombreEspecialidad.setText(datos[2]);

                btnAgregarTipoCirugia.setEnabled(false);
                btnEditarTipoCirugia.setEnabled(true);
                btnEliminarTipoCirugia.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar el ID ingresado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la información");
            System.out.println("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar el ID ingresado");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        this.mostrarDatosTipos();
        btnAgregarCiugia.setEnabled(false);
    }//GEN-LAST:event_btnBuscarTipoCirugiaActionPerformed

    private void btnEditarTipoCirugiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTipoCirugiaActionPerformed
        try {
            int id = Integer.parseInt(txtIDTipoCirugia.getText());
            String tipoCirugia = txtTipoCirugia.getText();
            String especialidad = txtNombreEspecialidad.getText();

            tiposCirugia tipos = new tiposCirugia(id, tipoCirugia, especialidad);

            String mensaje = tipos.agregartipoCirugia();
            JOptionPane.showMessageDialog(this, mensaje);

            JOptionPane.showMessageDialog(this, "La información del doctor se actualizó exitosamente");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La identificación, estatura, edad y peso deben ser valores numéricos");
        }
        this.mostrarDatosTipos();
    }//GEN-LAST:event_btnEditarTipoCirugiaActionPerformed

    private void btnEliminarTipoCirugiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTipoCirugiaActionPerformed
        int btn = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el tipo de cirugía seleccionado?", "Eliminar tipo de cirugía", JOptionPane.YES_NO_OPTION);
        if (btn == 0) {
            int id = Integer.parseInt(txtIDTipoCirugia.getText());
            tiposCirugia tipos = new tiposCirugia(id);
            String mensaje = tipos.eliminarTipoCirugia();
            JOptionPane.showMessageDialog(this, mensaje);
            limpiar();
        }
        this.mostrarDatosTipos();
    }//GEN-LAST:event_btnEliminarTipoCirugiaActionPerformed

    private void btnLimpiarTipoCirugiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTipoCirugiaActionPerformed
        limpiar();
        btnAgregarTipoCirugia.setEnabled(true);
        btnEditarCirugia.setEnabled(false);
        btnEliminarCirugia.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarTipoCirugiaActionPerformed

    public void limpiar() {
        txtIDCirugia.setText("");
        txtFechaCirugia.setText("");
        txtHoraCirugia.setText("");
        txtNumQuirofano.setText("");
        txtTiempoDuracion.setText("");
        cmboxTipoCirugia.setSelectedItem("");
        cmboxNombreDoctorCirugia.setSelectedItem("");
        cmboxNombrePacuenteCirugia.setSelectedItem("");

        txtNombrePaciente.setText("");
        txtIdentificacionPaciente.setText("");
        txtEdad.setText("");
        txtPeso.setText("");
        txtEstatura.setText("");

        txtNombreDoctor.setText("");
        txtIdentificacionDoctor.setText("");
        cmboxEspecialidadDoctor.setSelectedItem("");
        cboxJornada.setSelectedItem("");

        txtIDTipoCirugia.setText("");
        txtTipoCirugia.setText("");
        txtNombreEspecialidad.setText("");
    }

    public void mostrarDatosCirugia() {
        tbAgenda.setModel(Cirugia.consultarCirugia());
    }

    public void mostrarDatosPaciente() {
        tbPacientes.setModel(Paciente.consultarPaciente());
    }

    public void mostrarDatosDoctor() {
        tbDoctor.setModel(Doctor.consultarDoctor());
    }

    public void mostrarDatosTipos() {
        tbTiposCirugias.setModel(tiposCirugia.consultarTipos());
    }

    private LocalTime parseHoraManual(String horaTexto) {
        try {
            horaTexto = horaTexto.toLowerCase()
                    .replace("a.m", "am")
                    .replace("p.m", "pm")
                    .replace(".", "")
                    .trim();

            String[] partes = horaTexto.split(" ");
            if (partes.length != 2) {
                return null;
            }

            String tiempo = partes[0];
            String meridiano = partes[1];

            String[] horaMinuto = tiempo.split(":");
            int hora = Integer.parseInt(horaMinuto[0]);
            int minuto = (horaMinuto.length > 1) ? Integer.parseInt(horaMinuto[1]) : 0;

            if (meridiano.equals("pm") && hora != 12) {
                hora += 12;
            }
            if (meridiano.equals("am") && hora == 12) {
                hora = 0;
            }

            return LocalTime.of(hora, minuto);
        } catch (Exception e) {
            System.out.println("Fallo en parseo manual: " + e.getMessage());
            return null;
        }
    }

    private void verificarCirugias() {
        LocalTime horaActual = LocalTime.now().withSecond(0).withNano(0);
        String fecha = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Conexion conexion = new Conexion();
        System.out.println("Verificación de cirugías a las " + horaActual);

        try {
            String query = "SELECT nombrePaciente, hora, tiempo_duracion FROM Cirugias WHERE fecha = ?";
            PreparedStatement pstmt = conexion.conectar().prepareStatement(query);
            pstmt.setString(1, fecha);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nombrePaciente = rs.getString("nombrepaciente");
                String horaTexto = rs.getString("hora")
                        .toLowerCase()
                        .replace("a.m", "am")
                        .replace("p.m", "pm")
                        .replace(".", "")
                        .replaceAll("[\\s\\u00A0\\u2007\\u202F]+", " ")
                        .trim();
                int duracion = rs.getInt("tiempo_duracion");

                System.out.println("id del Paciente: " + nombrePaciente + " | hora: " + horaTexto);
                char dosPuntos = horaTexto.charAt(2);
                System.out.println("Carácter en posición 2: '" + dosPuntos + "' → código: " + (int) dosPuntos);

                try {
                    LocalTime horaCirugia = parseHoraManual(horaTexto);

                    long diferencia = ChronoUnit.MINUTES.between(horaCirugia, horaActual);
                    System.out.println("Diferencia en minutos: " + diferencia);

                    if (Math.abs(diferencia) == 0) {
                        System.out.println("Se procede con la ejecución de cirugía al paciente " + nombrePaciente);
                        // String nombrePaciente = obtenerNombrePacientePorID(conexion, idPaciente);
                        System.out.println(nombrePaciente);
                        if (nombrePaciente != null) {
                            new Thread(() -> {
                                Procedimiento proceso = new Procedimiento(this, duracion, nombrePaciente);
                                proceso.setVisible(true);
                            }).start();
                        }
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("No se pudo interpretar la hora: '" + horaTexto + "' " + e.getMessage());
                }
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al verificar cirugías: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error en la recuperación de datos: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    private void cargarDoctoresPorEspecialidad(String especialidad) {
        cmboxNombreDoctorCirugia.removeAllItems();
        Conexion conexion = new Conexion();
        ArrayList<String> doctores = new ArrayList<>();
        cmboxNombreDoctorCirugia.setEnabled(true);
        try {
            String query = "SELECT nombre FROM Doctor where especialidad = ?";
            PreparedStatement pstmt = conexion.conectar().prepareStatement(query);
            pstmt.setString(1, especialidad);
            ResultSet rs = pstmt.executeQuery();
            boolean encontrado = false;
            while (rs.next()) {
                encontrado = true;
                doctores.add(rs.getString("nombre"));
            }
            if (encontrado) {
                for (String doc : doctores) {
                    cmboxNombreDoctorCirugia.addItem(doc);

                }
            } else {
                cmboxNombreDoctorCirugia.setEnabled(false);
                txtMensaje.setText("No existen doctores registrados para esta especialidad");
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    private void cargarPacientes() {
        cmboxNombrePacuenteCirugia.removeAllItems();
        Conexion conexion = new Conexion();
        ArrayList<String> pacientes = new ArrayList<>();
        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nombre FROM Paciente");
            boolean encontrado = false;
            while (rs.next()) {
                encontrado = true;
                pacientes.add(rs.getString("nombre"));
            }
            if (encontrado == true) {
                for (String paciente : pacientes) {
                    cmboxNombrePacuenteCirugia.addItem(paciente);
                }
            } else {
                cmboxNombrePacuenteCirugia.setEnabled(false);
                txtMensaje.setText("No existen pacientes registrados");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la información del doctor");
            System.out.println("Error: " + ex.getMessage());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede establacer conexión con la base de datos.");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    private void cargarEspecialidades() {
        cmboxEspecialidadCirugia.removeAllItems();
        Set<String> especialidades = new HashSet<>();
        Conexion conexion = new Conexion();
        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ESPECIALIDAD FROM TIPOS_CIRUGIA");
            while (rs.next()) {
                especialidades.add(rs.getString("especialidad"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la información de la especialidad");
            System.out.println("Error: " + ex.getMessage());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede establacer conexión con la base de datos.");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        for (String especialidad : especialidades) {
            cmboxEspecialidadCirugia.addItem(especialidad);
            cmboxEspecialidadDoctor.addItem(especialidad);
        }
    }

    private void cargarTiposPorEspecialidad(String especialidad) {
        cmboxTipoCirugia.removeAllItems();
        Conexion conexion = new Conexion();
        ArrayList<String> cirugias = new ArrayList<>();
        try {
            String query = "SELECT tipo_cirugia FROM tipos_cirugia where especialidad = ?";
            PreparedStatement pstmt = conexion.conectar().prepareStatement(query);
            pstmt.setString(1, especialidad);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cirugias.add(rs.getString("tipo_cirugia"));
            }

            for (String tipo : cirugias) {
                cmboxTipoCirugia.addItem(tipo);
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
    }

    public PanelEntrada panelEntrada;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCiugia;
    private javax.swing.JButton btnAgregarDoctor;
    private javax.swing.JButton btnAgregarPaciente;
    private javax.swing.JButton btnAgregarTipoCirugia;
    private javax.swing.JButton btnBuscarCirugia;
    private javax.swing.JButton btnBuscarDoctor;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnBuscarTipoCirugia;
    private javax.swing.JButton btnEditarCirugia;
    private javax.swing.JButton btnEditarDoctor;
    private javax.swing.JButton btnEditarPaciente;
    private javax.swing.JButton btnEditarTipoCirugia;
    private javax.swing.JButton btnEliminarCirugia;
    private javax.swing.JButton btnEliminarDoctror;
    private javax.swing.JButton btnEliminarPaciente;
    private javax.swing.JButton btnEliminarTipoCirugia;
    private javax.swing.JButton btnLimpiarCirugia;
    private javax.swing.JButton btnLimpiarDoctor;
    private javax.swing.JButton btnLimpiarPaciente;
    private javax.swing.JButton btnLimpiarTipoCirugia;
    private javax.swing.JComboBox<String> cboxJornada;
    private javax.swing.JComboBox<String> cmboxEspecialidadCirugia;
    private javax.swing.JComboBox<String> cmboxEspecialidadDoctor;
    private javax.swing.JComboBox<String> cmboxNombreDoctorCirugia;
    private javax.swing.JComboBox<String> cmboxNombrePacuenteCirugia;
    private javax.swing.JComboBox<String> cmboxTipoCirugia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbAgenda;
    private javax.swing.JTable tbDoctor;
    private javax.swing.JTable tbPacientes;
    private javax.swing.JTable tbTiposCirugias;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEstatura;
    private javax.swing.JTextField txtFechaCirugia;
    private javax.swing.JTextField txtHoraCirugia;
    private javax.swing.JTextField txtIDCirugia;
    private javax.swing.JTextField txtIDTipoCirugia;
    private javax.swing.JTextField txtIdentificacionDoctor;
    private javax.swing.JTextField txtIdentificacionPaciente;
    private javax.swing.JLabel txtMensaje;
    private javax.swing.JTextField txtNombreDoctor;
    private javax.swing.JTextField txtNombreEspecialidad;
    private javax.swing.JTextField txtNombrePaciente;
    private javax.swing.JTextField txtNumQuirofano;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtTiempoDuracion;
    private javax.swing.JTextField txtTipoCirugia;
    // End of variables declaration//GEN-END:variables
}
