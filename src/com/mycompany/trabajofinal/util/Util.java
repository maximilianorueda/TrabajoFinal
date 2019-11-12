/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajofinal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maximiliano
 */
public class Util {
    public static Date convertirFechaDate(String fecha){
         Date fechaDate = null;
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         try {
             fechaDate=sdf.parse(fecha);
         } catch (ParseException ex) {
             Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
         }
         return fechaDate;
     }
    
    
}
