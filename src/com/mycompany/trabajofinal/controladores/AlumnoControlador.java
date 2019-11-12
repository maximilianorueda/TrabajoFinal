package com.mycompany.trabajofinal.controladores;

import com.mycompany.trabajofinal.objetos.Cargo;
import com.mycompany.trabajofinal.objetos.Alumno;
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



public class AlumnoControlador {
    Alumno alumno;
    Connection conexion;  
    DefaultTableModel modelo;
    PreparedStatement pst; 
    ResultSet rs; 
    ResultSetMetaData rsm;
    private Statement stmt;
    private String sql;
    
    public AlumnoControlador() throws SQLException, ClassNotFoundException{
    alumno = new Alumno();
    conexion = Conexion.obtenerConexion();
    modelo= new DefaultTableModel();
    }

    
    public void llenarTablaAlumno (JTable tabla) throws SQLException{
    DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("id");
        modelo2.addColumn("matricula");
        modelo2.addColumn("nombre");
        modelo2.addColumn("apellido");
        modelo2.addColumn("documento");      

        tabla.setModel(modelo2);
        
        String consulta = "SELECT a.id_alumno, a.matricula, p.nombre, p.apellido, p.documento\n" +
"FROM Public.\"Alumnos\" a\n" +
"INNER JOIN Public.\"Personas\" p ON a.id_persona = p.id_persona";
        
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


   public void insertarAlumno (Alumno alumno,Persona persona, JTable tabla){
                
        try {
       
        String cadena = "INSERT INTO Public.\"Alumnos\"(matricula,id_persona)\n" +
                        "values (?,?)"; 
        
        pst = conexion.prepareStatement(cadena);
        pst.setInt(1, alumno.getMatricula());
        pst.setObject(2, persona.getId_persona());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            
        llenarTablaAlumno(tabla);
        
        } catch (SQLException | HeadlessException e) {  
            System.out.println("Error. No se pudo registrar");
            JOptionPane.showMessageDialog(null, "No se puede registrar un alumno con el mismo legajo");
        }   
    }
   
       public void eliminarAlumno(Alumno alumno,JTable tabla){  
            try {    
                
                String consulta = "DELETE FROM Public.\"Alumnos\"\n" +
" WHERE Public.\"Alumnos\".id_alumno= ?";
                pst = conexion.prepareStatement(consulta);
                pst.setInt(1, alumno.getId_alumno());                   
                pst.execute();
                
                llenarTablaAlumno(tabla);
                JOptionPane.showMessageDialog(null, "Éxito al eliminar");
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

}
