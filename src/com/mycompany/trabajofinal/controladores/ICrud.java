/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajofinal.controladores;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author hugo
 */
public interface ICrud<T> {
    
    public boolean crear(T entidad);
    public boolean eliminar(T entidad);
    public T extraer(int id);
    public boolean modificar(T entidad);
    public ArrayList<T> listar(JTable tabla);
    
}
