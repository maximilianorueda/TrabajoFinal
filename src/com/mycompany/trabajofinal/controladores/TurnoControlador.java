/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajofinal.controladores;

import com.mycompany.trabajofinal.objetos.Cargo;
import com.mycompany.trabajofinal.objetos.Turno;
import com.mycompany.trabajofinal.util.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Hugo Chanampe
 */
public class TurnoControlador {
    Turno turno;
    Connection conexion;  
    DefaultTableModel modelo;
    PreparedStatement pst; 
    ResultSet rs; 
    ResultSetMetaData rsm;
    private Statement stmt;
    private String sql;
    
    public TurnoControlador() throws SQLException, ClassNotFoundException{
    turno = new Turno();
    conexion = Conexion.obtenerConexion();
    modelo= new DefaultTableModel();
    }

    
    public void llenarTablaTurno (JTable tabla) throws SQLException{
    DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("id");
        modelo2.addColumn("codigo");
        modelo2.addColumn("descripcion");
        
           
        tabla.setModel(modelo2);
        
        String consulta = "SELECT * FROM public.\"Turnos\"";
        
        pst = conexion.prepareStatement(consulta);    
        rs = pst.executeQuery();
        rsm=rs.getMetaData();
        
        while (rs.next()){
            Object[] fila = new Object[rsm.getColumnCount()];
            fila[0] = rs.getInt(1); //id
            fila[1] = rs.getInt(2);
            fila[2] = rs.getString(3);
            
            modelo2.addRow(fila);
        }}

   public void insertarTurno (Turno turno, JTable tabla){
                
        try {
       
        String cadena = "INSERT INTO Public.\"Turnos\"(codigo,descripcion)\n" +
                        "values (?,?)"; 
        
        pst = conexion.prepareStatement(cadena);
        pst.setInt(1, turno.getCodigo());
        pst.setString(2, turno.getDescripcion());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            
        llenarTablaTurno(tabla);
        
        } catch (SQLException | HeadlessException e) {  
            System.out.println("Error. No se pudo registrar");
            JOptionPane.showMessageDialog(null, "No se puede registrar un turno con el mismo código");
        }   
    }
   
       public void eliminarTurno(Turno turno,JTable tabla){  
            try {    
                
                String consulta = "DELETE FROM Public.\"Turnos\"\n" +
" WHERE Public.\"Turnos\".id_turno= ?";
                pst = conexion.prepareStatement(consulta);
                pst.setInt(1, turno.getId_turno());                   
                pst.execute();
                
                llenarTablaTurno(tabla);
                JOptionPane.showMessageDialog(null, "Éxito al eliminar");
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

}
