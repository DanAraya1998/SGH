package com.mycompany.proyecto_final;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Paciente extends Persona {
    int edad;
    double peso;
    double estatura;

    //Constructor para actualizar
    public Paciente(int edad, double peso, double estatura, int identificacion, String nombre) {
        super(identificacion, nombre);
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
    }
    
    //Constructor para agregar
    public Paciente(int edad, double peso, double estatura, String nombre) {
        super(nombre);
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
    }
    //Constructor para eliminar
    public Paciente(int identificacion) {
        super(identificacion);
    }
    
    public static DefaultTableModel consultarPaciente() {
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("Edad");
        modelo.addColumn("Peso");
        modelo.addColumn("Estatura (en centímetros)");
        modelo.addColumn("Identificación");
        modelo.addColumn("Nombre");
        String datos[] = new String[5];
        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Paciente");
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la información del paciente");
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
        String query = "insert into PACIENTE(edad, peso, estatura, nombre) VALUES(?,?,?,?)";
        try {
            CallableStatement cs = conexion.conectar().prepareCall(query);
            cs.setInt(1, this.edad);
            cs.setDouble(2, this.peso);
            cs.setDouble(3, this.estatura);
            cs.setString(4, super.getNombre());
            cs.execute();
            return "Información de paciente agregada exitosamente";
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return "No se pudo agregar la información del paciente";
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return "No se puede establecer la conexión con la base de datos";
        } 
    }

    @Override
    public String eliminarUsuario() {
        Conexion conexion = new Conexion();
        String query = "DELETE FROM PACIENTE WHERE id_paciente = ?;";
        try {
            CallableStatement cs = conexion.conectar().prepareCall(query);
            cs.setInt(1, super.getIdentificacion());
            cs.execute();
            return "Información de paciente eliminada exitosamente";
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return "No se pudo la información del paciente";
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return "No se puede establecer la conexión con la base de datos";
        }
    }

    @Override
    public String buscarUsuario() {
        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM Paciente WHERE id_paciente = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);
            cs.setInt(1, super.getIdentificacion());
            cs.execute();
            return "La información del paciente se ha encontrado con éxito.";
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo encontrar el paciente";
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
                       UPDATE PACIENTE SET
                       edad = ?,
                       peso = ?,
                       estatura = ?,
                       nombre = ?
                       WHERE id_paciente = ?;
                       """;
        try {
            CallableStatement cs = conexion.conectar().prepareCall(query);
            cs.setInt(1, this.edad);
            cs.setDouble(2, this.peso);
            cs.setDouble(3, this.estatura);
            cs.setString(4, super.getNombre());
            cs.setInt(5, super.getIdentificacion());
            cs.execute();
            return "Información de paciente actualizada exitosamente";
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return "No se pudo actualizar la información del paciente";
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return "No se puede establecer la conexión con la base de datos";
        }
    }
    
    
}
