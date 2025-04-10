package com.mycompany.proyecto_final;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cirugia {
    private int id_cirugia;
    private String fecha;
    private String hora;
    private int numeroQuirofano;
    private String tipoCirugia; 
    private String nombreDoctor;
    private String nombrePaciente;
    private String tiempo_duracion;
    
    //Constructor para Agregar
    public Cirugia(String fecha, String hora, int numeroQuirofano, String tipoCirugia, String nombreDoctor, String nombrePaciente, String tiempo_duracion) {    
        this.fecha = fecha;
        this.hora = hora;
        this.numeroQuirofano = numeroQuirofano;
        this.tipoCirugia = tipoCirugia;
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
        this.tiempo_duracion = tiempo_duracion;
    }

    //Constructor para editar
    public Cirugia(int id_cirugia, String fecha, String hora, int numeroQuirofano, String tipoCirugia, String nombreDoctor, String nombrePaciente, String tiempo_duracion) {    
        this.id_cirugia = id_cirugia;
        this.fecha = fecha;
        this.hora = hora;
        this.numeroQuirofano = numeroQuirofano;
        this.tipoCirugia = tipoCirugia;
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
        this.tiempo_duracion = tiempo_duracion;
    }

    //Constructor para Eliminar
    public Cirugia(int id_cirugia) {
        this.id_cirugia = id_cirugia;
    }
    

    //metodos del CRUD
    public static DefaultTableModel consultarCirugia() {
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("ID cirugía");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Quirófano");
        modelo.addColumn("Tipo de cirugía");
        modelo.addColumn("Doctor");
        modelo.addColumn("Paciente");
        modelo.addColumn("Duración");

        ArrayList<String[]> datos = new ArrayList<>(); 
        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cirugias");

            while (rs.next()) {
                String fila[] = new String[8];
                for (int i = 0; i < 8; i++) {
                    fila[i]  = rs.getString(i+1);
                }
                datos.add(fila);
            }
            for (String[] fila:datos){
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo agendar correctamente.");
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion con la base de datos.");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        return modelo;
    }
    
    public String agregarCirugia() {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO cirugias (fecha, hora, numQuirofano, tipo_Cirugia, nombreDoctor, nombrePaciente, tiempo_duracion)" + "VALUES (?, ?, ?, ?, ?,?,?)";
        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);
            cs.setString(1, this.fecha);
            cs.setString(2, this.hora);
            cs.setInt(3, this.numeroQuirofano);
            cs.setString(4, this.tipoCirugia);
            cs.setString(5, this.nombreDoctor);
            cs.setString(6, this.nombrePaciente);
            cs.setString(7, this.tiempo_duracion);
            cs.execute();
            return "Cirugía agendada con éxito.";
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo agendar la cirugía.";
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo establecer la conexión con la base de datos.";
        } finally {
            conexion.desconectar();
        }
    }

    public String buscarCirugia() {
        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM cirugias WHERE id_cirugia = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);
            cs.setInt(1, this.id_cirugia);
            cs.execute();
            return "Cirugía encontrada con éxito.";
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo encontrar la cirugía.";
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo establecer la conexión con la base de datos.";
        } finally {
            conexion.desconectar();
        }
    }

    public String editarCirugia() {
        Conexion conexion = new Conexion();
        String sql = """
                     UPDATE cirugias SET
                     fecha = ?,
                     hora = ?,
                     numQuirofano = ?,
                     tipo_Cirugia = ?,
                     nombreDoctor = ?,
                     nombrePaciente = ?,
                     tiempo_duracion = ?
                     WHERE id_cirugia = ?;
                     """;
        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);
            cs.setString(1, this.fecha);
            cs.setString(2, this.hora);
            cs.setInt(3, this.numeroQuirofano);
            cs.setString(4, this.tipoCirugia);
            cs.setString(5, this.nombreDoctor);
            cs.setString(6, this.nombrePaciente);
            cs.setString(7, this.tiempo_duracion);
            cs.setInt(8, this.id_cirugia);
            cs.execute();
            return "Cirugía actualizada con éxito.";
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo actualizar la cirugía.";
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo establecer la conexion con la base de datos.";
        } finally {
            conexion.desconectar();
        }
    }

    public String eliminarCirugia() {
        Conexion conexion = new Conexion();
        String sql = "DELETE FROM cirugias WHERE id_cirugia = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);
            cs.setInt(1, this.id_cirugia);
            cs.execute();
            return "Cirugía eliminada con éxito.";
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo eliminar la cirugía.";
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo establecer la conexión con la base de datos.";
        } finally {
            conexion.desconectar();
        }
    }

    //Getter y Setter

    public int getId_cirugia() {
        return id_cirugia;
    }

    public void setId_cirugia(int id_cirugia) {
        this.id_cirugia = id_cirugia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getNumeroQuirofano() {
        return numeroQuirofano;
    }

    public void setNumeroQuirofano(int numeroQuirofano) {
        this.numeroQuirofano = numeroQuirofano;
    }

    public String getTipoCirugia() {
        return tipoCirugia;
    }

    public void setTipoCirugia(String tipoCirugia) {
        this.tipoCirugia = tipoCirugia;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getTiempo_duracion() {
        return tiempo_duracion;
    }

    public void setTiempo_duracion(String tiempo_duracion) {
        this.tiempo_duracion = tiempo_duracion;
    }
    
    
    
}
