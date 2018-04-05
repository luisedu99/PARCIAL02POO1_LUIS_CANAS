/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

/**
 *
 * @author luisedu
 */
public class Piezas {
    
    private int codigoPiez;
    private String nombPiez;
    private String tipoPiez;
    private String marcPiez;

    public Piezas() {
    }

    public Piezas(int codigoPiez, String nombPiez, String tipoPiez, String marcPiez) {
        this.codigoPiez = codigoPiez;
        this.nombPiez = nombPiez;
        this.tipoPiez = tipoPiez;
        this.marcPiez = marcPiez;
    }

    public int getCodigoPiez() {
        return codigoPiez;
    }

    public void setCodigoPiez(int codigoPiez) {
        this.codigoPiez = codigoPiez;
    }

    public String getNombPiez() {
        return nombPiez;
    }

    public void setNombPiez(String nombPiez) {
        this.nombPiez = nombPiez;
    }

    public String getTipoPiez() {
        return tipoPiez;
    }

    public void setTipoPiez(String tipoPiez) {
        this.tipoPiez = tipoPiez;
    }

    public String getMarcPiez() {
        return marcPiez;
    }

    public void setMarcPiez(String marcPiez) {
        this.marcPiez = marcPiez;
    }
    
    @Override
    public String toString() {
        return nombPiez;
    }
    
}
