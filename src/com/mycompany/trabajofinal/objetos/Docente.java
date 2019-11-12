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
public class Docente {
    private Integer id_docente;
    private Integer legajo;
    private Persona persona;
    private Cargo cargo;

    public Docente() {
    }

    public Docente(Integer id_docente, Integer legajo, Persona persona, Cargo cargo) {
        this.id_docente = id_docente;
        this.legajo = legajo;
        this.persona = persona;
        this.cargo = cargo;
    }

    public Integer getId_docente() {
        return id_docente;
    }

    public void setId_docente(Integer id_docente) {
        this.id_docente = id_docente;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Docente{" + "legajo=" + legajo + ", persona=" + persona + ", cargo=" + cargo + '}';
    }
    
    
}
