/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajofinal.objetos;

/**
 *
 * @author maximiliano
 */
public class Grado {
    private Integer id_grado;
    private Integer numero;
    private String seccion;
    private Docente docente;
    private Turno turno;

    public Grado() {
    }

    public Grado(Integer id_grado, Integer numero, String seccion, Docente docente, Turno turno) {
        this.id_grado = id_grado;
        this.numero = numero;
        this.seccion = seccion;
        this.docente = docente;
        this.turno = turno;
    }

    public Integer getId_grado() {
        return id_grado;
    }

    public void setId_grado(Integer id_grado) {
        this.id_grado = id_grado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Grado{" + "numero=" + numero + ", seccion=" + seccion + ", docente=" + docente + ", turno=" + turno + '}';
    }
    
    
}
