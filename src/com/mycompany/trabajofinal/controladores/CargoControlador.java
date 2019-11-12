/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajofinal.controladores;

import com.mycompany.trabajofinal.objetos.Cargo;
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
public class CargoControlador {
    Cargo cargo;
    Connection conexion;  
    DefaultTableModel modelo;
    PreparedStatement pst; 
    ResultSet rs; 
    ResultSetMetaData rsm;
    private Statement stmt;
    
    private String sql;
    
    public CargoControlador() throws SQLException, ClassNotFoundException{
    cargo = new Cargo();
    conexion = Conexion.obtenerConexion();
    modelo= new DefaultTableModel();
    }

    
    public void llenarTablaCargo (JTable tabla) throws SQLException{
    DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("id");
        modelo2.addColumn("codigo");
        modelo2.addColumn("descripcion");
        
           
        tabla.setModel(modelo2);
        
        String consulta = "SELECT * FROM public.\"Cargos\"";
        
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

   public void insertarCargo (Cargo cargo, JTable tabla){
                
        try {
       
        String cadena = "INSERT INTO Public.\"Cargos\"(codigo,descripcion)\n" +
                        "values (?,?)"; 
        
        pst = conexion.prepareStatement(cadena);
        pst.setInt(1, cargo.getCodigo());
        pst.setString(2, cargo.getDescripcion());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            
        llenarTablaCargo(tabla);
        
        } catch (SQLException | HeadlessException e) {  
            System.out.println("Error. No se pudo registrar");
            JOptionPane.showMessageDialog(null, "No se puede registrar un cargo con el mismo código");
        }   
    }
   
       public void eliminarCargo(Cargo cargo,JTable tabla){  
            try {    
                
                String consulta = "DELETE FROM Public.\"Cargos\"\n" +
" WHERE Public.\"Cargos\".id_cargo= ?";
                pst = conexion.prepareStatement(consulta);
                pst.setInt(1, cargo.getId_cargo());                   
                pst.execute();
                
                llenarTablaCargo(tabla);
                JOptionPane.showMessageDialog(null, "Éxito al eliminar");
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

}
