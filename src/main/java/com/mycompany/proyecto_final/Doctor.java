package com.mycompany.proyecto_final;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Doctor extends Persona {
    private String especialidad;
    private String jornada;

    
    //Constructor para actualizar
    public Doctor(String especialidad, String jornada, int identificacion, String nombre) {
        super(identificacion, nombre);
        this.especialidad = especialidad;
        this.jornada = jornada;
    }
    
   //Constructor para agregar
    public Doctor(String especialidad, String jornada, String nombre) {
        super(nombre);
        this.especialidad = especialidad;
        this.jornada = jornada;
    }
    
    //Constructor para eliminar

    public Doctor(int identificacion) {
        super(identificacion);
    }
    

    //Métodos CRUDS para doctor
    
    public static DefaultTableModel consultarDoctor() {
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("Especialidad");
        modelo.addColumn("Jornada");
        modelo.addColumn("Identificación");
        modelo.addColumn("Nombre");
        String datos[] = new String[4];
        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Doctor");
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                modelo.addRow(datos);
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

        return modelo;
    }
    
    @Override
    public String agregarUsuario() {
        Conexion conexion = new Conexion();
        String query = "insert into DOCTOR(especialidad, jornada, nombre) VALUES(?,?,?)";
        try {
            CallableStatement cs = conexion.conectar().prepareCall(query);
            cs.setString(1, this.especialidad);
            cs.setString(2, this.jornada);
            cs.setString(3, super.getNombre());
            cs.execute();
            return "Información de doctor agregada exitosamente";
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return "No se pudo agregar la información del doctor";
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return "No se puede establecer la conexión con la base de datos";
        }
    }

    @Override
    public String eliminarUsuario() {
        Conexion conexion = new Conexion();
        String query = "DELETE FROM DOCTOR WHERE id_doctor = ?;";
        try {
            CallableStatement cs = conexion.conectar().prepareCall(query);
            cs.setInt(1, super.getIdentificacion());
            cs.execute();
            return "Información de doctor eliminada exitosamente";
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return "No se pudo la información del doctor";
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return "No se puede establecer la conexión con la base de datos";
        }
    }

    @Override
    public String buscarUsuario() {
        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM Doctor WHERE id_doctor = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);
            cs.setInt(1, super.getIdentificacion());
            cs.execute();
            return "La información del doctor se ha encontrado con éxito.";
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo encontrar el doctor";
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo establecer la conexión con la base de datos.";
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public String actualizarUsuario() {
        Conexion conexion = new Conexion();
        String query = """
                       UPDATE doctor SET
                       especialidad = ?,
                       jornada = ?,
                       nombre = ?
                       WHERE id_doctor = ?;
                       """;
        try {
            CallableStatement cs = conexion.conectar().prepareCall(query);
            cs.setString(1, this.especialidad);
            cs.setString(2, this.jornada);
            cs.setString(3, super.getNombre());
            cs.setInt(4, super.getIdentificacion());
            cs.execute();
            return "Información de doctor actualizada exitosamente";
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return "No se pudo actualizar la información del doctor";
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return "No se puede establecer la conexión con la base de datos";
        }
    }

    
    
}
