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
public class Bodega {
    
    private int codigoBode;
    private Piezas codiPiez; // la referencia -Llave foránea-
    private Proveedores codiProv; // la referencia -Llave foránea-
    private int cantidad;
    private String fecha;
    

    public Bodega() {
    }

    public Bodega(int codigoBode, Piezas codiPiez, Proveedores codiProv, int cantidad, String fecha) {
        this.codigoBode = codigoBode;
        this.codiPiez = codiPiez;
        this.codiProv = codiProv;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getCodigoBode() {
        return codigoBode;
    }

    public void setCodigoBode(int codigoBode) {
        this.codigoBode = codigoBode;
    }

    public Piezas getCodiPiez() {
        return codiPiez;
    }

    public void setCodiPiez(Piezas codiPiez) {
        this.codiPiez = codiPiez;
    }

    public Proveedores getCodiProv() {
        return codiProv;
    }

    public void setCodiProv(Proveedores codiProv) {
        this.codiProv = codiProv;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString() {
        return String.valueOf(codigoBode);
    }  
}
