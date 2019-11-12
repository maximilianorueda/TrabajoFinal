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
public class Alumno {
    private Integer id_alumno;
    private Integer matricula;
    private Persona persona;

    public Alumno() {
    }

    public Alumno(Integer id_alumno, Integer matricula, Persona persona) {
        this.id_alumno = id_alumno;
        this.matricula = matricula;
        this.persona = persona;
    }

    public Integer getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Integer id_alumno) {
        this.id_alumno = id_alumno;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Alumno{" + "matricula=" + matricula + ", persona=" + persona + '}';
    }
    
    
}
