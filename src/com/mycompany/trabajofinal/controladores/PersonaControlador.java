/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajofinal.controladores;

import com.mycompany.trabajofinal.objetos.Persona;
import com.mycompany.trabajofinal.objetos.Persona;
import com.mycompany.trabajofinal.util.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
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
public class PersonaControlador {
    Persona persona;
    Connection conexion;  
    DefaultTableModel modelo;
    PreparedStatement pst; 
    ResultSet rs; 
    ResultSetMetaData rsm;
    private Statement stmt;
    
    private String sql;
    
    public PersonaControlador() throws SQLException, ClassNotFoundException{
    persona = new Persona();
    conexion = Conexion.obtenerConexion();
    modelo= new DefaultTableModel();
    }

    
    public void llenarTablaPersona (JTable tabla) throws SQLException{
    DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("nombre");
        modelo2.addColumn("apellido");
        modelo2.addColumn("documento");
        modelo2.addColumn("fecha nacimiento");
        modelo2.addColumn("sexo");
        
           
        tabla.setModel(modelo2);
        
        String consulta = "SELECT * FROM public.\"Personas\"";
        
        pst = conexion.prepareStatement(consulta);    
        rs = pst.executeQuery();
        rsm=rs.getMetaData();
        
        while (rs.next()){
            Object[] fila = new Object[rsm.getColumnCount()];
            
            fila[0] = rs.getInt(1);
            fila[1] = rs.getString(2);
            fila[2] = rs.getString(3);
            fila[3] = rs.getInt(4);
            fila[4] = rs.getDate(5);
            fila[5] = rs.getString(6);
            
            modelo2.addRow(fila);
        }}

   public void insertarPersona (Persona persona, JTable tabla){
                
        try {
       
        String cadena = "INSERT INTO Public.\"Personas\"(nombre, apellido, documento, fecha_nacimiento, sexo)\n" +
                        "values (?,?,?,?,?)"; 
        
        pst = conexion.prepareStatement(cadena);
        pst.setString(1, persona.getNombre());
        pst.setString(2, persona.getApellido());
        pst.setInt(3,persona.getDocumento());
        pst.setDate(4, (Date) persona.getFecha_nacimiento());
        pst.setString(5,persona.getSexo());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            
        llenarTablaPersona(tabla);
        
        } catch (SQLException | HeadlessException e) {  
            System.out.println("Error. No se pudo registrar");
            JOptionPane.showMessageDialog(null, "No se puede registrar una persona con el mismo código");
        }   
    }
   
       public void eliminarPersona(Persona persona,JTable tabla){  
            try {    
                
                String consulta = "DELETE FROM Public.\"Personas\"\n" +
" WHERE Public.\"Personas\".id_persona= ?";
                pst = conexion.prepareStatement(consulta);
                pst.setInt(1, persona.getId_persona());                   
                pst.execute();
                
                llenarTablaPersona(tabla);
                JOptionPane.showMessageDialog(null, "Éxito al eliminar");
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

}
