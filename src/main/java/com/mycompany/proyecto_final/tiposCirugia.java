package com.mycompany.proyecto_final;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class tiposCirugia {
    private int id;
    private String tipoCirugia;
    private String especialidad;

    public tiposCirugia(String tipoCirugia, String especialidad) {
        this.tipoCirugia = tipoCirugia;
        this.especialidad = especialidad;
    }

    public tiposCirugia(int id, String tipoCirugia, String especialidad) {
        this.id = id;
        this.tipoCirugia = tipoCirugia;
        this.especialidad = especialidad;
    }

    public tiposCirugia(int id) {
        this.id = id;
    }
    
    public static DefaultTableModel consultarTipos() {
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("Tipo de cirugía");
        modelo.addColumn("Especialidad");
        String datos[] = new String[3];
        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tipos_cirugia");
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la información de los tipos de cirugías");
            System.out.println("Error: " + ex.getMessage());
       
     } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede establacer conexión con la base de datos.");
            System.out.println("Error: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }

        return modelo;
    }
    
    public String agregartipoCirugia() {
        Conexion conexion = new Conexion();
        String query = "insert into tipos_cirugia(tipo_cirugia, especialidad) VALUES(?,?)";
        try {
            CallableStatement cs = conexion.conectar().prepareCall(query);
            cs.setString(1, this.tipoCirugia);
            cs.setString(2, this.especialidad);
            cs.execute();
            return "Información del tipo de cirugía agregada exitosamente";
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return "No se pudo agregar la información del tipo de cirugía";
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return "No se puede establecer la conexión con la base de datos";
        }
    }
    
    public String eliminarTipoCirugia() {
        Conexion conexion = new Conexion();
        String query = "DELETE FROM tipos_cirugia WHERE id_tipo = ?;";
        try {
            CallableStatement cs = conexion.conectar().prepareCall(query);
            cs.setInt(1, this.id);
            cs.execute();
            return "Información del tipo cirugía eliminada exitosamente";
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return "No se pudo la información del tipo de cirugía";
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return "No se puede establecer la conexión con la base de datos";
        }
    }
    
    public String buscarTipoCirugia() {
        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM tipos_cirugia WHERE id_tipo = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);
            cs.setInt(1, this.id);
            cs.execute();
            return "La información del tipo de cirugía se ha encontrado con éxito.";
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo encontrar el dtipo de cirugía";
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return "No se pudo establecer la conexión con la base de datos.";
        } finally {
            conexion.desconectar();
        }
    }
    
    public String actualizarTipoCirugia() {
        Conexion conexion = new Conexion();
        String query = """
                       UPDATE tipos_cirugia SET
                       tipo_cirugia = ?,
                       especialidad = ?
                       WHERE id_tipo = ?;
                       """;
        try {
            CallableStatement cs = conexion.conectar().prepareCall(query);
            cs.setString(1, this.tipoCirugia);
            cs.setString(2, this.especialidad);
            cs.setInt(3, this.id);
            cs.execute();
            return "Información del tipo de cirugía actualizada exitosamente";
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            return "No se pudo actualizar la información del tipo de cirugía";
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return "No se puede establecer la conexión con la base de datos";
        }
    }
}
