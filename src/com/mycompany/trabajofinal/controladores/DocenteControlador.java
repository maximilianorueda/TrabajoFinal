package com.mycompany.trabajofinal.controladores;

import com.mycompany.trabajofinal.objetos.Cargo;
import com.mycompany.trabajofinal.objetos.Docente;
import com.mycompany.trabajofinal.objetos.Persona;
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



public class DocenteControlador {
    Docente docente;
    Connection conexion;  
    DefaultTableModel modelo;
    PreparedStatement pst; 
    ResultSet rs; 
    ResultSetMetaData rsm;
    private Statement stmt;
    private String sql;
    
    public DocenteControlador() throws SQLException, ClassNotFoundException{
    docente = new Docente();
    conexion = Conexion.obtenerConexion();
    modelo= new DefaultTableModel();
    }

    
    public void llenarTablaDocente (JTable tabla) throws SQLException{
    DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("id");
        modelo2.addColumn("legajo");
        modelo2.addColumn("nombre");
        modelo2.addColumn("apellido");
        modelo2.addColumn("documento");
        modelo2.addColumn("cargo");
        

        
           
        tabla.setModel(modelo2);
        
        String consulta = "SELECT d.id_docente, d.legajo, p.nombre, p.apellido, p.documento, c.descripcion\n" +
"FROM Public.\"Docentes\" d\n" +
"INNER JOIN Public.\"Personas\" p ON d.id_persona = p.id_persona\n" +
"INNER JOIN Public.\"Cargos\" c ON d.id_cargo = c.id_cargo";
        
        pst = conexion.prepareStatement(consulta);    
        rs = pst.executeQuery();
        rsm=rs.getMetaData();
        
        while (rs.next()){
            Object[] fila = new Object[rsm.getColumnCount()];
            fila[0] = rs.getInt(1); //id
            fila[1] = rs.getInt(2);
            fila[2] = rs.getString(3);
            fila[3] = rs.getString(4);
            fila[4] = rs.getInt(5);
            fila[5] = rs.getString(6);
            
            modelo2.addRow(fila);
        }}
    
    
public ArrayList<Persona> llenarComboPersona() throws SQLException {
        ArrayList<Persona> personas = new ArrayList<>();
        String consulta = "SELECT p.nombre, p.apellido, p.documento\n" +
"FROM Public.\"Personas\" p";
        pst = conexion.prepareStatement(consulta);
        ResultSet rs = null;
        rs = pst.executeQuery();

        while (rs.next()) {
            Persona persona = new Persona();
            persona.setNombre(rs.getString(1));
            persona.setApellido(rs.getString(2));
            persona.setDocumento(rs.getInt(3));
            
            personas.add(persona);
        }
        rs.close();

        return personas;
    }

public ArrayList<Cargo> llenarComboCargo() throws SQLException {
        ArrayList<Cargo> cargos = new ArrayList<>();
        String consulta = "SELECT c.codigo, c.descripcion\n" +
"FROM Public.\"Cargos\" c";
        pst = conexion.prepareStatement(consulta);
        ResultSet rs = null;
        rs = pst.executeQuery();

        while (rs.next()) {
            Cargo cargo = new Cargo();
            cargo.setCodigo(rs.getInt(1));
            cargo.setDescripcion(rs.getString(2));
                    
            cargos.add(cargo);
        }
        rs.close();

        return cargos;
    }
   public void insertarDocente (Docente docente,Persona persona, Cargo cargo, JTable tabla){
                
        try {
       
        String cadena = "INSERT INTO Public.\"Docentes\"(legajo,id_persona,id_cargo)\n" +
                        "values (?,?,?)"; 
        
        pst = conexion.prepareStatement(cadena);
        pst.setInt(1, docente.getLegajo());
        pst.setObject(2, persona.getId_persona());
        pst.setObject(3, cargo.getId_cargo());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            
        llenarTablaDocente(tabla);
        
        } catch (SQLException | HeadlessException e) {  
            System.out.println("Error. No se pudo registrar");
            JOptionPane.showMessageDialog(null, "No se puede registrar un docente con el mismo legajo");
        }   
    }
   
       public void eliminarDocente(Docente docente,JTable tabla){  
            try {    
                
                String consulta = "DELETE FROM Public.\"Docentes\"\n" +
" WHERE Public.\"Docentes\".id_docente= ?";
                pst = conexion.prepareStatement(consulta);
                pst.setInt(1, docente.getId_docente());                   
                pst.execute();
                
                llenarTablaDocente(tabla);
                JOptionPane.showMessageDialog(null, "Éxito al eliminar");
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

}
