/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajofinal.objetos;

import com.mycompany.trabajofinal.ui.vPrincipal;
import com.mycompany.trabajofinal.util.Conexion;
import java.sql.SQLException;

/**
 *
 * @author maximiliano
 */
public class TrabajoFinal {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Conexion conectarBD = new Conexion();
        Conexion.obtenerConexion();
        
        
     
    }
    
}
