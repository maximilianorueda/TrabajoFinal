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
public class Turno {
    private Integer id_turno;
    private Integer codigo;
    private String descripcion;

    public Turno() {
    }

    public Turno(Integer id_turno, Integer codigo, String descripcion) {
        this.id_turno = id_turno;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Integer getId_turno() {
        return id_turno;
    }

    public void setId_turno(Integer id_turno) {
        this.id_turno = id_turno;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Turno{" + "codigo=" + codigo + ", descripcion=" + descripcion + '}';
    }
    
    
}
