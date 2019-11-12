package com.mycompany.trabajofinal.controladores;

import com.mycompany.trabajofinal.objetos.Alumno;
import com.mycompany.trabajofinal.objetos.Cargo;
import com.mycompany.trabajofinal.objetos.Docente;
import com.mycompany.trabajofinal.objetos.Grado;
import com.mycompany.trabajofinal.objetos.Persona;
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



public class GradoControlador {
    Grado grado;
    Connection conexion;  
    DefaultTableModel modelo;
    PreparedStatement pst; 
    ResultSet rs; 
    ResultSetMetaData rsm;
    private Statement stmt;
    private String sql;
    
    public GradoControlador() throws SQLException, ClassNotFoundException{
    grado = new Grado();
    conexion = Conexion.obtenerConexion();
    modelo= new DefaultTableModel();
    }

    
    public void llenarTablaGrado (JTable tabla) throws SQLException{
    DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("id");
        modelo2.addColumn("numero");
        modelo2.addColumn("seccion");
        modelo2.addColumn("nombre doc.");
        modelo2.addColumn("apellido doc.");
        modelo2.addColumn("documento");
        modelo2.addColumn("cargo");
        modelo2.addColumn("turno");
        

        
           
        tabla.setModel(modelo2);
        
        String consulta = "SELECT g.id_grado, g.numero, g.seccion, p.nombre,p.apellido, p.documento,c.descripcion, t.descripcion\n" +
"FROM Public.\"Grados\" g\n" +
"INNER JOIN Public.\"Docentes\" d ON g.id_docente = d.id_docente\n" +
"INNER JOIN Public.\"Personas\" p ON p.id_persona = d.id_persona\n" +
"INNER JOIN Public.\"Cargos\" c ON c.id_cargo = d.id_cargo\n"+
"INNER JOIN Public.\"Turnos\" t ON t.id_turno = g.id_turno\n";
        
        pst = conexion.prepareStatement(consulta);    
        rs = pst.executeQuery();
        rsm=rs.getMetaData();
        
        while (rs.next()){
            Object[] fila = new Object[rsm.getColumnCount()];
            fila[0] = rs.getInt(1); //id
            fila[1] = rs.getInt(2);
            fila[2] = rs.getString(3);
            fila[3] = rs.getString(4);
            fila[4] = rs.getString(5);
            fila[5] = rs.getInt(6);
            fila[6] = rs.getString(7);
            fila[7] = rs.getString(8);
            
            modelo2.addRow(fila);
        }}
    
    
public ArrayList<Docente> llenarComboDocente() throws SQLException {
        ArrayList<Docente> docentes = new ArrayList<>();
        String consulta = "SELECT d.legajo, p.nombre, p.apellido, c.descripcion\n" +
"FROM Public.\"Docentes\" d\n" +
"INNER JOIN Public.\"Personas\" p ON p.id_persona = d.id_persona\n" +
"INNER JOIN Public.\"Cargos\" c ON c.id_cargo = d.id_cargo";
        pst = conexion.prepareStatement(consulta);
        ResultSet rs = null;
        rs = pst.executeQuery();

        while (rs.next()) {
            Docente docente = new Docente();
            Persona persona = new Persona();
            Cargo cargo = new Cargo();
            
            docente.setLegajo(rs.getInt(1));
            persona.setNombre(rs.getString(2));
            persona.setApellido(rs.getString(3));
            cargo.setDescripcion(rs.getString(4));
            
            docente.setPersona(persona);
            docente.setCargo(cargo);
            
            docentes.add(docente);
        }
        rs.close();

        return docentes;
    }

public ArrayList<Turno> llenarComboTurno() throws SQLException {
        ArrayList<Turno> turnos = new ArrayList<>();
        String consulta = "SELECT t.codigo, t.descripcion\n" +
"FROM Public.\"Turnos\" t";
        pst = conexion.prepareStatement(consulta);
        ResultSet rs = null;
        rs = pst.executeQuery();

        while (rs.next()) {
            Turno turno = new Turno();
            turno.setCodigo(rs.getInt(1));
            turno.setDescripcion(rs.getString(2));
                    
            turnos.add(turno);
        }
        rs.close();

        return turnos;
    }
   public void insertarGrado (Grado grado,Docente docente, Turno turno, JTable tabla){
                
        try {
       
        String cadena = "INSERT INTO Public.\"Grados\"(numero, seccion,id_docente,id_turno)\n" +
                        "values (?,?,?,?)"; 
        
        pst = conexion.prepareStatement(cadena);
        pst.setInt(1, grado.getNumero());
        pst.setObject(2, grado.getSeccion());
        pst.setObject(3, docente.getId_docente());
        pst.setObject(4,turno.getId_turno());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            
        llenarTablaGrado(tabla);
        
        } catch (SQLException | HeadlessException e) {  
            System.out.println("Error. No se pudo registrar");
            JOptionPane.showMessageDialog(null, "No se puede registrar un grado con el mismo legajo");
        }   
    }
   
       public void eliminarGrado(Grado grado,JTable tabla){  
            try {    
                
                String consulta = "DELETE FROM Public.\"Grados\"\n" +
" WHERE Public.\"Grados\".id_grado= ?";
                pst = conexion.prepareStatement(consulta);
                pst.setInt(1, grado.getId_grado());                   
                pst.execute();
                
                llenarTablaGrado(tabla);
                JOptionPane.showMessageDialog(null, "Éxito al eliminar");
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

}
