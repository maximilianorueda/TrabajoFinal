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
public class Cargo {
    private Integer id_cargo;
    private Integer codigo;
    private String descripcion;

    public Cargo() {
    }

    public Cargo(Integer id_cargo, Integer codigo, String descripcion) {
        this.id_cargo = id_cargo;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
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
        return "Cargo{" + "codigo=" + codigo + ", descripcion=" + descripcion + '}';
    }
    
   }
