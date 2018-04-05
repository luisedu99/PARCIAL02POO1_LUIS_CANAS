/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisedu
 */
public class Proveedores {
    
    private int codigoProv;
    private String nombProv;
    private String direProve;
    private String teleProv;

    public Proveedores() {
    }

    public Proveedores(int codigoProv, String nombProv, String direProve, String teleProv) {
        this.codigoProv = codigoProv;
        this.nombProv = nombProv;
        this.direProve = direProve;
        this.teleProv = teleProv;
    }

    public int getCodigoProv() {
        return codigoProv;
    }

    public void setCodigoProv(int codigoProv) {
        this.codigoProv = codigoProv;
    }

    public String getNombProv() {
        return nombProv;
    }

    public void setNombProv(String nombProv) {
        this.nombProv = nombProv;
    }

    public String getDireProve() {
        return direProve;
    }

    public void setDireProve(String direProve) {
        this.direProve = direProve;
    }

    public String getTeleProv() {
        return teleProv;
    }

    public void setTeleProv(String teleProv) {
        this.teleProv = teleProv;
    }

    
    
    @Override
    public String toString() {
        return nombProv;
    }
    
}
